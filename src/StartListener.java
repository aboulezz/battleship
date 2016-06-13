import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aklimek on 25.05.2016.
 */
public class StartListener implements ActionListener {
    private String spielername1;
    private String spielername2;
    private final JTextField tx_Spieler1;
    private final JTextField tx_Spieler2;

    public StartListener(String spielername1, String spielername2, JTextField tx_Spieler1, JTextField tx_Spieler2) {
        this.spielername1 = spielername1;
        this.spielername2 = spielername2;
        this.tx_Spieler1 = tx_Spieler1;
        this.tx_Spieler2 = tx_Spieler2;




    }


    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Übergeben der Spielernamen für das eigentliche Spielfeld
        String spielername1 = tx_Spieler1.getText();;
        String spielername2 = tx_Spieler2.getText();;
        int spielCounter = 0;

        new Spielfeld(spielername1, spielername2, spielCounter);
    }


}
