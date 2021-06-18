import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Player implements GameComponents{
	private BufferedImage playerImage;
	private Icon playerShipIdle, playerShipLeft, playerShipRight;
	private final int playerWidth = 50;
	private final int playerHeight = 56;
	private int playerLocx;
	private int playerLocy;
	private int speed;
	private int health;
	private boolean isMovingLeft, isMovingRight, isMovingUp, isMovingDown, isMoving,hit;
	public Player() {
		playerShipIdle = new ImageIcon(getClass().getResource("playerI.png"));
		//this.setIcon(playerShipIdle);
		//this.setOpaque(false);
				
		setHealth(100);
		speed = 5;
		playerLocx=400;
		playerLocy=450;
				
		isMovingLeft = false;
		isMovingRight = false;
		isMovingDown = false;
		isMovingUp = false;
		isMoving = false;
		hit = false;
				
		try {
			playerImage = ImageIO.read(getClass().getResource("playerI.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		//g = this.getGraphics();
		//Graphics2D g2 = (Graphics2D) g;
		//g2.drawImage(playerImage, this.getPlayerLocx(), this.getPlayerLocy(), null);
		//g2.drawImage(playerImage, 0, 0, null);
		//playerShip.paintIcon(this, g, 0, 0);
	}

	
	@Override
	public void updateComponent() {
		if ( this.isMovingDown && ( this.playerLocy+speed < 600-this.playerHeight ) ) {
			this.playerLocy+=speed;
		}
		if ( this.isMovingUp && ( this.playerLocy-speed > 0 ) ) {
			this.playerLocy-=speed;
		}
		if ( this.isMovingLeft && ( this.playerLocx-speed > 0 ) ) {
			this.playerLocx-=speed;
		}
		if ( this.isMovingRight && ( this.playerLocx+speed < 800-this.playerWidth ) ) {
			this.playerLocx+=speed;
		}
	}

	@Override
	public void drawComponent() {
		if ( this.isMovingLeft && this.isMovingRight) {
			playerShipIdle = new ImageIcon(getClass().getResource("playerI.png"));
			//this.setIcon(playerShipIdle);
		}
		else if ( this.isMovingLeft ) {
			playerShipLeft = new ImageIcon(getClass().getResource("playerL.png"));
			//this.setIcon(playerShipLeft);
		}
		else if ( this.isMovingRight ) {
			playerShipRight = new ImageIcon(getClass().getResource("playerR.png"));
			//this.setIcon(playerShipRight);
		}
		else {
			playerShipIdle = new ImageIcon(getClass().getResource("playerI.png"));
			//this.setIcon(playerShipIdle);
		}
	}
	
	public boolean moving() {
		if ( (this.isMovingLeft && this.isMovingRight) || (this.isMovingDown && this.isMovingUp) ) {
			return false;
		}
		else if (this.isMovingDown || this.isMovingLeft || this.isMovingRight || this.isMovingUp) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getPlayerLocx() {
		return playerLocx;
	}

	public void setPlayerLocx(int playerLocx) {
		this.playerLocx = playerLocx;
	}

	public int getPlayerLocy() {
		return playerLocy;
	}

	public void setPlayerLocy(int playerLocy) {
		this.playerLocy = playerLocy;
	}

	public int getPlayerWidth() {
		return playerWidth;
	}

	public int getPlayerHeight() {
		return playerHeight;
	}

	public boolean isMovingLeft() {
		return isMovingLeft;
	}

	public void setMovingLeft(boolean isMovingLeft) {
		this.isMovingLeft = isMovingLeft;
	}

	public boolean isMovingRight() {
		return isMovingRight;
	}

	public void setMovingRight(boolean isMovingRight) {
		this.isMovingRight = isMovingRight;
	}

	public boolean isMovingUp() {
		return isMovingUp;
	}

	public void setMovingUp(boolean isMovingUp) {
		this.isMovingUp = isMovingUp;
	}

	public boolean isMovingDown() {
		return isMovingDown;
	}

	public void setMovingDown(boolean isMovingDown) {
		this.isMovingDown = isMovingDown;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}


}
