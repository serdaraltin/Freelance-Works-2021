import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Game extends JFrame implements  KeyListener, Runnable{
	
	
	final int FRAMES_PER_SECOND=60;
	final int SKIP_TICKS = 1000 / FRAMES_PER_SECOND;
	final int MAX_FRAMESKIP = 10;
	private Background backgroundPanel;
	private Background foreground;
	private Player player;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private ArrayList<EnemyShips> enemyShips = new ArrayList<EnemyShips>();
	public JLabel booster;
	private int screenx = 800;
	private int screeny = 600;
	private Integer score;
	private boolean game_is_running = true;
	private boolean explosion = false;
	private boolean mPressed = false, ePressed = false, inputWaiting = true;
	private String username = "Guest", shipName = "", password = "";
	MenuMusic gameMusic;
	Random enemyLoc;
	BufferedImage backgroundImage, playerImageIdle, playerImageLeft, playerImageRight, boosterImage, bulletImage, bulletImage2, bulletImage3, enemyImageS, enemyImageM;
	BufferedImage explosionImage1, explosionImage2, explosionImage3, explosionImage4, explosionImage5,explosionImage6;
	BufferedImage healthBar1, healthBar2;
	Image backbuffer;
	Graphics2D g2d;
	int frame = 0,frame1,frame2,frame3,frame4,frame5,explosionx,explosiony,loop;
	int sec = 0;
	
	public Game() {
		createGui();
		gameMusic = new MenuMusic(3);
	}
	
	public Game(String username, String password, String shipName) {
		this.username = username;
		this.shipName = shipName;
		this.password = password;
		createGui();
		gameMusic = new MenuMusic(3);
	}

	public void createGui(){
		this.setTitle("Jet Fighter");
		setLayout(null);

		screenx = 800;
		screeny = 600;
		score = 0;
		
		backgroundPanel = new Background();
		backgroundPanel.setBounds(0, 0, screenx, screeny);
		this.add(backgroundPanel);
		
		foreground = new Background();
		foreground.setBounds(0, 0, screenx, screeny);
		this.add(foreground);
		//background.setBounds(0, 0, screenx, screeny);
		//add(background);
		
		enemyLoc = new Random();
		
		player = new Player();
		
		
		try {
			backgroundImage = ImageIO.read(getClass().getResource("starfield2.png"));
			playerImageIdle = ImageIO.read(getClass().getResource("playerI.png"));
			playerImageLeft = ImageIO.read(getClass().getResource("playerL.png"));
			playerImageRight = ImageIO.read(getClass().getResource("playerR.png"));
			boosterImage = ImageIO.read(getClass().getResource("booster.png"));
			bulletImage = ImageIO.read(getClass().getResource("bullet1.png"));
			bulletImage2 = ImageIO.read(getClass().getResource("bullet2.png"));
			bulletImage3 = ImageIO.read(getClass().getResource("greenbullet.png"));
			enemyImageS = ImageIO.read(getClass().getResource("enemyShip.png"));
			enemyImageM = ImageIO.read(getClass().getResource("enemy2.png"));
			explosionImage1 = ImageIO.read(getClass().getResource("explosion1.png"));
			explosionImage2 = ImageIO.read(getClass().getResource("explosion2.png"));
			explosionImage3 = ImageIO.read(getClass().getResource("explosion3.png"));
			explosionImage4 = ImageIO.read(getClass().getResource("explosion4.png"));
			explosionImage5 = ImageIO.read(getClass().getResource("explosion5.png"));
			explosionImage6 = ImageIO.read(getClass().getResource("explosion6.png"));
			healthBar1 = ImageIO.read(getClass().getResource("bar.png"));
			healthBar2 = ImageIO.read(getClass().getResource("bar2.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenx, screeny);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.addKeyListener(this);
		
		backbuffer = createImage(getSize().width, getSize().height);
		g2d = (Graphics2D)backbuffer.getGraphics();
		g2d.setFont(new Font("SerifSans", Font.BOLD, 14));
		g2d.setColor(Color.WHITE);

	}
	
	
	public void run() {
		double next_game_tick = System.currentTimeMillis();
		int sleepTime = 0;
		while (game_is_running) {
			//input();
			update();
			render();
			next_game_tick += SKIP_TICKS;
			sleepTime = (int) (next_game_tick - System.currentTimeMillis());
			if ( sleepTime >= 0)
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			else {
			}
			frame++;
			if (frame==61) {
				frame = 1;
				sec++;
			}
			else {
			}
			if (sec==61) {
				sec=1;
			}
			else {
			}
		}
		while(inputWaiting) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (mPressed) {
				dispose();
				MainMenu menu = new MainMenu();
				inputWaiting=false;
			}
			else if (ePressed){
				System.exit(0);
			}
			else {
			}
		}
	}
	

	
	public void update() {																							//Updating Game
		player.updateComponent();
		
		
		//System.out.println("Bullet number: "+bullets.size());
		if (frame == 10 || frame == 40) {																			//Bullet patterns
			//Bullet bullet = new Bullet(player.getX()-3, player.getY()-50);
			Bullet bullet = new Bullet(player.getPlayerLocx()-3, player.getPlayerLocy()-45);
			bullets.add(bullet);
			
		}
		else if (frame == 30){
			for ( EnemyShips e : enemyShips) {
				if (e instanceof EnemyShipSmall) {
					Bullet enemyBullet = new Bullet(e.getEnemyX()-3, e.getEnemyY()+50);
					enemyBullet.setSpeed(enemyBullet.getSpeed()*-1);
					enemyBullet.setPlayerBullet(false);
					enemyBullet.setSource(3);
					bullets.add(enemyBullet);
				}
			}
		}
		else if (sec % 2 == 1 && (frame == 5 || frame==25 || frame == 45) ){
			for ( EnemyShips e : enemyShips) {
				if (e instanceof EnemyShipMedium) {
					Bullet enemyBullet = new Bullet(e.getEnemyX()+20, e.getEnemyY()+150);
					enemyBullet.setSpeed(enemyBullet.getSpeed()*-1);
					enemyBullet.setPlayerBullet(false);
					enemyBullet.setSource(2);
					bullets.add(enemyBullet);
				}
			}
		}
		else {
		}
		//System.out.println("Enemy ship number: "+enemyShips.size());
		if (sec % 3 == 0 && frame == 1) {																			//Ship patterns
//			EnemyShip enemyShip = new EnemyShip(player.getX()-3, player.getY()-50);
			EnemyShipSmall e = new EnemyShipSmall();
			//e.setEnemyX(enemyLoc.nextInt( screenx - e.getShipWidth()));
			e.setEnemyX(player.getPlayerLocx());
			e.setEnemyY(-50);
			enemyShips.add(e);
		}
		else {
		}
		if (sec % 10 == 0 && frame == 1) {		
//			EnemyShip enemyShip = new EnemyShip(player.getX()-3, player.getY()-50);
			EnemyShipMedium e = new EnemyShipMedium();
			//e.setEnemyX(enemyLoc.nextInt( screenx - e.getShipWidth()));
			e.setEnemyX(player.getPlayerLocx());
			e.setEnemyY(-175);
			enemyShips.add(e);
		}
		else {
		}
		
		
		Iterator<Bullet> iterBullet = bullets.iterator();																//if bullet out of screen then remove
		while (iterBullet.hasNext()) {
			Bullet b = iterBullet.next();
			b.updateComponent();
			if ( b.isOutOfScreen() ) {
				iterBullet.remove();
				b=null;
			}
			else {
			}
		}
		
		Iterator<EnemyShips> iterShip = enemyShips.iterator(); 															//if enemy ship out of screen then remove
		while (iterShip.hasNext()) {
			EnemyShips e = iterShip.next();
			e.updateComponent();
			if ( e.isOutOfScreen() ) {
				score-=50;
				iterShip.remove();
				e=null;
			}
			else {
			}
		}
		
		iterBullet = bullets.iterator();																				//Collisions
		iterShip = enemyShips.iterator();
		Rectangle r3 = new Rectangle(player.getPlayerLocx(),player.getPlayerLocy(),player.getPlayerWidth(),player.getPlayerHeight());

		while (iterBullet.hasNext()) {		// player bullet collision
			Bullet b = iterBullet.next();
			Rectangle r1 = new Rectangle(b.getBulletLocx(),b.getBulletLocy(),b.getBulletWidth(),b.getBulletHeight());
			if ( (r1.intersects(r3) || r3.intersects(r1)) && !b.isPlayerBullet() ) {
				player.setHealth(player.getHealth() - 5);
				iterBullet.remove();
				b=null;
			}
		}
		while (iterShip.hasNext()) {		// player enemy collision
			EnemyShips e = iterShip.next();
			Rectangle r2 = null;
			if (e instanceof EnemyShipSmall) {
				r2 = new Rectangle(e.getEnemyX(),e.getEnemyY(),((EnemyShipSmall) e).getShipWidth(),((EnemyShipSmall) e).getShipHeight());
			}
			else if (e instanceof EnemyShipMedium) {
				r2 = new Rectangle(e.getEnemyX(),e.getEnemyY(),((EnemyShipMedium) e).getShipWidth(),((EnemyShipMedium) e).getShipHeight());
			}
			else {
			}
			if (r2.intersects(r3) || r3.intersects(r2)){
				//System.out.println("HEY");
				player.setHealth(player.getHealth() - 20);
				e.setHealth(0);
			}
			else {
			}
			if ( !e.isAlive() ) {
				MenuMusic explosionSound = new MenuMusic(2);
				if ( e instanceof EnemyShipMedium) {
					score+=300;
				}
				else {
					score+=100;
				}
				explosion = true;
				frame1 = frame;
				frame2 = (frame + 12)%60;
				frame3 = (frame + 24)%60;
				frame4 = (frame + 36)%60;
				frame5 = (frame + 48)%60;
				explosionx = e.getEnemyX();
				explosiony = e.getEnemyY();
				iterShip.remove();
				e=null;
			}
			else {
			}
		}
		iterBullet = bullets.iterator();
		iterShip = enemyShips.iterator();
		while (iterBullet.hasNext()) {						//bullet enemy collision
			Bullet b = iterBullet.next();
			Rectangle r1 = new Rectangle(b.getBulletLocx(),b.getBulletLocy(),b.getBulletWidth(),b.getBulletHeight());
			while (iterShip.hasNext()) {
				EnemyShips e = iterShip.next();
				Rectangle r2 = null;
				if (e instanceof EnemyShipSmall) {
					r2 = new Rectangle(e.getEnemyX(),e.getEnemyY(),((EnemyShipSmall) e).getShipWidth(),((EnemyShipSmall) e).getShipHeight());
				}
				else if (e instanceof EnemyShipMedium) {
					r2 = new Rectangle(e.getEnemyX(),e.getEnemyY(),((EnemyShipMedium) e).getShipWidth(),((EnemyShipMedium) e).getShipHeight());
				}
				else {
				}
				if ( (r1.intersects(r2) || r2.intersects(r1)) && b.isPlayerBullet()) {
					e.setHealth(e.getHealth() - 1);
					iterBullet.remove();
					b=null;
					break;
				}
				else {
				}
				if ( !e.isAlive() ) {
					MenuMusic explosionSound = new MenuMusic(2);
					score+=100;
					explosion = true;
					frame1 = frame;
					frame2 = (frame + 12)%60;
					frame3 = (frame + 24)%60;
					frame4 = (frame + 36)%60;
					frame5 = (frame + 48)%60;
					explosionx = e.getEnemyX();
					explosiony = e.getEnemyY();
					iterShip.remove();
					e=null;
				}
				else {
				}
			}
		}

		
		backgroundPanel.updateComponent();
		if (player.getHealth()<= 0) {
			gameMusic.stopGameMusic();
			game_is_running = false;
			Scanner fileScanner = null, lineScanner;
			BufferedReader bf = null;
			BufferedWriter writer = null;
			File f = new File("highscore.csv");
			try {
				bf = new BufferedReader(new FileReader("highscore.csv"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				writer = new BufferedWriter(new FileWriter("highscore.csv", true));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (!f.exists())
			{
				System.out.println("HEEEY");
			}
			String currentLine = "";
			String lineAdded="";
			ArrayList<String> lines = new ArrayList<String>();
			try {
				while ((currentLine = bf.readLine()) != null) {
					System.out.println(currentLine);
					lineScanner = new Scanner(currentLine).useDelimiter(",");
					String u = lineScanner.next();
					String hs = lineScanner.next();
					int highScore = Integer.parseInt(hs);
					if (u.equals(username) && score > highScore) {
						lineAdded = String.format("%s,%s", u, score.toString());
						lines.add(lineAdded);
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (String s : lines) {
				System.out.println(s);
				try {
					writer.write(s);
					writer.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
}
	


	public void render() {																					//Painting updated version of the game
		

		g2d.drawImage(backgroundImage, 0, 0, 800, 600, 0, backgroundPanel.getPositiony()-600, 800, backgroundPanel.getPositiony(), null);

		if (loop<10 && explosion)																			//Explosion
		{
			g2d.drawImage(explosionImage1, explosionx, explosiony, null);
			loop++;
		}
		else if (loop>= 10 && loop<20 && explosion) {
			g2d.drawImage(explosionImage2, explosionx, explosiony, null);
			loop++;
		}
		else if (loop>= 20 && loop<30 && explosion) {
			g2d.drawImage(explosionImage3, explosionx, explosiony, null);
			loop++;
		}
		else if (loop>= 30 && loop<40 && explosion) {
			g2d.drawImage(explosionImage4, explosionx, explosiony, null);
			loop++;
		}
		else if (loop>= 40 && loop<50 && explosion) {
			g2d.drawImage(explosionImage5, explosionx, explosiony, null);
			loop++;
		}
		else if (loop>= 50 && loop<60 && explosion) {
			g2d.drawImage(explosionImage5, explosionx, explosiony, null);
			loop++;
			if (loop == 60) {
				explosion = false;
				loop = 0;
			}
		}
		else {
		}
		

		if ( player.isMovingLeft() && player.isMovingRight()) {												//Player Left/Right/Idle Image
			g2d.drawImage(playerImageIdle, player.getPlayerLocx(), player.getPlayerLocy(), null);
		}
		else if ( player.isMovingDown() && player.isMovingUp()) {
			g2d.drawImage(playerImageIdle, player.getPlayerLocx(), player.getPlayerLocy(), null);
		}
		else if ( player.isMovingLeft() ) {
			g2d.drawImage(playerImageLeft, player.getPlayerLocx(), player.getPlayerLocy(), null);
		}
		else if ( player.isMovingRight() ) {
			g2d.drawImage(playerImageRight, player.getPlayerLocx(), player.getPlayerLocy(), null);
		}
		else {
			g2d.drawImage(playerImageIdle, player.getPlayerLocx(), player.getPlayerLocy(), null);
		}

		if (!shipName.equals("")) {
			g2d.drawString(shipName, player.getPlayerLocx(), player.getPlayerLocy()+100);
		}
		else {
		}		
		
		
		g2d.drawString(String.format("Score: %s", score), 650, 75);											//Score
		g2d.drawImage(healthBar1, 550, 500, null);															//Health bar
		if (player.getHealth()>0) {
			g2d.drawImage(healthBar2, 550, 500, 550+player.getHealth()*2, 541, 0, 0, player.getHealth()*2, 41, null);
		}
		else {
		}

		if (player.moving()) {																				//Booster
			g2d.drawImage(boosterImage, player.getPlayerLocx()+17, player.getPlayerLocy()+55, null);
		}
		else {
		}
		for ( Bullet b : bullets) {																			//Bullets
			if (b.getSource()==2) {
				g2d.drawImage(bulletImage2, b.getBulletLocx(), b.getBulletLocy(), null);
			}
			else if(b.getSource()==3){
				g2d.drawImage(bulletImage3, b.getBulletLocx(), b.getBulletLocy(), null);
			}
			else {
				g2d.drawImage(bulletImage, b.getBulletLocx(), b.getBulletLocy(), null);
			}
		}
		for ( EnemyShips e : enemyShips) {																	//Ships
			if (e instanceof EnemyShipSmall) {
				g2d.drawImage(enemyImageS, e.getEnemyX(), e.getEnemyY(),((EnemyShipSmall) e).getShipWidth(), ((EnemyShipSmall) e).getShipHeight(), null);
			}
			else if (e instanceof EnemyShipMedium) {
				g2d.drawImage(enemyImageM, e.getEnemyX(), e.getEnemyY(),((EnemyShipMedium) e).getShipWidth(), ((EnemyShipMedium) e).getShipHeight(), null);
			}
			else {
			}
		}
		if (!game_is_running) {
			g2d.setFont(new Font("SerifSans", Font.BOLD, 72));
			g2d.drawString("GAME OVER", 150, 300);
			g2d.drawString("M:MENU    E:EXIT", 100, 450);
		}
		this.getGraphics().drawImage(backbuffer, 0, 0, null);

	}
	
	public void paintComponent(Graphics g) {
		//Graphics g2 = backgroundImage.createGraphics();
		//g.drawImage(backgroundImage, 0, 0, 800, 600, 0, backgroundPanel.getPositiony()-600, 800, backgroundPanel.getPositiony(), null);
		//g.drawImage(playerImage, player.getPlayerLocx(), player.getPlayerLocy()+600, null);

	}
	public Background getBackgroundPanel() {
		return backgroundPanel;
	}

	public void setBackgroundPanel(Background backgroundPanel) {
		this.backgroundPanel = backgroundPanel;
	}
	@Override
	public void keyPressed(KeyEvent event) {
		
		
		if (event.getKeyCode() == KeyEvent.VK_UP)
			player.setMovingUp(true);
		else if (event.getKeyCode() == KeyEvent.VK_DOWN)
			player.setMovingDown(true);
		else if (event.getKeyCode() == KeyEvent.VK_LEFT)
			player.setMovingLeft(true);
		else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
			player.setMovingRight(true);
		else if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
			MainMenu menu = new MainMenu();
			dispose();
		}
		else if (event.getKeyCode() == KeyEvent.VK_M)
			mPressed = true;
		else if (event.getKeyCode() == KeyEvent.VK_E)
			ePressed = true;
		else {
		}
		
}
		

	@Override
	public void keyReleased(KeyEvent event) {

		if (event.getKeyCode() == KeyEvent.VK_UP)
			player.setMovingUp(false);
		else if (event.getKeyCode() == KeyEvent.VK_DOWN)
			player.setMovingDown(false);
		else if (event.getKeyCode() == KeyEvent.VK_LEFT)
			player.setMovingLeft(false);
		else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
			player.setMovingRight(false);
		else if (event.getKeyCode() == KeyEvent.VK_M)
			mPressed = false;
		else if (event.getKeyCode() == KeyEvent.VK_E)
			ePressed = false;
		else {
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean isGame_is_running() {
		return game_is_running;
	}

	public void setGame_is_running(boolean game_is_running) {
		this.game_is_running = game_is_running;
	}
}
