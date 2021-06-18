
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Background extends JPanel implements GameComponents {

    private int positionx = 0;
    private int positiony = 1200;
    private int speed = 5;
    private Icon icon;

    public Background() {
        icon = new ImageIcon(getClass().getResource("starfield.png"));
    }

    @Override
    public void updateComponent() {
        positiony -= speed;
        if (positiony < 600) {
            positiony = 1200;
        }
    }

    @Override
    public void drawComponent() {
        this.repaint();

    }

    public int getPositionx() {
        return positionx;
    }

    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    public int getPositiony() {
        return positiony;
    }

    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }
}
