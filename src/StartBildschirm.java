import jdk.nashorn.internal.objects.NativeUint16Array;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by aklimek on 17.05.2016.
 */
public class StartBildschirm {
    private final JFrame frame;


    public StartBildschirm() {
        this.frame = new JFrame("Schiffe Versenken");

        this.frame.setContentPane(new BackGroundPane("battleship.jpg"));


        this.frame.add(this.createComponent());

        this.frame.setPreferredSize(new Dimension(700, 450));
        this.frame.pack();
        this.frame.setResizable(false);

        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);


    }

    private Component createComponent() {

        JPanel panelMain = new JPanel(new BorderLayout());

        JPanel panelMenu = new JPanel(new GridLayout());
        panelMenu.setPreferredSize(new Dimension(130,300));



        JPanel pButton = new JPanel(new GridLayout(4, 1));

        JPanel titel = new JPanel();

        JLabel battleship = new JLabel("     BATTLESHIP     ");





        titel.add(battleship);
        titel.setPreferredSize(new Dimension(500, 51));


        JToolBar toolBar = new JToolBar();
        toolBar.setOpaque(false);
        toolBar.setFloatable(false);
        toolBar.setOrientation(JToolBar.VERTICAL);


        panelMain.setAlignmentX(Component.LEFT_ALIGNMENT);
        pButton.setBackground(new Color(0, 0, 0, 0));
        panelMenu.setBackground(new Color(0, 0, 0, 0));
        panelMain.setBackground(new Color(0, 0, 0, 0));
        titel.setBackground(new Color(0, 0, 0, 0));


// Erzeugen der Buttons mit Icons
        JButton pvp = new JButton();
        pvp.setIcon(new ImageIcon("pvp_k.jpg"));


        JButton pvc = new JButton();
        pvc.setIcon(new ImageIcon("pvc_k.jpg"));

        JButton laden = new JButton();
        laden.setIcon(new ImageIcon("laden_k.jpg"));

        JButton highscore = new JButton();
        highscore.setIcon(new ImageIcon("highscore_k.jpg"));




        // Art der Schrift für den Spielnamen
        Font font = new Font("Broadway", Font.BOLD, 32);
        battleship.setFont(font);
        battleship.setForeground(Color.RED);

//Buttons werden dem Panel hinzugef�gt


        toolBar.add(pvp);
        toolBar.add(pvc);
        toolBar.add(laden);
        toolBar.add(highscore);


// Listener f�r die Buttons
        pvp.addActionListener(new PVPListener(frame, panelMenu));
        laden.addActionListener(new LadenListener());
        highscore.addActionListener(new HighScoreListener());
        pvc.addActionListener(new PVCListener(frame, panelMenu));

//Panels dem "Haupt Panel" hinzufügen

        panelMain.add(panelMenu, BorderLayout.EAST);

        panelMain.add(toolBar, BorderLayout.WEST);

        panelMain.add(titel, BorderLayout.NORTH);


        return panelMain;

    }


}
