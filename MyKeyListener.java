package pongpackage;
import java.awt.event.*;
/** keylistener class to handle user input (slider upp and down, add ball)*/
public class MyKeyListener implements KeyListener {
    boolean y1up;
    boolean y1down;
    boolean y2up;
    boolean y2down;
    int ballNumber = 0;
    /** method to store key press data in variables
    * @param e key press event
    */
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            y1up = true;
        }
        if (code == KeyEvent.VK_S) {
            y1down = true;
        }
        if (code == KeyEvent.VK_UP) {
            y2up = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            y2down = true;
        }
        if (code == KeyEvent.VK_B) {
            if (ballNumber < 2) {
                ballNumber += 1;
            }
        }


    }
    /** method to store key release dqta in variables
    * important for the smooth operation of the slider
    * @param e key release event
    */
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            y1up = false;
        }
        if (code == KeyEvent.VK_S) {
            y1down = false;
        }
        if (code == KeyEvent.VK_UP) {
            y2up = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            y2down = false;
        }
    }
    /** method must be declared
    * @param e key typed event*/
    public void keyTyped(KeyEvent e) {}
    /** returns the required mod of the slider y coordinate
    * based on the key press/release
    * @return 0 if no input was detected, 1/-1 otherwise, depending on up/down input
    */
    public double gety1() {
        if (y1up == true && y1down == true) {
            return 0;
        }
        if (y1up == true) {
            return -1.0;
        }
        if (y1down == true) {
            return 1.0;
        }
        else {
            return 0.0;
        }

    }
    /** returns the required mod of slider2 y coordinate
    * based on the key press/release
    * @return 0 if no input was detected, 1/-1 otherwise, depending on up/down input
    */
    public double gety2() {
        if (y2up == true && y2down == true) {
            return 0;
        }
        if (y2up == true) {
            return -1.0;
        }
        if (y2down == true) {
            return 1.0;
        }
        else {
            return 0.0;
        }
    }
    /** @return number of balls currently in game */
    public int ballStatus() {
        return ballNumber;
    }
    /** resets ball number*/
    public void reset() {
        ballNumber = 0;
    }
}
