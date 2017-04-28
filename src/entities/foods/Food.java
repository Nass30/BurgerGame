package entities.foods;

import java.awt.Graphics;
import java.awt.Rectangle;

import Package.Handler;
import entities.Entity;
import entities.foods.FoodPart.TYPEFOOD;
import tiles.Tile;

public class Food {

	public FoodPart leftPart;
	public FoodPart middlePart;
	public FoodPart rightPart;
	private Handler handler;

	private int line;
	private int column;
	private int lineInArray, columnInArray;
	
	private boolean down;
		
	public Food(Handler handler,int column, int line,TYPEFOOD typeFood,int lineInArray, int columnInArray) {
		this.leftPart = new FoodPart(handler, column, line, typeFood, FoodPart.PART.Left);
		this.middlePart = new FoodPart(handler, column, line, typeFood, FoodPart.PART.Middle);
		this.rightPart = new FoodPart(handler, column , line, typeFood, FoodPart.PART.Right);
		this.line = line;
		this.column = column;
		this.lineInArray = lineInArray;
		this.columnInArray = columnInArray;
		this.handler = handler;
		down = false;
	}
	
	public void tick() {
		leftPart.tick();
		middlePart.tick();
		rightPart.tick();
		
		if(leftPart.isDown() && rightPart.isDown() && middlePart.isDown()) {
			fall();
		}

	}
	
	public void render(Graphics g) {
		leftPart.render(g);
		rightPart.render(g);
		middlePart.render(g);
	}
	
	public void fall() {
		setDown(false);
		handler.getEntityManager().fallFood(this,false);
	}

	public FoodPart getLeftPart() {
		return leftPart;
	}

	public void setLeftPart(FoodPart leftPart) {
		this.leftPart = leftPart;
	}

	public FoodPart getMiddlePart() {
		return middlePart;
	}

	public void setMiddlePart(FoodPart middlePart) {
		this.middlePart = middlePart;
	}

	public FoodPart getRightPart() {
		return rightPart;
	}

	public void setRightPart(FoodPart rightPart) {
		this.rightPart = rightPart;
	}

	public int getLine() {
		
		return line;
	}

	public void setLine(int line) {
		leftPart.setLine(line);
		rightPart.setLine(line);
		middlePart.setLine(line);
		this.line = line;
	}

	public int getLineInArray() {
		return lineInArray;
	}

	public void setLineInArray(int lineInArray) {
		this.lineInArray = lineInArray;
	}

	public int getColumnInArray() {
		return columnInArray;
	}

	public void setColumnInArray(int columnInArray) {
		this.columnInArray = columnInArray;
	}

	public void setTypeFood(TYPEFOOD typeFood) {
		// TODO Auto-generated method stub
		leftPart.setTypeFood(typeFood);
		rightPart.setTypeFood(typeFood);
		middlePart.setTypeFood(typeFood);

	}

	public int getColumn() {
		// TODO Auto-generated method stub
		return column;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
		leftPart.setDown(down);
		middlePart.setDown(down);
		rightPart.setDown(down);
	}
	
	
	
}