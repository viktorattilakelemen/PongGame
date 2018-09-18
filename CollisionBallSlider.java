package pongpackage;
/** class to handle ball to slider collisions*/
public class CollisionBallSlider{
    boolean isCollision;
    double ballX;
    double ballY;
    double sliderLY;
    double sliderRY;
    int sliderLFrontX = 72;
    int sliderRFrontX = 1208;
    //position of ball impact on slider in terms of pixels
    double absPos;
    //position of ball impact on slider in terms of slider length (0-120pixels)
    double relPos;
    double angleOut;

    double xMod;
    double yMod;
    double movementVar;

    /** constructor */
    public CollisionBallSlider(){
    }
    /** Method for creating slider collisions
     * @param ballX x of ball
     * @param ballY y of ball
     * @param sliderLY left slider y
     * @param sliderRY right slider y
     * @param movementVar amount to move ball
     */
    public void collisionSlid(double ballX, double ballY, double sliderLY, double sliderRY, double movementVar){
        this.movementVar = movementVar;
        this.ballX = ballX;
        this.ballY = ballY;
        this.sliderLY = sliderLY;
        this.sliderRY = sliderRY;
        //checks if left slider is blocking path of ball
        absPos = ballY + 9;
        //left slider collision
        if (sliderLY <= absPos && absPos <= (sliderLY + 120)){
            if (ballX <= sliderLFrontX){
                if (ballX > sliderLFrontX - 25){
                    isCollision = true;
                    //find relative position of ball center to slider
                    relPos = absPos - sliderLY;
                    //calculate angle
                    angleOut = (relPos * 1.2166666) + 17;
                    //System.out.println(angleOut);
                }
            }



        }
        //if ball hits top or bottom of slider


        //right slider collision

        if (sliderRY <= absPos && absPos <= (sliderRY + 120)){
            if ((ballX + 18) >= sliderRFrontX){
                if ((ballX + 18) < sliderRFrontX + 25){
                    isCollision = true;
                    //find relative position of ball center to slider
                    relPos = absPos - sliderRY;
                    //calculate angle
                    angleOut = (relPos * -1.2166666) + 343;
                    //System.out.println(angleOut);
                }
            }
        }
        //if ball hits top or bottom of slider

        //set variables based on the angle
        Collision coli = new Collision();
        coli.angleToXYmod(angleOut);
        xMod = coli.getX();
        yMod = coli.getY();

    }
    /** Checks if collision occured
     * @return boolean result of collision check
     */
    public boolean collisionCheck(){
        if (isCollision == true){
            isCollision = false;
            return true;
        }
        else {
            return false;
        }
    }
    /** @return the value by which ball x should be modified*/
    public double getX(){
        return xMod;
    }
    /** @return the value by which ball y should be modified*/
    public double getY(){
        return yMod;
    }
    /**#@return the outgoing angle */
    public double getAngle(){
        //System.out.println(angleOut);
        return angleOut;
    }


}
