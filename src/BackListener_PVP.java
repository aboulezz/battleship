import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aklimek on 20.05.2016.
 * Kümmert sich um das Entfernen des PVP Panels und das erneuern des Frames
 */

public class BackListener_PVP implements ActionListener {
    private final JFrame frame;
    private final JPanel panel;
    private final JPanel pvp;


    public BackListener_PVP(JFrame frame, JPanel panel, JPanel pvp) {
        this.frame = frame;
        this.panel = panel;
        this.pvp = pvp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        this.frame.setVisible(false);
        panel.remove(pvp);

        this.frame.setVisible(true);
    }
}
