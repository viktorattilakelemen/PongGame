package pongpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** opens initial game mode selection window, contains everything needed to launch the game*/
public class PongDriver {
    /** main method
    * @param args unused
    */
    public static void main(String[] args){
        //creates window with desired layout
        JFrame window = new JFrame("Selection Screen");
        JPanel pane = new JPanel(new BorderLayout());
        JPanel pane2 = new JPanel(new BorderLayout());
        pane.setLayout(new FlowLayout());
        //sets window size
        pane.setSize(500,500);
        pane2.setSize(500,500);
        //places buttons
        JButton jbn = new JButton("Ball gets faster");
        JButton jbn2 = new JButton("Multiple Balls");
        JLabel message = new JLabel("Choose a mode!");
        //creates game name label
        JLabel welcomeMessage = new JLabel("Beer-less Pong!");
        welcomeMessage.setFont(new Font("Impact", Font.BOLD, 40));
        jbn.setContentAreaFilled(true);
        //connects listeners to buttons
        ButtonListener1 listener1 = new ButtonListener1();
        jbn.addActionListener(listener1);
        jbn2.setContentAreaFilled(true);
        ButtonListener2 listener2 = new ButtonListener2();
        jbn2.addActionListener(listener2);
        jbn.setSize(75,75);
        jbn2.setSize(75,75);
        //sets layout of components
        pane2.add(message, BorderLayout.SOUTH);
        pane2.add(jbn, BorderLayout.EAST);
        pane2.add(jbn2, BorderLayout.WEST);
        pane2.add(welcomeMessage, BorderLayout.NORTH);
        pane.add(pane2, BorderLayout.CENTER);
        window.add(pane);
        window.pack();
        window.setVisible(true);
        window.setLocation(800,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
