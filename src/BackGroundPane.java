import javax.swing.*;
import java.awt.*;

/**
 * Created by aklimek on 23.05.2016.
 */
public class BackGroundPane extends JPanel {
    Image img = null;

    public BackGroundPane(String imagefile) {

        if (imagefile != null) {
            MediaTracker mt = new MediaTracker(this);
            img = Toolkit.getDefaultToolkit().getImage(imagefile);
            mt.addImage(img, 0);
            try {
                mt.waitForAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }

}

