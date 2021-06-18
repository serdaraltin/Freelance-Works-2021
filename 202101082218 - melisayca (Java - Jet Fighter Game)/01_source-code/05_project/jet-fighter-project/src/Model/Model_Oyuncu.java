package Model;

import Interface.Interface_Oyun;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Oyuncu implements Interface_Oyun {

    private BufferedImage playerImage;
    private Icon playerShipIdle, playerShipLeft, playerShipRight;
    private final int playerWidth = 50;
    private final int playerHeight = 56;
    private int playerLocx;
    private int playerLocy;
    private int speed;
    private int health;
    private boolean isMovingLeft, isMovingRight, isMovingUp, isMovingDown, isMoving, hit;

    public Model_Oyuncu() {
        playerShipIdle = new ImageIcon(new File("ucak1.png").getAbsolutePath());

        setHealth(100);
        speed = 5;
        playerLocx = 400;
        playerLocy = 450;

        isMovingLeft = false;
        isMovingRight = false;
        isMovingDown = false;
        isMovingUp = false;
        isMoving = false;
        hit = false;

        try {
            playerImage = ImageIO.read(new File("ucak1.png").getAbsoluteFile());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateComponent() {
        if (this.isMovingDown && (this.playerLocy + speed < 600 - this.playerHeight)) {
            this.playerLocy += speed;
        }
        if (this.isMovingUp && (this.playerLocy - speed > 0)) {
            this.playerLocy -= speed;
        }
        if (this.isMovingLeft && (this.playerLocx - speed > 0)) {
            this.playerLocx -= speed;
        }
        if (this.isMovingRight && (this.playerLocx + speed < 800 - this.playerWidth)) {
            this.playerLocx += speed;
        }
    }

    @Override
    public void drawComponent() {
        if (this.isMovingLeft && this.isMovingRight) {
            playerShipIdle = new ImageIcon(new File("ucak1.png").getAbsolutePath());

        } else if (this.isMovingLeft) {
            playerShipLeft = new ImageIcon(new File("ucak2.png").getAbsolutePath());

        } else if (this.isMovingRight) {
            playerShipRight = new ImageIcon(new File("ucak3.png").getAbsolutePath());

        } else {
            playerShipIdle = new ImageIcon(new File("ucak1.png").getAbsolutePath());

        }
    }

    public boolean moving() {
        if ((this.isMovingLeft && this.isMovingRight) || (this.isMovingDown && this.isMovingUp)) {
            return false;
        } else if (this.isMovingDown || this.isMovingLeft || this.isMovingRight || this.isMovingUp) {
            return true;
        } else {
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
