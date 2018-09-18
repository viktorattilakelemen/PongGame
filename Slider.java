package pongpackage;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D.Double;
import java.awt.geom.Rectangle2D;

/** Class for slider objects (pong paddles)*/
public class Slider {
    Rectangle2D.Double rect1;
    double x1;
    double y1;
    /** constructor, creates slider object
    * @param x1 refers to the initial x coordinate of the slider
    * @param y1 refers to the initial y coordinate of the Slider
    */
    public Slider(double x1, double y1) {
        this.rect1 = new Double(x1,y1,12,120);
        this.x1 = x1;
        this.y1 = y1;
    }
    /** method to move the slider, by changing its y value
    * @param y1Mod holds the direction of the move, if there is any
    */
    public void move(double y1Mod) {
        //y1Mod == 0.0 acts as the boolean false
        if (y1Mod == -1.0 || y1Mod == 1.0 || y1Mod == 0.0) {
            if (y1Mod != 0.0) {
                //checks if slider is hitting north or south wall
                if (y1 > 0.0 && y1 < 542.0) {
                    //13 is the slider-speed coefficient
                    y1Mod = y1Mod * 13;
                    y1 += y1Mod;
                    this.rect1.setRect(x1, y1,12,120);
                }
                //makes sliders bump into wall
                if (y1 < 0.0) {
                    y1 = 0.0;
                }
                if (y1 > 542.0) {
                    y1 = 542.0;
                }
                //lets sliders 'turn around' at walls
                if (y1 == 0.0 && y1Mod == 1.0) {
                    y1 += 1.0;
                    this.rect1.setRect(x1, y1,12,120);
                }
                if (y1 == 542.0 && y1Mod == -1.0) {
                    y1 += -1.0;
                    this.rect1.setRect(x1,y1,12,120);
                }
            }
        }

    }
    /** @return the rectangle representation of the slider object*/
    public Rectangle2D.Double getRect() {
        return rect1;
    }
    /** @return the y position of the slider object*/
    public double getSliderY() {
        return y1;
    }
}
