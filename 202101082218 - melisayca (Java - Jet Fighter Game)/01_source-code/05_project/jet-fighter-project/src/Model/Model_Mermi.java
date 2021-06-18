package Model;

import Interface.Interface_Oyun;


public class Model_Mermi implements Interface_Oyun {

    private final int bulletWidth = 55;
    private final int bulletHeight = 90;
    private int bulletLocx;
    private int bulletLocy;
    private int speed = 10;
    private boolean playerBullet;
    private int source;

    public Model_Mermi() {

        setPlayerBullet(true);
        speed = 10;
    }

    public Model_Mermi(int x, int y) {

        bulletLocx = x;
        bulletLocy = y;
        speed = 10;

        setPlayerBullet(true);

    }

    @Override
    public void updateComponent() {
        bulletLocy -= speed;
    }

    @Override
    public void drawComponent() {
        //this.repaint();
    }

    public boolean isOutOfScreen() {
        if (this.bulletLocy < -90 || this.bulletLocy > 690) {
            return true;
        } else {
            return false;
        }
    }

    public int getBulletWidth() {
        return bulletWidth;
    }

    public int getBulletHeight() {
        return bulletHeight;
    }

    public int getBulletLocx() {
        return bulletLocx;
    }

    public void setBulletLocx(int bulletLocx) {
        this.bulletLocx = bulletLocx;
    }

    public int getBulletLocy() {
        return bulletLocy;
    }

    public void setBulletLocy(int bulletLocy) {
        this.bulletLocy = bulletLocy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isPlayerBullet() {
        return playerBullet;
    }

    public void setPlayerBullet(boolean playerBullet) {
        this.playerBullet = playerBullet;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

}
