package a3;

import java.util.Scanner;
import a3.gameObjects.FixedObject;
import a3.gameObjects.Food;
import a3.gameObjects.Money;
import a3.gameObjects.MovableObject;
import a3.gameObjects.Walls;

public interface IGameWorld {
	public void initLayout();
	public void moveWest();
	public void moveEast();
	public void moveSouth();
	public void moveNorth();
	public void bodyCollide();
	public void birdCollide();
	public void moneyCollide();
	public void foodCollide();
	public void wallCollide();
	public void clockTick(float time);
	public void display();
	public void map();
	public void quit();
	public void makeFood();
	public int getLives();
	public int getScore();
	public int getClock();
	public boolean isSound();
}
