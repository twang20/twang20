import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class Circle extends JComponent
{
    private int dx = 0, dy = 0;
    
    public Circle(int x, int y)
    {
        setLocation(x,y);
        setSize(20, 20);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double ball = new Ellipse2D.Double(0, 0, 10, 10);
        g2.setColor(Color.ORANGE);
        g2.fill(ball);
    }
    
    public void setDY(int y)
    {
        dy = y;
    }
    
    public void setDX(int x)
    {
        dx = x;
    }
    
    public void update()
    {
        setLocation(getX() + dx, getY() + dy);
    }
}
