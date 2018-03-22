package shaytavorexample;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawingPoints extends JPanel{
    private int x, y;
    private final int SIZE;
    
    public DrawingPoints(int s) {
        x = y = -1;
        SIZE = (s > 0 ? s : 1);
        addMouseListener(new Listener());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(x, y, SIZE, SIZE);
    }
    
    private class Listener implements MouseListener
    {
        public void mouseClicked(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            repaint();
        }

        public void mousePressed(MouseEvent e) {}

        public void mouseReleased(MouseEvent e) {}

        public void mouseEntered(MouseEvent e) {}

        public void mouseExited(MouseEvent e) {}     
    }
    
    // using adapter
    /*
    private class Listener extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            repaint();
        }
    }*/
}
