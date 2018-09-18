package pongpackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** Main game mode 1 class */
public class PongGame implements Runnable {
    /** Constructor for game mode 1 */
    public PongGame() {}
    /** Run method of game thread
     * runs entire game
     */
    public void run() {
        // Variable Declarations - reset once game ends
        double ballXMod = 0;
        double ballYMod = 0;
        double ballAngle;
        double ballX;
        double ballY;
        double slider1y;
        double slider2y;
        double movementVar = 0;
        int winnerVal;
        double y1Modifier = 0;
        double y2Modifier = 0;
        int rallyCounter = 0;
        int longestRally = 0;
        int playerOneScore = 0;
        int playerTwoScore = 0;
        // Creation of Frames and Panels
        JFrame window = new JFrame("Pong");
        JPanel pane = new JPanel();
        JPanel pane2 = new JPanel();
        pane.setLayout(new FlowLayout());
        pane.setSize(12,72);
        Displayables display = new Displayables();
        pane.add(display);
        pane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        pane.setVisible(true);
        window.add(pane);
        // Addition of KeyListener
        MyKeyListener listener = new MyKeyListener();
        window.addKeyListener(listener);
        window.pack();
        window.setVisible(true);
        // loop to handle whole game
        while (playerOneScore < 5 && playerTwoScore < 5) {
            boolean gameOver = false;
            // Collision objects created
            CollisionBallWall wallCollider = new CollisionBallWall(631.0, 322.0, 1.0, 0.0, 90.0);
            CollisionBallSlider sliderCollider = new CollisionBallSlider();
            ballAngle = wallCollider.getAngle();
            ballXMod = 1.0;
            ballYMod = 0.0;
            movementVar = 9;
            // Loop to handle each rally
            while (gameOver == false) {
                long startTime = System.currentTimeMillis();
                // Slider movement and determination of ball location
                y1Modifier = listener.gety1();
                y2Modifier = listener.gety2();
                ballX = display.returnBallX();
                ballY = display.returnBallY();
                slider1y = display.returnSlider1Y();
                slider2y = display.returnSlider2Y();
                // Checks for collisions and appropriate x & y modifier returned
                wallCollider.collision(ballAngle, ballXMod, ballYMod, movementVar);
                sliderCollider.collisionSlid(ballX, ballY, slider1y, slider2y, movementVar);
                boolean isSlider = sliderCollider.collisionCheck();
                if (isSlider == true) {
                    ballAngle = sliderCollider.getAngle();
                    ballXMod = sliderCollider.getX();
                    ballYMod = sliderCollider.getY();
                    rallyCounter += 1;
                }
                else {
                    ballAngle = wallCollider.getAngle();
                    ballXMod = wallCollider.getX();
                    ballYMod = wallCollider.getY();
                }
                // Movement using the x & y modifiers
                display.movement(y1Modifier, y2Modifier, ballXMod, ballYMod, movementVar, playerOneScore, playerTwoScore, rallyCounter, longestRally);
                display.repaint();
                window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                // Score tallying
                if (ballX < 23) {
                    playerTwoScore += 1;
                    gameOver = true;
                    if (longestRally <= rallyCounter) {
                        longestRally = rallyCounter;
                    }
                }

                if (ballX > 1240) {
                    playerOneScore += 1;
                    gameOver = true;
                    if (longestRally <= rallyCounter) {
                        longestRally = rallyCounter;
                    }
                }
                movementVar = movementVar + 0.006;
                try {
                    Thread.sleep(17 - totalTime);
                }
                catch(InterruptedException e) {}
            }
            if (playerOneScore < 5 && playerTwoScore < 5) {
                rallyCounter = 0;
            }
            // Winner screen displayed
            display.reset();
            movementVar = 0;
            display.movement(y1Modifier, y2Modifier, ballXMod, ballYMod, movementVar, playerOneScore, playerTwoScore, rallyCounter, longestRally);
            display.repaint();
        }

    }

}
