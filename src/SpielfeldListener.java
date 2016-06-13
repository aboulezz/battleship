import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by surfing on 05/06/2016.
 */
public class SpielfeldListener implements MouseListener {
    private final JPanel feld;

    public SpielfeldListener(JPanel feld, int i, int j) {
        this.feld=feld;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        this.feld.setBorder(BorderFactory.createLineBorder(Color.RED));

    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.feld.setBorder(BorderFactory.createLineBorder(Color.lightGray));


    }
}
