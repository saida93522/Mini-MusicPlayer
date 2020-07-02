import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

class MyDrawPanel2 extends JPanel implements ControllerEventListener {
    boolean msg = false; // initialize it to false,

    public void controlChange (ShortMessage event) {
        msg = true;
        repaint();  // when we receive an event,we set the flag to true and call repaint.
    }
    public void paintComponent (Graphics g ) {
        if (msg) { // paint only when there's a ControllerEvent
            Graphics2D g2 = (Graphics2D) g;
            int r = (int) (Math.random() * 250);
            int gr = (int) (Math.random() * 250);
            int b = (int) (Math.random() * 250);

            g.setColor(new Color(r,gr,b));

            int ht = (int) ((Math.random() * 120) + 10);
            int width = (int) ((Math.random() * 120) + 10);

            int x = (int) ((Math.random() * 40) + 10);
            int y = (int) ((Math.random() * 40) + 10);
            g.fillRect(x, y, width, ht);
            msg = false;






        }
    }


}
