package entities.foods;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


import Package.Handler;
import entities.Entity;
import gfx.Assets;
import tiles.PlatformTile;
import tiles.Tile;

public class FoodPart extends Entity {
	public static enum TYPEFOOD {
		Meal,
		TopBread,
		BotBread,
		Tomato,
		Salad,
		Platform,
		None
	}
	public static enum PART {
		Left,
		Right,
		Middle
	}
	private PART part;
	private TYPEFOOD typeFood;
	private int line;
	private int column;
	private BufferedImage texture;
	private boolean down;
	

public FoodPart(Handler handler, int column, int line, TYPEFOOD typeFood, PART part) {
		super(handler, column * Tile.WIDTH, line * Tile.HEIGHT, Tile.WIDTH, Tile.HEIGHT);
		this.line = line;
		this.typeFood = typeFood;
		this.part = part;
		this.column = column;
		this.x = column * Tile.WIDTH;
		this.y = line * Tile.HEIGHT;
		this.bounds = new Rectangle((int)x, (int) y, width, height);
		down = false;

		switch (typeFood){
		case Meal: switch (part) {
					case Left :		this.texture = Assets.meal1;
						break;
					case Middle :	this.column++;
									this.texture = Assets.meal2;
						break;
					case Right :	this.column++;
									this.column++;
									this.texture = Assets.meal3;
						break;
					}
			break;
		case TopBread: switch (part) {
					case Left :		this.texture = Assets.topBread1;
						break;
					case Middle :	this.column++;
									this.texture = Assets.topBread2;
						break;
					case Right :	this.column++;
									this.column++;
									this.texture = Assets.topBread3;
						break;
					}
			break;
		case Tomato: switch (part) {
					case Left :		this.texture = Assets.tomato1;
						break;
					case Middle :	this.column++;
									this.texture = Assets.tomato2;
						break;
					case Right :	this.column++;
									this.column++;
									this.texture = Assets.tomato3;
						break;
					}
			break;
		case BotBread: switch (part) {
					case Left :		this.texture = Assets.botBread1;
						break;
					case Middle :	this.column++;
									this.texture = Assets.botBread2;
						break;
					case Right :	this.column++;
									this.column++;
									this.texture = Assets.botBread3;
						break;
		}
			break;
		case Salad: switch (part) {
					case Left :		this.texture = Assets.salad1;
						break;
					case Middle :	this.column++;
									this.texture = Assets.salad2;
						break;
					case Right :	this.column++;
									this.column++;
									this.texture = Assets.salad3;
						break;
					}
			break;
		case Platform: switch (part) {
					case Left :		this.texture = Assets.foodPlatform1;
						break;
					case Middle :	this.column++;
									this.texture = Assets.foodPlatform2;
						break;
					case Right :	this.column++;
									this.column++;
									this.texture = Assets.foodPlatform3;
						break;
					}
			break;
		case None:	
			break;
		default:
			break;
			
		}
	}


	@Override
	public void tick() {
		switch (part) {
			case Middle :this.x = (column) *Tile.WIDTH;
						bounds.setBounds((int) x, (int) y, Tile.WIDTH, Tile.HEIGHT);
				break;
			case Right :this.x = (column) *Tile.WIDTH;
						bounds.setBounds((int) x,(int) y, Tile.WIDTH, Tile.HEIGHT);
				break;
		}
		this.y = line * Tile.HEIGHT;
		this.bounds.x = (int)x;
		bounds.y = (int)y;
		
	}


	@Override
	public void render(Graphics g) {
		if(typeFood != TYPEFOOD.None) {
			if (!down) {
				g.drawImage(texture, (int) x, (int) y, width, height, null);
			} else {
				if (typeFood != TYPEFOOD.Platform)
					g.drawImage(texture, (int) x, (int) y + Tile.HEIGHT/2, width, height, null);
			}
		}
		//g.setColor(Color.green);
		//g.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
		//System.out.println("x = " + x + " y = " + y);
	}
	

	public boolean isDown() {
		return down;
	}


	public void setDown(boolean down) {
		this.down = down;
	}


	public PART getPart() {
		return part;
	}


	public void setPart(PART part) {
		this.part = part;
	}


	public TYPEFOOD getTypeFood() {
		return typeFood;
	}


	public void setTypeFood(TYPEFOOD typeFood) {
		this.typeFood = typeFood;
	}


	public int getLine() {
		return line;
	}


	public void setLine(int line) {
		this.line = line;
	}
	
	
}
