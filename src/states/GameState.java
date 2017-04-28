package states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import Package.Game;
import Package.Handler;
import Package.Score;
import entities.EntityManager;
import entities.creatures.Player;
import gfx.Assets;
import tiles.Tile;
import tiles.worlds.World;

public class GameState extends State{
	
	private World world;
	private EntityManager entities;
	private Score score;
	private Timer timer1;
	
	public GameState(Handler handler) {
		super(handler);
		entities = new EntityManager(handler, new Player(handler, 9 * Tile.WIDTH, 11 * Tile.HEIGHT));
		handler.setEntities(entities);
		world = new World(handler,"ressources/worlds/world1.lvl");
		handler.setWorld(world);
		score = new Score(handler);
		handler.setScore(score);
	}

	@Override
	public void tick() {
		world.tick();
		entities.tick();
		handler.getScore().tick();
		if (handler.getScore().foodPartMissed == 0 || handler.getEntityManager().getPlayer().getHealth() == 0)
			handler.getGame().setEnd(true);

	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		entities.render(g);
		handler.getScore().render(g);
		if (handler.getEntityManager().getPlayer().isHit()) {
			g.setColor(Color.red);
			handler.getEntityManager().getPlayer().setHit(false);

			
		}

	}
	
	
	
	
}
