package entities.creatures;

import java.awt.Rectangle;

import Package.Handler;
import entities.Entity;
import entities.foods.Food;
import tiles.Tile;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 5;
	public static final float DEFAULT_SPEED = 1.5f ;
	public static final int DEFAULT_CREATURE_WIDTH = 50;
	public static final int DEFAULT_CREATURE_HEIGHT = 50;


	protected int health;
	protected Rectangle hitBox;
	protected float speed;
	protected float xMove, yMove;
	protected TYPECREATURE typeCreature;
	
	public enum TYPECREATURE {
		Player,
		Salad,
		Pepper,
		Egg,
	}
	
	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	public void move() {
		moveX();
		moveY();
		if(typeCreature == TYPECREATURE.Player) {
			checkCollisionWithFood();
		} else {
			checkCollisionWithPlayer();
		}	
	}
	
	private void checkCollisionWithPlayer() {
		Player pl = handler.getEntityManager().getPlayer(); // Get the player's instance
			if ((this.hitBox.intersects(pl.getHitBox()) || pl.getHitBox().intersects(this.hitBox)) && pl.isActive()) {  
				// check if monster's hitbox collides with player's hitbox
				pl.hit(); // hit if collide
			}
	}

	private void checkCollisionWithFood() {
		for(Food f : handler.getEntityManager().getFoods()) { // for each Food in the ArrayListFood of the EntityManager class
			if((hitBox.intersects(f.getLeftPart().getBounds()) || f.getLeftPart().getBounds().intersects(hitBox)) ) { //check if the player hit box colide with LeftTile hitbox
				f.getLeftPart().setDown(true); // if collid, set down the left part.
			}
			if((hitBox.intersects(f.getMiddlePart().getBounds()) || f.getMiddlePart().getBounds().intersects(hitBox))) { // Same for the middle
					
				f.getMiddlePart().setDown(true);
			}
			if(hitBox.intersects(f.getRightPart().getBounds())|| f.getRightPart().getBounds().intersects(hitBox)) { //Same for the right
				f.getRightPart().setDown(true);
			}
		}
	}

	public void moveX(){
		if(xMove > 0){// Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.WIDTH; // Get the next x position 
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.HEIGHT) &&					// Check if is the next x position will colide with
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.HEIGHT)){// a Solid Tile 
				x += xMove;	// If the Tile is don't a solid tile, move right
			}else{
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.WIDTH;	// Same 
			
			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.HEIGHT ) && //Same
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.HEIGHT)){
				x += xMove;
			}else{
			}
		}
	}
	
	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.HEIGHT; // Same
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.WIDTH, ty)){
				y += yMove;
			}else{
			}
			
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.WIDTH, ty)){
				y += yMove;
			}else{
			}
			
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	
	
	
	
	
	
	
	
	
	// Getters and Setters

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Rectangle getHitBox() {
		return hitBox;
	}

	public void setHitBox(Rectangle hitBox) {
		this.hitBox = hitBox;
	}
	
	
	
}
