package entities.creatures;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


import Package.Handler;
import gfx.Animation;
import gfx.Assets;
import states.State;

import java.util.Timer;
import java.util.TimerTask;


public class Player extends Creature {
	private Handler handler;
	Timer timer = new Timer();
	private Timer timer1;
	private boolean active;
	private boolean hit;

	//Animations
	private Animation animDown, animUp, animLeft, animRight;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		timer1 = new Timer();
		this.speed = 3.0f;
		this.hit = false;
		this.active = true;
		this.handler = handler;
		bounds = new Rectangle((int)12, (int)37, 25, 12);
		this.typeCreature = TYPECREATURE.Player;
		this.hitBox = new Rectangle((int)(x + 12), (int)(x + 37), 25, 12);
		animDown = new Animation(250, Assets.player_down);
		animUp = new Animation(250, Assets.player_up);
		animLeft = new Animation(250, Assets.player_left);
		animRight = new Animation(250, Assets.player_right);
	}

	@Override
	public void tick() {
		animDown.tick();
		animRight.tick();
		animUp.tick();
		animLeft.tick();
		this.hitBox.x = (int) (x + 12);
		this.hitBox.y = (int) (y + 37);
		getInput();
		move();
	}
	public void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up) {
			yMove = -speed;
		}
		if(handler.getKeyManager().down) {
			yMove = speed;
		}
		if(handler.getKeyManager().left) {
			xMove = -speed;
		}
		if(handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		if(this.isActive()) {
			g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width , height, null);
		} else {
			Graphics2D g2 = (Graphics2D) g;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
			g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width , height, null);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		}
		g.setColor(Color.red);

		//g.fillRect((int) (hitBox.x), (int) (hitBox.y) ,bounds.width,bounds.height);
	}
	
	public void hit() {
		health -=1;
		handler.getScore().score-=500;
		System.out.println("A Monster hits the Player !! Health : " +health);
		hit = true;
		
		this.active = false;
		timer1.schedule(new TimerTask() {
			@Override
			public void run() {
				handler.getEntityManager().getPlayer().setActive(true);
			}
		}, 3000);
		
	}
	
	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentImage();
		} else if (xMove > 0) {
			return animRight.getCurrentImage();
		} else if (yMove < 0) {
			return animUp.getCurrentImage();
		} else if (yMove > 0) {
			return animDown.getCurrentImage();
		} else
			return Assets.player;
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}
	
}
