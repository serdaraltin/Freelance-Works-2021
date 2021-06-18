import java.awt.Graphics;

public abstract class State {

	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Game game;
	
	public State(Game game) {
		this.game  = game;
	}
	
	//classes
	public abstract void tick();
	public abstract int getX();
	public abstract int getY();
	public abstract void decHP();
	public abstract int getHP();
	public abstract void render (Graphics g); 
}
