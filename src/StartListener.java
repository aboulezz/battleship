import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aklimek on 25.05.2016.
 */
public class StartListener implements ActionListener {

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String nameSpieler1 = "Hans";
        String nameSpieler2 = "Dampf";
        int spielCounter = 0;

        new Spielfeld(nameSpieler1, nameSpieler2, spielCounter);
    }
}
