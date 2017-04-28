package entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Package.Handler;
import entities.creatures.Creature.TYPECREATURE;
import gfx.Animation;
import gfx.Assets;

public class Monster extends Creature{
	private Handler handler;
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;

	public Monster(Handler handler, float x, float y, int width, int height, TYPECREATURE typeCreature) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		this.handler = handler;
		this.speed = 1.5f;
		bounds = new Rectangle((int)12, (int)37, 25, 12);
		this.typeCreature = typeCreature;
		this.hitBox = new Rectangle((int)(x + 12), (int)(x + 37), 25, 12);
		health = 1;
		switch (typeCreature){
		case Pepper : 	animDown = new Animation(250, Assets.pepper_down);
						animUp = new Animation(250, Assets.pepper_up);
						animLeft = new Animation(250, Assets.pepper_left);
						animRight = new Animation(250, Assets.pepper_right);
			break;
			
		case Salad : 	animDown = new Animation(250, Assets.salad_down);
						animUp = new Animation(250, Assets.salad_up);
						animLeft = new Animation(250, Assets.salad_left);
						animRight = new Animation(250, Assets.salad_right);
			break;
			
		case Egg : 		animDown = new Animation(250, Assets.egg_down);
						animUp = new Animation(250, Assets.egg_up);
						animLeft = new Animation(250, Assets.egg_left);
						animRight = new Animation(250, Assets.egg_right);
			break;
		}
	}

	@Override
	public void tick() {
		animDown.tick();
		animRight.tick();
		animUp.tick();
		animLeft.tick();
		this.hitBox.x = (int) (x + 12);
		this.hitBox.y = (int) (y + 37);
		chasePlayer();
		move();
	}
	
	public void chasePlayer() {
		Player pl = handler.getEntityManager().getPlayer();
		float y = pl.getY() - this.y;
		float x = pl.getX() - this.x;
		if (pl.isActive()) {
			if(x > 0) {// Move Right
				xMove = speed ;
			} else if( x< 0) { // Move Left
				xMove = -speed ;
			} else if (x == 0) { // Don't move x position
				xMove = 0;
			}
		
			if(y > 0) {// Move Down
				yMove = speed ;
			} else if( y< 0) { // Move up
				yMove = -speed ;
			} else if (y == 0) {
				yMove = 0 ;
			}
		} else {
			xMove = 0 ;
			yMove = 0 ;
		}

	}
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width , height, null);
		g.setColor(Color.red);
		//g.fillRect((int) (hitBox.x), (int) (hitBox.y) ,bounds.width,bounds.height);
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
			return animDown.getFrames()[0];
	}

}
