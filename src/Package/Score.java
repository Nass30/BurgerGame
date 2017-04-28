package Package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import tiles.Tile;

public class Score {
	public int score;
	public int foodPartMissed;
	public Handler handler;
	
	public Score(Handler handler) {
		this.handler = handler;
		score = 0;
		foodPartMissed = 20;
	}
	
	public void tick() {
		if (score < 0)
			score = 0;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		Font fonte = new Font("Courier",Font.BOLD,30);
		g.setFont(fonte);
		g.drawString("||", 0, 31 * Tile.HEIGHT);
		g.drawString("Health : " + handler.getEntityManager().getPlayer().getHealth() , 1 *Tile.WIDTH, 31 *Tile.HEIGHT);
		g.drawString("||", 5 * Tile.WIDTH, 31 * Tile.HEIGHT);
		g.drawString("Score : " + score, 7 * Tile.WIDTH, 31 * Tile.HEIGHT);
		g.drawString("||", 11 * Tile.WIDTH, 31 * Tile.HEIGHT);
		g.drawString("Food Missing : " + foodPartMissed, 12 * Tile.WIDTH, 31 * Tile.HEIGHT);
		g.drawString("||", 18* Tile.WIDTH, 31 * Tile.HEIGHT);

	}

}
