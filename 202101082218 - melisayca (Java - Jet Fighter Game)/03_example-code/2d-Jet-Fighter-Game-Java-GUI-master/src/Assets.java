import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage player, enemy,backGround,bullet,explosion,gameover,enemyLaser,hp,mbc;
	public static void init() {
		player = ImageLoader.loadImage("/textures/jet.png");
		enemy = ImageLoader.loadImage("/textures/enemy.png");
		backGround = ImageLoader.loadImage("/textures/bc.png");
		bullet = ImageLoader.loadImage("/textures/missile.png");
		explosion = ImageLoader.loadImage("/textures/explosion.png");
		gameover =  ImageLoader.loadImage("/textures/gameover.png");
		enemyLaser = ImageLoader.loadImage("/textures/enemybullet.png");
		hp = ImageLoader.loadImage("/textures/hp.png");
		mbc = ImageLoader.loadImage("/textures/mbc.png");
	}
	
}
