package a3;

public class GameWorldProxy implements IObservable, IGameWorld{
	private GameWorld realGameWorld; 
	
	public GameWorldProxy(GameWorld gw){
		realGameWorld = gw;
	}
	
	public void initLayout(){
		//realGameWorld.initLayout();
	}
	public void moveWest(){
		//realGameWorld.moveWest();
	}
	public void moveEast(){
		//realGameWorld.moveEast();
	}
	public void moveSouth(){
		//realGameWorld.moveSouth();
	}
	public void moveNorth(){
		//realGameWorld.moveNorth();
	}
	public void bodyCollide(){
		//realGameWorld.bodyCollide();
	}
	public void birdCollide(){
		//realGameWorld.birdCollide();
	}
	public void moneyCollide(){
		//realGameWorld.moneyCollide();
	}
	public void foodCollide(){
		//realGameWorld.foodCollide();
	}
	public void wallCollide(){
		//realGameWorld.wallCollide();
	}
	public void clockTick(float time){
		//realGameWorld.clockTick();
	}
	public void display(){
		realGameWorld.display();
	}
	public void map(){
		realGameWorld.map();
	}
	public void quit(){
		//realGameWorld.quit();
	}
	public void makeFood(){
		//realGameWorld.makeFood();
	}
	public int getLives(){
		return realGameWorld.getLives();
	}
	public void setLives(int lives){
		//realGameWorld.setLives(lives);
	}
	
	public int getScore() {
		return realGameWorld.getScore();
	}
	public int getClock() {
		return realGameWorld.getClock();
	}
	public boolean isSound() {
		return realGameWorld.isSound();
	}
	
	public void addObserver (IObserver obs){
		
	}
	
	public void notifyObservers () {
		
	}
}
