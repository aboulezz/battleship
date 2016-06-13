import javax.accessibility.AccessibleComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by surfing on 05/06/2016.
 */
public class FertigGui implements ActionListener {
    private final String spielername1;
    private final String spielername2;
    private final JFrame frame;
    private int counter;


    public FertigGui(int counter, JFrame frame, String spielername1, String spielername2) {
        this.frame = frame;
        this.frame.dispose();
        this.counter = counter;
        this.spielername1 = spielername1;
        this.spielername2 = spielername2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Setzen der Spielernamen für das Spielfeld
        String dranSpieler = "";
        if (this.counter % 2  == 0){
            dranSpieler = spielername2;
        }else{
            dranSpieler = spielername1;
        }
        JFrame fertigGui = new JFrame();
        fertigGui.setContentPane(new BackGroundPane("next.png"));
        JPanel fertig = new JPanel(new BorderLayout());
        fertig.setBackground(new Color(0,0,0,0));
        JPanel oben = new JPanel();
        oben.setBackground(new Color(0, 0, 0, 0));
        JLabel naechster = new JLabel( dranSpieler + " du bist der naechster Spieler?");
        naechster.setBackground(new Color(0, 0, 0, 0));
        oben.add(naechster);
        JPanel unten = new JPanel();
        unten.setBackground(new Color(0,0,0,0));
        JButton ok = new JButton("ok");
        ok.addActionListener(new okListener(counter, fertigGui, spielername1, spielername2));
        unten.add(ok);
        fertig.add(oben, BorderLayout.NORTH);
        fertig.add(unten, BorderLayout.SOUTH);
        fertigGui.add(fertig);
        fertigGui.setPreferredSize(new Dimension(300, 200));
        fertigGui.pack();
        fertigGui.setLocationRelativeTo(null);
        fertigGui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fertigGui.setVisible(true);
    }

    private class okListener implements ActionListener {
        public okListener(int counter, JFrame fertigGui, String spielername1, String spielername2) {
        fertigGui.dispose();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            counter++;
            new Spielfeld(spielername1, spielername2, counter);

        }
    }
}



