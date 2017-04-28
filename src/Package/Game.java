package Package;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Timer;
import java.util.TimerTask;


import display.Display;
import gfx.Assets;
import input.KeyManager;
import states.FinalState;
import states.GameState;
import states.MenuState;
import states.State;

public class Game implements Runnable {
	private Display display;
	private static int DEFAULT_GAME_WIDTH = 1045;
	private static int DEFAULT_GAME_HEIGHT = 1000;
	
	private int width, height;
	private String title;
	private boolean end;

	private boolean running = false;
	private Thread thread;
	private Timer timer1;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	//States 
	private State gameState;
	private State menuState;
	private State finalState;

	//Input
	private KeyManager keyManager;
	
	//Handler
	private Handler handler;
	
	
	public Game(String title) {
		this.height = DEFAULT_GAME_HEIGHT;
		this.width = DEFAULT_GAME_WIDTH;
		this.title = title;
		timer1 = new Timer();
		end = false;
		keyManager = new KeyManager();
	
	}
	
	private void init() {
		display= new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		finalState = new FinalState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);

	}

	private void tick() {
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
		if (end) {
			State.setState(finalState);
		}
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics(); // Créer un Graphics à partir du BufferedStrategy 
		// Clear Screen
		g.clearRect(0, 0, width, height);
		
		// Draw here
		if(State.getState() != null) {
			State.getState().render(g);
		}		
		// End Drawing

		bs.show(); // Dessine le BufferStrategy
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta +=(now-lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if (State.getState() == menuState)
			timer1.schedule(new TimerTask() {
				@Override
				public void run() {
				State.setState(gameState);
				}
			}, 250);
			if(delta>=1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >=1000000000) {
				//System.out.println("Ticks and Frames :" + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	
	public KeyManager getKeyManager() {
		return keyManager;	
	}
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
	
	
	
	
}
