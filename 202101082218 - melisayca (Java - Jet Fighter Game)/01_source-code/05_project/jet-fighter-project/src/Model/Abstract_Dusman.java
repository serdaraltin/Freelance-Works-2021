package Model;


import Interface.Interface_Oyun;


public abstract class Abstract_Dusman implements Interface_Oyun {

    private int enemyX;
    private int enemyY;
    private int speed;
    private int health;

    public Abstract_Dusman() {
        setEnemyX(200);
        setEnemyY(-50);
    }

    public Abstract_Dusman(int x, int y) {
        enemyX = x;
        enemyY = y;
    }

    public boolean isOutOfScreen() {
        if (this.enemyY > 650) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlive() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getEnemyY() {
        return enemyY;
    }

    public void setEnemyY(int enemyy) {
        this.enemyY = enemyy;
    }

    public int getEnemyX() {
        return enemyX;
    }

    public void setEnemyX(int enemyx) {
        this.enemyX = enemyx;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
