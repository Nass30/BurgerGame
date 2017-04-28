package tiles.worlds;

import java.awt.Graphics;

import Package.Handler;
import entities.EntityManager;
import entities.creatures.Player;
import tiles.Tile;
import utils.Utils;

public class World {
	
	private int width, height;
	private int[][] tiles;
	private Handler handler;
	
	public World(Handler handler,String path) {
		this.handler = handler;
		handler.getEntityManager();
		loadWorld(path);
	}
	
	public void tick() {
	}
	
	public void render(Graphics g) {
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				getTile(x,y).render(g,x * Tile.WIDTH,y * Tile.HEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if( x < 0 || y < 0 || x >= width || y >= height)
			return Tile.emptyTile;
		Tile t = Tile.tiles[tiles[x][y]];
		// System.out.println("get tiles = " + t.getId());
		if (t == null)
			return Tile.emptyTile;
		return t;
	}
	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = 19;
		height = 22;
		tiles = new int[width][height];
		
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x ++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width)]);
			}
		}
	}
}
