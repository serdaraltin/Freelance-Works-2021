import java.awt.Color;
import java.awt.Graphics;

public class EnemyLaser {
	private int x;
	private int y;
	private int speed;
	
	
	public EnemyLaser(int x, int y) {
		this.x = x;
		this.y = y;
		speed=5;
	}
	
	public void tick() {
		y +=speed;
	}

	public void render(Graphics g) {
		g.setColor(Color.RED);
	   // g.fillRect(x, y, 6, 10);
		g.drawImage(Assets.enemyLaser, x-13,y-4,null);

	}
	
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
}
