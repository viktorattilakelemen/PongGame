package pongpackage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/** CLass for button one - activates pong game mode one */
public class ButtonListener1 implements ActionListener {
    boolean buttonClicked = false;
    /** Standard method for responding to action
     * @param e button push event
     */
    public void actionPerformed(ActionEvent e) {
        buttonClicked = true;
        // Creation and running of new thread
        Thread game = new Thread(new PongGame());
        game.setPriority(Thread.MIN_PRIORITY);
        game.start();
    }
}
