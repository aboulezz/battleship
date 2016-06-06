import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by surfing on 03/06/2016.
 */
public class Spielfeld {

    private final String spielername1;
    private final String spielername2;
    private final JFrame frame;
    private int counter;

    public Spielfeld(String spielername1, String spielername2, int counter) {

        this.spielername1 = spielername1;
        this.spielername2 = spielername2;
        this.counter = counter;
        this.frame = new JFrame("Battleship");
        this.frame.setContentPane(new BackGroundPane("battleship2.jpg"));
        if (this.counter %2 == 0 ) {
            this.frame.add(spielfeldarray(this.spielername1, false));
            this.frame.add(spielfeldarray(this.spielername2, true));
        } else {
            this.frame.add(spielfeldarray(this.spielername2, false));
            this.frame.add(spielfeldarray(this.spielername1, true));
        }
        JButton fertig =new JButton("fertig");
        fertig.addActionListener(new FertigGui(this.counter, this.frame, spielername1, spielername2));

        this.frame.add(fertig);
        //this.frame.setPreferredSize(new Dimension(600, 400));
        this.frame.pack();

        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Hier ein 'bist du sicher' gui einbauen
        this.frame.setVisible(true);





    }

    private JPanel spielfeldarray(String spielerName, boolean b) {
        JPanel spielfelder = new JPanel(new GridLayout(10, 10));
        spielfelder.setBorder(new TitledBorder(spielerName));
        boolean mitListenern = b;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                JPanel feld = new JPanel();
                feld.setPreferredSize(new Dimension(50, 50));
                feld.setBorder(BorderFactory.createLineBorder(Color.lightGray));
                feld.setOpaque(true);
                if (mitListenern == true ) {
                    feld.addMouseListener(new SpielfeldListener(i,j));
                }
                spielfelder.add(feld);

            }
        }
        return spielfelder;
    }



}