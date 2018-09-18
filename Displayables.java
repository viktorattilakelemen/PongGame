package pongpackage;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
/** Class for all displayable objects
 * places all of objects in to one JComponent
 * and then paints the objects
 */
public class Displayables extends JComponent {
    // Instance variable declarations
    Slider rect1;
    Slider rect2;
    Ball ballOne;
    Ball ballTwo;
    Ball ballThree;
    Rectangle2D.Double usableRect1;
    Rectangle2D.Double usableRect2;
    Ellipse2D.Double usableBallOne;
    Ellipse2D.Double usableBallTwo;
    Ellipse2D.Double usableBallThree;
    double movementVar;
    boolean twoBallTrue = false;
    boolean threeBallTrue = false;
    int playerOneScore;
    int playerTwoScore;
    int rallyCounter;
    int longestRally;
    BufferedImage image;
    /** Constructor for displayable class
     * calls reader for dan pic and calls
     * for reset of all objects
     */
    public Displayables() {
        this.danCreator();
        this.reset();
    }
    /** Creates image object of dan */
    public void danCreator() {
       try {
          image = ImageIO.read(new File("dan.png"));
       } catch (IOException ex) {
       }
    }
    /** Resets location of all displayables for new round */
    public void reset() {
        rect1 = new Slider(60,271.01);
        rect2 = new Slider(1208,271.1);
        ballOne = new Ball(631, 322);
        ballTwo = new Ball(631,322);
        ballThree = new Ball(631,322);
        twoBallTrue = false;
        threeBallTrue = false;
    }
    /** Movement method for one ball
     * calls movement methods for ball and sliders
     * @param y1Mod movement mod for slider one
     * @param y2Mod movement mod for slider two
     * @param ballX direction mod for ball x
     * @param ballY direction mod for ball y
     * @param movementVar amount to move ball
     * @param playerOneScore current player one score
     * @param playerTwoScore current player two score
     * @param rallyCounter current hits in the rally
     * @param longestRally longest amount of hits between all rallies
     */
    public void movement(double y1Mod, double y2Mod, double ballX, double ballY, double movementVar, int playerOneScore, int playerTwoScore, int rallyCounter, int longestRally) {
        this.movementVar = movementVar;
        rect1.move(y1Mod);
        rect2.move(y2Mod);
        ballOne.move(ballX, ballY, movementVar);
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.rallyCounter = rallyCounter;
        this.longestRally = longestRally;
    }
    /** Movement method for two balls
     * calls movement methods for balls and sliders
     * @param y1Mod movement mod for slider one
     * @param y2Mod movement mod for slider two
     * @param ballX direction mod for ball x
     * @param ballY direction mod for ball y
     * @param ballX2 direction mod for ball 2 x
     * @param ballY2 direction mod for ball 2 y
     * @param movementVar amount to move ball
     * @param playerOneScore current player one score
     * @param playerTwoScore current player two score
     * @param rallyCounter current hits in the rally
     * @param longestRally longest amount of hits between all rallies
     */
    public void movement2(double y1Mod, double y2Mod, double ballX, double ballY, double ballX2, double ballY2, double movementVar, int playerOneScore, int playerTwoScore, int rallyCounter, int longestRally) {
        twoBallTrue = true;
        this.movementVar = movementVar;
        rect1.move(y1Mod);
        rect2.move(y2Mod);
        ballOne.move(ballX, ballY, movementVar);
        ballTwo.move(ballX2, ballY2, movementVar);
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.rallyCounter = rallyCounter;
        this.longestRally = longestRally;
    }
    /** Movement method for two balls
     * calls movement methods for balls and sliders
     * @param y1Mod movement mod for slider one
     * @param y2Mod movement mod for slider two
     * @param ballX direction mod for ball x
     * @param ballY direction mod for ball y
     * @param ballX2 direction mod for ball 2 x
     * @param ballY2 direction mod for ball 2 y
     * @param ball3X direction mod for ball 3 x
     * @param ball3Y direction mod for ball 3 y
     * @param movementVar amount to move ball
     * @param playerOneScore current player one score
     * @param playerTwoScore current player two score
     * @param rallyCounter current hits in the rally
     * @param longestRally longest amount of hits between all rallies
     */
    public void movement3(double y1Mod, double y2Mod, double ballX, double ballY, double ballX2, double ballY2, double ballX3, double ballY3, double movementVar, int playerOneScore, int playerTwoScore, int rallyCounter, int longestRally) {
        threeBallTrue = true;
        this.movementVar = movementVar;
        rect1.move(y1Mod);
        rect2.move(y2Mod);
        ballOne.move(ballX, ballY, movementVar);
        ballTwo.move(ballX2, ballY2, movementVar);
        ballThree.move(ballX3, ballY3, movementVar);
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
        this.rallyCounter = rallyCounter;
        this.longestRally = longestRally;
    }
    /** Standard paint method for JComponents
     * paints all displayables in display class
     * @param g object of AWT Graphics class
     */
    public void paintComponent(Graphics g) {
        // Getting coordinates of all objects for painting
        usableRect1 = rect1.getRect();
        usableRect2 = rect2.getRect();
        usableBallOne = ballOne.getBall();
        usableBallTwo = ballTwo.getBall();
        usableBallThree = ballThree.getBall();
        Graphics2D g2 = (Graphics2D) g;
        Font myFont = new Font("Courier New", Font.BOLD, 22);
        Font otherFont = new Font("Courier New", Font.BOLD, 16);
        // Painting begins here
        g2.setFont(myFont);
        g2.setColor(Color.BLACK);
        g2.fill(usableRect1);
        g2.fill(usableRect2);
        g2.setColor(Color.BLUE);
        g2.fill(usableBallOne);
        if (twoBallTrue == true) {
            g2.setColor(Color.RED);
            g2.fill(usableBallTwo);
        }
        if (threeBallTrue == true) {
            g2.setColor(Color.GREEN);
            g2.fill(usableBallThree);
        }
        g2.setColor(Color.BLUE);
        g2.drawString("Player One Score: " + playerOneScore, 80, 30);
        g2.drawString("Player Two Score: " + playerTwoScore, 950, 30);
        g2.setFont(otherFont);
        g2.drawString("Rally Counter: " + rallyCounter, 564, 600);
        g2.drawString("Longest Rally: " + longestRally, 564, 624);
        g2.setFont(myFont);
        if (playerOneScore == 5) {
            g2.drawString("Player One Wins!!!", 538, 255);
            g2.drawImage(image, 536,340, this);
        }
        if (playerTwoScore == 5) {
            g2.drawString("Player Two Wins!!!", 538, 288);
            g2.drawImage(image, 536, 340, this);
        }

    }
    /** Sets JComponent size to (1280, 662)
     * @return the dimension of the JComponent
     */
    public Dimension getPreferredSize() {
        return new Dimension(1280,662);
    }
    /** gives ball one x to game thread
     * @return ball one x
     */
    public double returnBallX() {
        double xval = ballOne.getBallX();
        return xval;
    }
    /** gives ball one y to game thread
     * @return ball one y
     */
    public double returnBallY() {
        double yval = ballOne.getBallY();
        return yval;
    }
    /** gives ball two x to game thread
     * @return ball two x
     */
    public double returnBall2X() {
        double xval = ballTwo.getBallX();
        return xval;
    }
    /** gives ball two y to game thread
     * @return ball two y
     */
    public double returnBall2Y() {
        double yval = ballTwo.getBallY();
        return yval;
    }
    /** gives ball three x to game thread
     * @return ball three x
     */
    public double returnBall3X() {
        double xval = ballThree.getBallX();
        return xval;
    }
    /** gives ball three y to game thread
     * @return ball three y
     */
    public double returnBall3Y() {
        double yval = ballThree.getBallY();
        return yval;
    }
    /** gives slider one y value to game thread
     * @return slider one y
     */
    public double returnSlider1Y() {
        double slide1Y = rect1.getSliderY();
        return slide1Y;
    }
    /** gives slider two y value to game thread
     * @return slider two y
     */
    public double returnSlider2Y() {
        double slide2Y = rect2.getSliderY();
        return slide2Y;
    }
}
