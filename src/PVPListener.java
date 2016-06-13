import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aklimek on 17.05.2016.
 */
public class PVPListener implements ActionListener {
    private final JFrame frame;
    private final JPanel panelMenu;
    private String spielername1;
    private String spielername2;


    public PVPListener(JFrame frame, JPanel panel) {
        this.frame = frame;
        this.panelMenu = panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //TODO Layout anpassen (Textfelder) Evtl anderes Layout verwenden (Card Layout)
        JPanel pvp = new JPanel();
        JPanel eingabe = new JPanel(new GridLayout(8, 1));


        pvp.setLayout(new BoxLayout(pvp, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel();

        pvp.add(label);
        pvp.add(Box.createRigidArea(new Dimension(0, 1)));

        pvp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        // Sorgt für einen Transparenten Hintergrund
        panelMenu.setBackground(new Color(0, 0, 0, 0));
        pvp.setBackground(new Color(0, 0, 0, 0));
        eingabe.setBackground(new Color(0, 0, 0, 0));


        // Erstellen der Labels für die Namen eingabe
        Font font = new Font("Broadway", Font.BOLD, 12);

        JLabel label_sp1 = new JLabel("Name Spieler 1");
        label_sp1.setFont(font);
        label_sp1.setForeground(Color.WHITE);

        /*label_sp1.setFont(label.getFont().deriveFont(Font.BOLD));*/

        JLabel label_sp2 = new JLabel("Name Spieler 2");

        label_sp2.setFont(font);

        label_sp2.setForeground(Color.WHITE);
        /*label_sp2.setFont(label.getFont().deriveFont(Font.BOLD));*/


//Erzeugen der Textfelder zur Namen eingabe
        JTextField tx_Spieler1 = new JTextField("");
        JTextField tx_Spieler2 = new JTextField("");

// Geht zurück zum Startbildschirm
        JButton back = new JButton("BACK");
        back.addActionListener(new BackListener_PVP(frame, panelMenu, pvp));

        JLabel label_button = new JLabel("");
        JButton start = new JButton("START");


        //Erzeugen des Spielfeldes

        start.addActionListener(new StartListener(spielername1, spielername2, tx_Spieler1, tx_Spieler2));


// Zufügen der Elemente zu den Panels
        eingabe.add(label_sp1);
        eingabe.add(tx_Spieler1);


        eingabe.add(label_sp2);
        eingabe.add(tx_Spieler2);


        eingabe.add(label_button);
        eingabe.add(back);
        eingabe.add(start);


        pvp.add(eingabe);


        pvp.setPreferredSize(new Dimension(120, 300));
        panelMenu.removeAll();
        panelMenu.add(pvp);


        // Um das Zusätzliche Panel zusätzlich in dem Startframe anzuzeigen
        this.frame.setVisible(false);

        this.frame.setVisible(true);


    }
}
