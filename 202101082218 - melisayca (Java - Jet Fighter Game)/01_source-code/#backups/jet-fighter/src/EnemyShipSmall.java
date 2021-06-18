
public class EnemyShipSmall extends EnemyShips {

    private final int shipWidth = 50;
    private final int shipHeight = 50;

    public EnemyShipSmall() {
        super();
        setHealth(2);
        setSpeed(3);
    }

    public EnemyShipSmall(int x, int y) {
        setHealth(2);
        setSpeed(4);

        setEnemyX(x);
        setEnemyY(y);
    }

    @Override
    public void updateComponent() {
        setEnemyY(getEnemyY() + getSpeed());
    }

    @Override
    public void drawComponent() {
        // TODO Auto-generated method stub

    }

    public int getShipWidth() {
        return shipWidth;
    }

    public int getShipHeight() {
        return shipHeight;
    }
}
