package Model;


import Interface.Interface_Oyun;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Model_Arkaplan extends JPanel implements Interface_Oyun {

    private int positionx = 0;
    private int positiony = 1200;
    private final int speed = 5;
    private final Icon icon;

    public Model_Arkaplan() {
        icon = new ImageIcon(new File("arkaplan1.png").getAbsolutePath());
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
