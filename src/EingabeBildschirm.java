import javax.swing.*;

/**
* Created by aklimek on 17.05.2016.
        */
public class EingabeBildschirm {

    private final JFrame frame;

    public EingabeBildschirm() {
        this.frame = new JFrame();
        this.frame.pack();

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setLocationRelativeTo(null);
    }
}
