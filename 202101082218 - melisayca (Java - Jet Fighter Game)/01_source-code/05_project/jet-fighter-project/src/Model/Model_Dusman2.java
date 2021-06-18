package Model;


public class Model_Dusman2 extends Abstract_Dusman {

    private final int shipWidth = 100;
    private final int shipHeight = 175;

    public Model_Dusman2() {
        super();
        setHealth(4);
        setSpeed(2);
    }

    public Model_Dusman2(int x, int y) {
        setHealth(3);
        setSpeed(2);

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
