package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


import Package.Handler;
import gfx.Assets;
import utils.Utils;

public class FinalState extends State{
	private int bestScore;
	private boolean newScore;

	public FinalState(Handler handler) {
		super(handler);
		String file = Utils.loadFileAsString("ressources/scores.txt");
		file = file.replace("\n", "");
		newScore = false;
		bestScore = Utils.parseInt(file);
		System.out.println("Best Score : "+bestScore);
		
	}

	@Override
	public void tick() {
		if (handler.getScore().score > bestScore) {
			newScore = true;
			Utils.writeFile(handler.getScore().score + "", "ressources/scores.txt");
			bestScore = handler.getScore().score;
		}
	}

	@Override
	public void render(Graphics g) {
		if (newScore) {
			g.drawImage(Assets.newHighImage, 300, 200,null);
		}
		g.setColor(Color.red);
		Font font = new Font("Courier",50,50);
		g.setFont(font);
		if(handler.getEntityManager().getPlayer().getHealth() == 0) {
			g.drawString("YOU LOSE, TRY AGAIN !", (int)200, (int) handler.getGame().getHeight()/2);
		} else {
			g.drawString("YOU WIN THIS FABULOUS GAME !",(int)100, (int) handler.getGame().getHeight()/2);
		}
		g.drawString("Your score : " + handler.getScore().score,(int)100, (int) 700);
		g.drawString("Best score : " + bestScore,(int)300, (int) 850);

	}
	public void refreshScore() {
		String file = Utils.loadFileAsString("ressources/scores.txt");
		file = file.replace("\n", "");
		newScore = false;
		bestScore = Utils.parseInt(file);
		System.out.println("Best Score : "+bestScore);
		if (handler.getScore().score > bestScore) {
			newScore = true;
			Utils.writeFile(handler.getScore().score + "", "ressources/scores.txt");
			bestScore = handler.getScore().score;
		}
	}
}
