import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Background extends JPanel implements GameComponents{
	
	private int positionx = 0;
	private int positiony = 1200;
	private int speed = 5;
	private Icon icon;
	
	public Background() {
		icon = new ImageIcon(getClass().getResource("starfield.png"));
		//this.setIcon(icon);
	}
	

	@Override
	public void updateComponent() {
		positiony -= speed;
		if ( positiony <600)
			positiony = 1200;
	}

	/*@Override
	public void drawComponent() {
		// TODO Auto-generated method stub
		icon.paintIcon(null, this.getGraphics(), positionx, positiony);
	}*/
	
	@Override
	public void drawComponent() {
		this.repaint();
		/*Image image = null;
		try {
			image = ImageIO.read(getClass().getResource("starfield.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Graphics g = image.getGraphics();
		//g.drawImage(image, positionx, positiony, 800, 600, null);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, 800, 600, 0, positiony, 800, positiony+600, null);*/
	}
	

	public int getPositionx() {
		return positionx;
	}

	public void setPositionx(int positionx) {
		this.positionx = positionx;
	}

	public int getPositiony() {
		return positiony;
	}

	public void setPositiony(int positiony) {
		this.positiony = positiony;
	}
}
