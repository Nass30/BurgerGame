package tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	// STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile emptyTile = new EmptyTile(0);
	public static Tile platformTile = new PlatformTile(1);
	public static Tile ladder1Tile = new LadderTile(2);
	public static Tile ladder2Tile = new LadderTile(3);
	public static Tile ladder3Tile = new LadderTile(4);
	public static Tile ladder4Tile = new LadderTile(5);
	public static Tile emptySolidTile = new EmptyTile(6);

	// CLASS
	public static int 	WIDTH = 55,
						HEIGHT = 30;
	private int width, height;
	protected BufferedImage texture;
	protected final int id;
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		this.width = WIDTH;
		this.height = HEIGHT;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, WIDTH, HEIGHT, null);
		g.setColor(Color.RED);
		//if (isSolid())
		//	g.drawRect(x, y, WIDTH, HEIGHT);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}
	
}
