package pongpackage;
import java.awt.*;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;
/** Class for moving position of ball x and y */
public class Ball {
    Ellipse2D.Double ballOne;
    double x1;
    double y1;
    double movementVar;
    /** Ball constructor - creates ball from param coordinates
     * @param x sets x coordinate
     * @param y sets y coordinate
     */
    public Ball(double x, double y) {
        this.x1 = x;
        this.y1 = y;
        this.ballOne = new Ellipse2D.Double(x, y, 18.0, 18.0);
    }
    /** Method for returning a ball objcet
     * @return the Ellipse2D for this instance
     */
    public Ellipse2D.Double getBall() {
        return ballOne;
    }
    /** Method for returning x coordinate of ball
     * @return x coordinate of Ellipse2D for this instance
     */
    public double getBallX() {
        return x1;
    }
    /** Method for returning y coordinate of ball
    * @return y coordinate of Ellipse2D for this instance
    */
    public double getBallY() {
        return y1;
    }
    /** Method for changing x and y coordinates of ball
     * sets new location of ball based off of coordinates
     * @param directionX the modifier for x coordinate
     * @param directionY the modifier for y coordinate
     * @param movementVar amount to multiply modifiers by
     */
    public void move(double directionX, double directionY, double movementVar) {
        this.movementVar = movementVar;
        // movementVar determines how far to move
        //x1 and y1 determine what direction to move
        x1 += (directionX * movementVar);
        y1 += (directionY * movementVar);
        // Return ball to inside bounds of board
        if (y1 < -1.0) {
            y1 = -1.0;
        }
        if (y1 > 645.0) {
            y1 = 645.0;
        }
        // Set new location of ball
        ballOne.setFrame(x1,y1,18.0,18.0);
    }
}
