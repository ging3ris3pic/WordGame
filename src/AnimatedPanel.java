import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatedPanel extends JPanel implements ActionListener{
    final int PANEL_WIDTH = 400;
    final int PANEL_HEIGHT = 200;
    Image smiley;
    Timer timer;
    int xVelocity = 1;
    int x = 0;
    int y = 50;

    AnimatedPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        smiley = new ImageIcon("src/Photos/smiley.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(smiley, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(x >= PANEL_WIDTH-smiley.getWidth(null) || x < 0){
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;
        repaint();
    }
}
