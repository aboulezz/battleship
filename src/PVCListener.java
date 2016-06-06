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


    public PVCListener(JFrame frame, JPanel panel) {
        this.frame = frame;
        this.panelMenu = panel;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel pvc = new JPanel();
        JPanel eingabe = new JPanel(new GridLayout(8, 1));
        /*JPanel button = new JPanel(new GridLayout(2, 1));*/


        pvc.setLayout(new BoxLayout(pvc, BoxLayout.PAGE_AXIS));
        JLabel label = new JLabel();

        pvc.add(label);
        pvc.add(Box.createRigidArea(new Dimension(0, 1)));

        pvc.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        // Sorgt für einen Transparenten Hintergrund
        panelMenu.setBackground(new Color(0, 0, 0, 0));
        pvc.setBackground(new Color(0, 0, 0, 0));
        eingabe.setBackground(new Color(0, 0, 0, 0));
       /* button.setBackground(new Color(0, 0, 0, 0));*/


        // Erstellen der Labels für die Namen eingabe
        JLabel label_sp1 = new JLabel("Name Spieler 1");
        /*JLabel label_sp1_ = new JLabel("");*/
       /* JLabel label_sp1_blank = new JLabel("");*/
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
        JTextField spielerName1 = new JTextField("Name ");


// Geht zurück zum Startbildschirm
        JButton back = new JButton("BACK");
        back.addActionListener(new BackListener_PVP(frame, panelMenu, pvc));

        JLabel label_button = new JLabel("");
        JButton start = new JButton("START");


// Zufügen der Elemente zu den Panels
        eingabe.add(label_sp1);
        eingabe.add(spielerName1);
      /*  eingabe.add(label_sp1_);
        eingabe.add(label_sp1_blank);*/
        eingabe.add(difficult);
        eingabe.add(difficultList);
        eingabe.add(label_button);
        eingabe.add(back);
        eingabe.add(start);


      /*  button.add(label_button);
        button.add(back);
        button.add(start);*/

        pvc.add(eingabe);
pvc.setPreferredSize(new Dimension(120,300));
       /* pvc.add(button);*/

        panelMenu.removeAll();

        panelMenu.add(pvc);



        // Um das Zusätzliche Panel zusätzlich in dem Startframe anzuzeigen
        this.frame.setVisible(false);
        this.frame.pack();

        this.frame.setVisible(true);


    }


}

