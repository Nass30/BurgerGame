package Package;

import entities.EntityManager;
import input.KeyManager;
import tiles.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	private EntityManager entityManager;
	private Score score;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public World getWorld() {
		return world;
	}
	public void setWorld(World world) {
		this.world = world;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntities(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void setScore(Score score) {
		// TODO Auto-generated method stub
		this.score = score;
	}
	public Score getScore() {
		return score;
	}
	

	
	
}
