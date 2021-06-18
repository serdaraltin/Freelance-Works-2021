package Model;


public class Model_Dusman1 extends Abstract_Dusman {

    private final int shipWidth = 50;
    private final int shipHeight = 50;

    public Model_Dusman1() {
        super();
        setHealth(2);
        setSpeed(3);
    }

    public Model_Dusman1(int x, int y) {
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
