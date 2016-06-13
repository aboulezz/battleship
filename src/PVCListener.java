import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aklimek on 17.05.2016.
 */
public class PVCListener implements ActionListener {
    private final JFrame frame;
    private final JPanel panelMenu;
    private String spielername1;
    private String spielername2;


    public PVCListener(JFrame frame, JPanel panel) {
        this.frame = frame;
        this.panelMenu = panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel pvc = new JPanel();
        JPanel eingabe = new JPanel(new GridLayout(8, 1));



        pvc.setLayout(new BoxLayout(pvc, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel();

        pvc.add(label);
        pvc.add(Box.createRigidArea(new Dimension(0, 1)));

        pvc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        // Sorgt für einen Transparenten Hintergrund
        panelMenu.setBackground(new Color(0, 0, 0, 0));
        pvc.setBackground(new Color(0, 0, 0, 0));
        eingabe.setBackground(new Color(0, 0, 0, 0));



        // Erstellen der Labels für die Namen eingabe
        JLabel label_sp1 = new JLabel("Name Spieler 1");

        label_sp1.setFont(Font.decode("Courier New"));
        label_sp1.setForeground(Color.WHITE);
        label_sp1.setFont(label.getFont().deriveFont(Font.BOLD));

        JLabel difficult = new JLabel("Schwierigkeitsgrad");
        difficult.setForeground(Color.WHITE);
        String[] difficultStrings = {"Leicht", "Normal", "Schwer"};


// Erstellt combo box mit 3 Items.

        JComboBox difficultList = new JComboBox(difficultStrings);
        difficultList.setSelectedIndex(2);
        difficultList.addActionListener(this);

//Erzeugen der Textfelder zur Namen eingabe
        JTextField tx_Spieler1 = new JTextField("");

        //Wir nciht angezeicht und dient nur zur vergabe des Namens für den Computer
        JTextField tx_Spieler2 = new JTextField("Captain Kirk");


// Geht zurück zum Startbildschirm
        JButton back = new JButton("BACK");
        back.addActionListener(new BackListener_PVP(frame, panelMenu, pvc));

        JLabel label_button = new JLabel("");
        JButton start = new JButton("START");
        start.addActionListener(new StartListener(spielername1, spielername2, tx_Spieler1, tx_Spieler2));


// Zufügen der Elemente zu den Panels
        eingabe.add(label_sp1);
        eingabe.add(tx_Spieler1);

        eingabe.add(difficult);
        eingabe.add(difficultList);
        eingabe.add(label_button);
        eingabe.add(back);
        eingabe.add(start);




        pvc.add(eingabe);
        pvc.setPreferredSize(new Dimension(120, 300));


        panelMenu.removeAll();

        panelMenu.add(pvc);


        // Um das Zusätzliche Panel zusätzlich in dem Startframe anzuzeigen
        this.frame.setVisible(false);
        this.frame.pack();

        this.frame.setVisible(true);


    }


}

