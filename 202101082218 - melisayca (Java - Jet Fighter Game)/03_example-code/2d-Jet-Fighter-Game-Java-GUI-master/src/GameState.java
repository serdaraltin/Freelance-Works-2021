import java.awt.Graphics;
import java.io.IOException;

public class GameState extends State {
	public int px;
	public int py;
	private Player player;
	private boolean check = false;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game,600,600);
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		player.tick();
		px = player.getX();
		py = player.getY();
	}
	
	public void decHP(){
		player.health--;
	}

	public int getHP() {
		return player.health;
	}
	public int getX() {
		return px;
	}
	public int getY() {
		return py;
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(!(player.health<0)) {
			player.render(g);
		}
		else
			player.gameOver(g);
		if(player.health<0 && check == false) {
			WriteToText write = new WriteToText(game.getScore());
			try {
				write.writeScore();
				check=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
	
	
}
