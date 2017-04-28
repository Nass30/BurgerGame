package entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import Package.Handler;
import entities.creatures.*;
import entities.creatures.Creature.TYPECREATURE;
import entities.foods.Food;
import entities.foods.FoodPart;
import entities.foods.FoodPart.TYPEFOOD;
import tiles.Tile;

public class EntityManager {
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private ArrayList<Food> foods;
	private ArrayList<Creature> creatures;
	private Food[][] foodManager;
	

	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		initEntities();
	}

	private void initEntities() { 
		entities = new ArrayList<Entity>();
		foods = new ArrayList<Food>();
		creatures = new ArrayList<Creature>();
		createCreatureEntities();
		createFoodEntities();
		initFoodManager();
		printFoodEntities();
		System.out.println();
	}
	private void createCreatureEntities() {
		creatures.add(new Monster(handler, Tile.WIDTH, Tile.HEIGHT, 20, 20, TYPECREATURE.Salad));
		creatures.add(new Monster(handler, 17 *Tile.WIDTH, Tile.HEIGHT, 20, 20, TYPECREATURE.Egg));
		creatures.add(new Monster(handler, Tile.WIDTH, 19*Tile.HEIGHT, 20, 20, TYPECREATURE.Pepper));
		creatures.add(new Monster(handler, 17*Tile.WIDTH, 19*Tile.HEIGHT, 20, 20, TYPECREATURE.Salad));
	}

	private void printFoodEntities() {
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 4 ; j++) {
				if(foodManager[i][j] == null || foodManager[i][j].getLeftPart().getTypeFood() == TYPEFOOD.None) {
					System.out.print("NO FOOD ");
				} else { 
					System.out.print(foodManager[i][j].getLeftPart().getTypeFood().toString() + " ");
				}
			}
			System.out.println();

		}
	}
	private void createFoodEntities() {
		foods.add(new Food(handler,2,2,TYPEFOOD.TopBread,0,0));	foods.add(new Food(handler,6,2,TYPEFOOD.TopBread,0,1));	foods.add(new Food(handler,10,2,TYPEFOOD.TopBread,0,2));foods.add(new Food(handler,14,2,TYPEFOOD.TopBread,0,3));
		foods.add(new Food(handler,2,6,TYPEFOOD.Salad,1,0));	foods.add(new Food(handler,6,8,TYPEFOOD.Salad,1,1));	foods.add(new Food(handler,10,6,TYPEFOOD.Salad,1,2));	foods.add(new Food(handler,14,6,TYPEFOOD.Salad,1,3));
		foods.add(new Food(handler,2,10,TYPEFOOD.Meal,2,0));	foods.add(new Food(handler,6,12,TYPEFOOD.Meal,2,1));	foods.add(new Food(handler,10,12,TYPEFOOD.Meal,2,2));	foods.add(new Food(handler,14,10,TYPEFOOD.Meal,2,3));
		foods.add(new Food(handler,2,16,TYPEFOOD.Tomato,3,0));	foods.add(new Food(handler,6,16,TYPEFOOD.Tomato,3,1));	foods.add(new Food(handler,10,16,TYPEFOOD.Tomato,3,2));	foods.add(new Food(handler,14,14,TYPEFOOD.Tomato,3,3));
		foods.add(new Food(handler,2,20,TYPEFOOD.BotBread,4,0));foods.add(new Food(handler,6,20,TYPEFOOD.BotBread,4,1));foods.add(new Food(handler,10,20,TYPEFOOD.BotBread,4,2));foods.add(new Food(handler,14,20,TYPEFOOD.BotBread,4,3));
		
		foods.add(new Food(handler,2,22,TYPEFOOD.None, 5, 0));	foods.add(new Food(handler,6,22,TYPEFOOD.None, 5, 1));	foods.add(new Food(handler,10,22,TYPEFOOD.None, 5, 2));	foods.add(new Food(handler,14,22,TYPEFOOD.None, 5, 3));
		foods.add(new Food(handler,2,23,TYPEFOOD.None, 6, 0));	foods.add(new Food(handler,6,23,TYPEFOOD.None, 6, 1));	foods.add(new Food(handler,10,23,TYPEFOOD.None, 6, 2));	foods.add(new Food(handler,14,23,TYPEFOOD.None, 6, 3));
		foods.add(new Food(handler,2,24,TYPEFOOD.None, 7, 0));	foods.add(new Food(handler,6,24,TYPEFOOD.None, 7, 1));	foods.add(new Food(handler,10,24,TYPEFOOD.None, 7, 2));	foods.add(new Food(handler,14,24,TYPEFOOD.None, 7, 3));
		foods.add(new Food(handler,2,25,TYPEFOOD.None, 8, 0));	foods.add(new Food(handler,6,25,TYPEFOOD.None, 8, 1));	foods.add(new Food(handler,10,25,TYPEFOOD.None, 8, 2));	foods.add(new Food(handler,14,25,TYPEFOOD.None, 8, 3));
		foods.add(new Food(handler,2,26,TYPEFOOD.None, 9, 0));	foods.add(new Food(handler,6,26,TYPEFOOD.None, 9, 1));	foods.add(new Food(handler,10,26,TYPEFOOD.None, 9, 2));	foods.add(new Food(handler,14,26,TYPEFOOD.None, 9, 3));
		foods.add(new Food(handler,2,27,TYPEFOOD.Platform, 10, 0));	foods.add(new Food(handler,6,27,TYPEFOOD.Platform, 10, 1));	foods.add(new Food(handler,10,27,TYPEFOOD.Platform, 10, 2));foods.add(new Food(handler,14,27,TYPEFOOD.Platform, 10, 3));

	}
	public void fallFood(Food f, boolean cascade) {
		int c = f.getColumnInArray();
		int l = f.getLineInArray();
		if((foodManager[l+1][c].getLeftPart().getTypeFood() != TYPEFOOD.Platform && f.getLeftPart().getTypeFood() != TYPEFOOD.None)) {
			System.out.println(f.getLeftPart().getTypeFood() +" falls at Line = " + f.getLineInArray() + " and Column = " + f.getColumnInArray()); 
			Food actualFood = f;
			Food nextFood = foodManager[l+1][c];
			if(!cascade)
			foodManager[l][c] = new Food(handler, actualFood.getColumn(),actualFood.getLine(), TYPEFOOD.None, l, c);
			while(f.getLine() != nextFood.getLine()) {
				f.setLine(f.getLine() + 1);
			}
			f.setLineInArray(f.getLineInArray() + 1);
			foodManager[l+1][c] = f;
			f.setDown(false);
			if(l == 4)
				handler.getScore().foodPartMissed--;
			if(!cascade)
				handler.getScore().score+=100;
			handler.getScore().score+=50;
			f.tick();
			System.out.println();

			fallFood(nextFood,true);
		}
		
		
	}
	
	private void initFoodManager() {
		foodManager = new Food[11][4];
		int t = 0;
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 4 ; j++) {
				foodManager[i][j] = foods.get(t);
				t++;
			}
		}
		System.out.println("initFoodManager : Done");
	}

	public void tick() {
		player.tick();

		for (int i = 0; i < foods.size(); i++) {
			Food f = foods.get(i);
			f.tick();
		}
		for (int i = 0; i < creatures.size(); i++) {
			Creature c = creatures.get(i);
			c.tick();
		}
	}
	
	public void render(Graphics g) {
		player.render(g);
		for(Food f : foods) 
			f.render(g);
		for(Creature c : creatures)
			c.render(g);
	}
	
	
	public void addEntity(ArrayList<Entity> al, Entity e) {
		al.add(e);
	}

	public Handler getHandler() {
		return handler;
	}
	
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	


	public Player getPlayer() {
		return player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public ArrayList<Food> getFoods() {
		return foods;
	}

	public void setFoods(ArrayList<Food> foods) {
		this.foods = foods;
	}

	public ArrayList<Creature> getCreatures() {
		return creatures;
	}

	public void setCreatures(ArrayList<Creature> creatures) {
		this.creatures = creatures;
	}
	
}
