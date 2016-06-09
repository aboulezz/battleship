import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aklimek on 25.05.2016.
 */
public class StartListener implements ActionListener {
    private String spielername1;
    private String spielername2;

    public StartListener(String spielername1, String spielername2) {
        this.spielername1 = spielername1;
        this.spielername2 = spielername2;


    }


    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String spielername1 = "Hans";
        String spielername2 = "Dampf";
        int spielCounter = 0;

        new Spielfeld(spielername1, spielername2, spielCounter);
    }


}
