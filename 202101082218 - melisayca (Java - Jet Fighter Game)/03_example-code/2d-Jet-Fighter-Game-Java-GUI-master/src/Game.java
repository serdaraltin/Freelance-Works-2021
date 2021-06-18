import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Runnable{

	private Display display;
	public String title;
	public int width,height;
	
	public long current;
	public long delay;
	
	private int score;
	public int px;
	public int py;
	
	public int ex;
	public int ey;
	
	private long current2;
	private long delay2;
	
	private Thread thread;
	private boolean running=false;
	
	public static ArrayList<Bullet> bullet;
	private static ArrayList<Enemy> enemies;
	public static ArrayList<EnemyLaser> lasers;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	private State gameState;
	private State menuState;
	
	//input
	private KeyManager keyManager;
	
	public void  ResCurrent() {
		this.current=System.nanoTime();
	}
	
	public void setCurrent() {
		this.current=System.nanoTime();
	}
	private int delay() {
		delay=100;
		return (int) delay;
	}
	
	public void setTime() {
		this.current=getTime();
		this.delay=delay();
	}
	
	public long getTime() {
		return current;
	}
	
	public int getDelay() {
		return (int) delay;
	}
	
	
	public Game(String title,int width,int height)
	{
		this.title=title;
		this.width=width;
		this.height=height;
		keyManager = new  KeyManager();
		
	}

	private void init() 
	{
		setTime();
		display = new Display(title,width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		State.setState(gameState);
		
		bullet = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		lasers = new ArrayList<>();
		
		current2 = System.nanoTime();
		delay2 =1300;
		score = 0;

	}
	

	private void tick()
	{
		keyManager.tick();
		
		for(int i=0;i<bullet.size();i++) {
			bullet.get(i).tick();
		}
		for(int i=0;i<lasers.size();i++) {
			lasers.get(i).tick();
		}

		if(State.getState() != null) {
			State.getState().tick();
		}
		long breaks2 = (System.nanoTime()- current2)/1000000;
		if(breaks2 > delay2) {
		for(int i=0;i<2;i++) {
			Random rand = new Random();
			int randX = rand.nextInt(960);
			int randY = rand.nextInt(250);
			enemies.add(new Enemy(randX,-randY));
		}
		current2 = System.nanoTime();
		}
		
		for(int i=0;i<enemies.size();i++) {
			enemies.get(i).tick();
		}
		
	}
	
	
	
	
	private void render()
	{
		bs = display.getCanvas().getBufferStrategy();
		if( bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear
		g.clearRect(0, 0, width, height);
		//draw
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		
		if(gameState.getHP()>=0) {
		//bullet render
		for(int i=0;i<bullet.size();i++) {
			bullet.get(i).render(g);
		}
		
		//bullet aþarsa mapi remove
		for(int i=bullet.size()-1;i>=0;i--) {
			if(bullet.get(i).getY()<=10) {
				bullet.remove(i);
				//i--;
				
			}
		}
		
		//enemy mapi aþarsa remove
		for(int i=enemies.size()-1;i>=0;i--) {
			if(enemies.get(i).getY()>680) {
				enemies.remove(i);
				//i--;
				score--;
			}
		}


		//enemylaser render
		for(int i=0;i<lasers.size();i++) {
			lasers.get(i).render(g);
		}
		
		//enemy render
		for(int i=0;i<enemies.size();i++) {
			if(!(gameState.getHP()<0)) {
			if (!(enemies.get(i).getX()<=60 ||enemies.get(i).getX()>=960 || enemies.get(i).getY()>=660))
					enemies.get(i) .render(g);
			}
		}
		
		
		//enemy ile player collisoný
		for(int i=0;i<enemies.size();i++) {
			ex = enemies.get(i).getX();
			ey = enemies.get(i).getY();
			px = gameState.getX();
			py = gameState.getY();

			if (px < ex + 25 && px + 30 > ex && py < ey + 25 && py + 30 > ey) {
				enemies.remove(i);
				i--;
				gameState.decHP();
			}

			//player bulletý ile enemy collisoný
			for (int j = 0; j < bullet.size(); j++) {
				int bx = bullet.get(j).getX();
				int by = bullet.get(j).getY();

				if (ex < bx + 8 && ex + 50 > bx && ey < by + 8 && ey + 50 > by) {
					enemies.remove(i);
					g.drawImage(Assets.explosion, ex + 8, ey + 8, null);
					i--;
					bullet.remove(j);
					j--;
					score=score+3;
				}


			}
		}

		//enemylaser ile player collisoný
		for(int k=0;k<lasers.size();k++){
			int	elx = lasers.get(k).getX();
			int	ely = lasers.get(k).getY();
			px=gameState.getX();
			py=gameState.getY();
			if(px < elx + 6 && px + 128 > elx && py < ely  && py + 64 > ely){
				gameState.decHP();
				lasers.remove(k);
				k--;
				g.drawImage(Assets.explosion,elx + 3 - 16,ely + 5 - 16,null);
			}

		}
		
		
		if(gameState.getHP()==6) {
			g.drawImage(Assets.hp, 1150, 640, null);
			g.drawImage(Assets.hp, 1180, 640, null);
			g.drawImage(Assets.hp, 1210, 640, null);
			g.drawImage(Assets.hp, 1150, 670, null);
			g.drawImage(Assets.hp, 1180, 670, null);
			g.drawImage(Assets.hp, 1210, 670, null);
		}else if(gameState.getHP()==5){
			g.drawImage(Assets.hp, 1150, 640, null);
			g.drawImage(Assets.hp, 1180, 640, null);
			g.drawImage(Assets.hp, 1210, 640, null);
			g.drawImage(Assets.hp, 1150, 670, null);
			g.drawImage(Assets.hp, 1180, 670, null);
		}else if(gameState.getHP()==4){
			g.drawImage(Assets.hp, 1150, 640, null);
			g.drawImage(Assets.hp, 1180, 640, null);
			g.drawImage(Assets.hp, 1210, 640, null);
			g.drawImage(Assets.hp, 1150, 670, null);
		}else if(gameState.getHP()==3){
			g.drawImage(Assets.hp, 1150, 640, null);
			g.drawImage(Assets.hp, 1180, 640, null);
			g.drawImage(Assets.hp, 1210, 640, null);
		}else if(gameState.getHP()==2){
			g.drawImage(Assets.hp, 1150, 640, null);
			g.drawImage(Assets.hp, 1180, 640, null);
		}else if(gameState.getHP()==1){
			g.drawImage(Assets.hp, 1150, 640, null);
		}
		g.setColor(Color.red);
		g.setFont(new Font("arial",Font.BOLD,30));
		g.drawString("Score: "+score, 1100, 50);
		
		}
		bs.show();
		g.dispose();
	}

	public int getScore() {
		return score;
	}
	public void run() {
		init(); 
		int fps = 60;		
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime(); 
		long timer = 0;
		int ticks = 0;

		while(running) 
		{
			now=System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now-lastTime;
			lastTime = now;
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >=1000000000) {
				ticks=0;
				timer=0;
			}
		}
		
		stop();
	}	
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public synchronized void start() 
	{
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{	
		if(!running)
		return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	


