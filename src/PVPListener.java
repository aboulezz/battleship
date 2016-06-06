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


    public PVPListener(JFrame frame, JPanel panel) {
        this.frame = frame;
        this.panelMenu = panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //TODO Layout anpassen (Textfelder) Evtl anderes Layout verwenden
        JPanel pvp = new JPanel();
        JPanel eingabe = new JPanel(new GridLayout(8, 1));
       /* JPanel button = new JPanel(new GridLayout(3, 0));*/


        pvp.setLayout(new BoxLayout(pvp, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel();

        pvp.add(label);
        pvp.add(Box.createRigidArea(new Dimension(0, 1)));

        pvp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        // Sorgt f�r einen Transparenten Hintergrund
        panelMenu.setBackground(new Color(0, 0, 0, 0));
        pvp.setBackground(new Color(0, 0, 0, 0));
        eingabe.setBackground(new Color(0, 0, 0, 0));
       /* button.setBackground(new Color(0, 0, 0, 0));*/


        // Erstellen der Labels f�r die Namen eingabe
        JLabel label_sp1 = new JLabel("Name Spieler 1");
        /*JLabel label_sp1_ = new JLabel("");*/
        /*JLabel label_sp1_blank = new JLabel("");*/
        label_sp1.setFont(Font.decode("Courier New"));
        label_sp1.setForeground(Color.WHITE);
        label_sp1.setFont(label.getFont().deriveFont(Font.BOLD));

        JLabel label_sp2 = new JLabel("Name Spieler 2");
        JLabel label_sp2_ = new JLabel("");
        JLabel label_sp2_blank = new JLabel("");
        label_sp2.setFont(Font.decode("Courier New"));
        label_sp2.setForeground(Color.WHITE);
        label_sp2.setFont(label.getFont().deriveFont(Font.BOLD));


//Erzeugen der Textfelder zur Namen eingabe
        JTextField spielerName1 = new JTextField("Name ");
        JTextField spielerName2 = new JTextField("Name ");

// Geht zur�ck zum Startbildschirm
        JButton back = new JButton("BACK");
        back.addActionListener(new BackListener_PVP(frame, panelMenu, pvp));

        JLabel label_button = new JLabel("");
        JButton start = new JButton("START");


        //Erzeugen des Spielfeldes
        start.addActionListener(new StartListener());


// Zuf�gen der Elemente zu den Panels
        eingabe.add(label_sp1);
        eingabe.add(spielerName1);
       /* eingabe.add(label_sp1_);
        eingabe.add(label_sp1_blank);*/

        eingabe.add(label_sp2);
        eingabe.add(spielerName2);
      /*  eingabe.add(label_sp2_blank);
        eingabe.add(label_sp2_);*/

        eingabe.add(label_button);
        eingabe.add(back);
        eingabe.add(start);

       /* button.add(label_button);
        button.add(back);
        button.add(start);*/

        pvp.add(eingabe);
        /*pvp.add(button);*/



        panelMenu.add(pvp);




        // Um das Zus�tzliche Panel zus�tzlich in dem Startframe anzuzeigen
        this.frame.setVisible(false);

        this.frame.setVisible(true);


    }
}