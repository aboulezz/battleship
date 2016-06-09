import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by surfing on 03/06/2016.
 */
public class Plazieren {


    public static final Border BORDER_RED = BorderFactory.createLineBorder(Color.red);
    public static final Border BORDER_BLUE = BorderFactory.createLineBorder(Color.BLUE);
    public static final Border BORDER_LIGHTGRAY = BorderFactory.createLineBorder(Color.lightGray);
    private final JFrame frame;
    private JPanel[][] panelArray = new JPanel[10][10];
    int schiffslaenge = 4;
    boolean drehen = false;

    public Plazieren() {

        this.frame = new JFrame();
        this.frame.setContentPane(new BackGroundPane("battleship2.jpg"));
        //this.frame.setBackground(Color.CYAN);
        this.frame.add(SpielfeldArray());

        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    private JPanel SpielfeldArray() {
        JPanel spielfelder = new JPanel(new GridLayout(10, 10));


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                JPanel feld = new JPanel();
                feld.addMouseListener(new PlazierenListener(i, j));
                feld.setPreferredSize(new Dimension(50, 50));
                feld.setBorder(BORDER_LIGHTGRAY);
                feld.setOpaque(true);
                spielfelder.add(feld);
                panelArray[i][j] = feld;
            }
        }
        //spielfelder.setBackground(Color.CYAN);
        return spielfelder;
    }

    private class PlazierenListener implements MouseListener {
        private final int xPos;
        private final int yPos;


        public PlazierenListener(int i, int j) {
            this.xPos = i;
            this.yPos = j;

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // wenn rechte Maustaste gedrueckt, dann aendere boolean drehen.

            if (e.getButton() == MouseEvent.BUTTON3) {
                mouseExited(e);   // aber erst die jetzt markierten Panels loeschen
                drehen = !drehen;
                mouseEntered(e);  // und dann nach neuer orientierung neu zeichnen.
                System.out.println("Detected Mouse right Click!");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println(xPos + " " + yPos);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

            if (!drehen) {

                //Bereich um das Schiff markieren

                    for (int i = -1; i < schiffslaenge + 1; i++) {

                        for (int j = -1; j < 2; j++) {
                            if (xPos + i < 10 && xPos + i >= 0 && yPos + j < 10 && yPos + j >= 0) {
                                panelArray[xPos + i][yPos + j].setBorder(BORDER_RED);
                                panelArray[xPos + i][yPos + j].setOpaque(false);
                            } else {
                                // nix machen
                            }

                        }
                    }


                //Schiff markieren
                for (int i = 0; i < schiffslaenge; i++) {
                    panelArray[xPos + i][yPos].setBorder(BORDER_BLUE);
                    panelArray[xPos + i][yPos].setOpaque(true);

                }

            } else {
                //Bereich um das Schiff markieren
                for (int i = -1; i < schiffslaenge + 1; i++) {
                    for (int j = -1; j < 2; j++) {
                        panelArray[xPos + j][yPos + i].setBorder(BORDER_RED);
                        panelArray[xPos + j][yPos + i].setOpaque(true);
                    }
                }
                //Schiff markieren
                for (int i = 0; i < schiffslaenge; i++) {
                    panelArray[xPos][yPos + i].setBorder(BORDER_BLUE);
                    panelArray[xPos][yPos + i].setOpaque(true);

                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {

            if (!drehen) {
                //Bereich um das Schiff markieren rueckgaengig machen
                for (int i = -1; i < schiffslaenge + 1; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (xPos + i < 10 && xPos + i >= 0 && yPos + j < 10 && yPos + j >= 0) {
                            panelArray[xPos + i][yPos + j].setBorder(BORDER_LIGHTGRAY);
                            panelArray[xPos + i][yPos + j].setOpaque(false);
                        } else {

                        }
                    }
                }


                //Schiff markieren rueckgaengig machen
                for (int i = 0; i < schiffslaenge; i++) {
                    panelArray[xPos + i][yPos].setBorder(BORDER_LIGHTGRAY);
                    panelArray[xPos + i][yPos].setOpaque(false);

                }
            } else {

                //Bereich um das Schiff markieren rueckgaengig machen
                for (int i = -1; i < schiffslaenge + 1; i++) {
                    for (int j = -1; j < 2; j++) {
                        panelArray[xPos + j][yPos + i].setBorder(BORDER_LIGHTGRAY);
                        panelArray[xPos + j][yPos + i].setOpaque(false);
                    }
                }


                //Schiff markieren rueckgaengig machen
                for (int i = 0; i < schiffslaenge; i++) {
                    panelArray[xPos][yPos + i].setBorder(BORDER_LIGHTGRAY);
                    panelArray[xPos][yPos + i].setOpaque(true);

                }
            }


        }
    }
}

