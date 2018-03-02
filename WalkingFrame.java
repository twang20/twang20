import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{
    private Man man;
    private Circle circle;
    private int x = 0;
    private int y = 0;
    private ArrayList<Circle> circleMove = new ArrayList<Circle>();
    
    public WalkingFrame()
    {
    	for (int i = 0; i < circleMove.size(); i++)
    	{
    		circleMove.remove(i);

    	}
        setBounds(100,100,600,400);
        man = new Man(0, 0);
        circle = new Circle(0, 0);
        setLayout(null);
        add(man);
        add(circle);
        
        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(new KeyListener()
            {

                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode() == e.VK_W){
                        man.setDY(-2);
                    }
                    if(e.getKeyCode() == e.VK_A){
                        man.setDX(-2);
                    }
                    if(e.getKeyCode() == e.VK_S){
                        man.setDY(2);
                    }
                    if(e.getKeyCode() == e.VK_D){
                        man.setDX(2);
                    }
                    if(e.getKeyCode() == e.VK_SPACE) {
                    	circle.setLocation(man.getX(),man.getY());
                    }
                }

                public void keyReleased(KeyEvent e) 
                {
                    if(e.getKeyCode() == e.VK_W) {
                        man.setDY(0);
                    }
                    if(e.getKeyCode() == e.VK_A){
                        man.setDX(0);
                    }
                    if(e.getKeyCode() == e.VK_S){
                        man.setDY(0);
                    }
                    if(e.getKeyCode() == e.VK_D){
                        man.setDX(0);
                    }
                }
        
                public void keyTyped(KeyEvent e) {                    
                }
            });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[]  args){
        new WalkingFrame();
    }

    public void actionPerformed(ActionEvent e) 
    {
        circle.update();
    	man.update();
        repaint();
    }
}
