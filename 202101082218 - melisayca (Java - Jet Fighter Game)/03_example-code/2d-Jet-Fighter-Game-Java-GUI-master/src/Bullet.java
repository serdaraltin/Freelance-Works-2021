import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	private int x;
	private int y;
	private int speed;
	
	public Bullet(int x, int y) {
		this.x = x;
		this.y = y;
		speed=10;
	} 
	public void tick() {
		y -=speed;
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.drawImage(Assets.bullet, x-13,y-4,null);

	}
	
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
}
