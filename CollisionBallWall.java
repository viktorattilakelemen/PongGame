package pongpackage;
/** class to handle ball to wall collisions and no collision */
public class CollisionBallWall{
    double x;
    double y;
    double angleIn;
    double angleOut;
    double xMod;
    double yMod;
    double movementVar;

    /** constructor
    * @param x the current x coordinate of the ball
    * @param y the current y coordinate of the ball
    * @param xMod the current x coordinate mod, to keep ball on its path
    * @param yMod the current y coordinate mod, to keep ball on its path
    * @param angleOut angle at which the ball is currently traveling
    */
    public CollisionBallWall(double x, double y, double xMod, double yMod, double angleOut){
        this.x = x;
        this.y = y;
        this.xMod = xMod;
        this.yMod = yMod;
        this.angleOut = angleOut;
    }

    /** if there is a collision, sets outgoing angle and xMod yMod variables, if no collision,
    *returns zeros and outgoing angle
    * @param angleIn the angle at which the ball hits the wall
    * @param currXMod the current x coordinate mod, to keep ball on its path
    * @param currYMod the current y coordinate mod, to keep ball on its path
    * @param movementVar keeps track of the ball speed coefficient
    */
    public void collision(double angleIn, double currXMod, double currYMod, double movementVar){
        this.movementVar = movementVar;
        this.angleIn = angleIn;
        // if ball reaches outside of game frame, it gets put back
        if (y < -1.0) {
            y = -1.0;
        }
        if (y > 645.0) {
            y = 645.0;
        }
        //Master if: if collisioin with north/south wall happens
        if (y < 0 || y > 644){
            //figuring out output angle from input angle
            if (angleIn < 270 && angleIn > 90){
                angleOut = (270 - angleIn) + 270;
                if (angleOut > 360) {
                    angleOut -= 360;
                }
                if (angleOut < 0) {
                    angleOut += 360;
                }
            } else {
                angleOut = (90 - angleIn) + 90;
                if (angleOut < 0) {
                    angleOut += 360;
                }
                if (angleOut > 360) {
                    angleOut -= 360;
                }
            }
            // the collision class deals with the converison from angle to x, y coordinate mods
            Collision coli = new Collision();
            coli.angleToXYmod(angleOut);
            xMod = coli.getX();
            yMod = coli.getY();
        // if no collision has happened, incoming and outgoing values are the same
        } else {
            angleOut = angleIn;
            this.xMod = currXMod;
            this.yMod = currYMod;
        }
        //modified x and y values get stored in variables
        x += (xMod * movementVar);
        y += (yMod * movementVar);
    }
    /** @return the value by which ball x coord should be modified */
    public double getX(){
        return xMod;
    }
    /** @return the value by which ball y coord should be modified*/
    public double getY(){
        return yMod;
    }
    /** @return the angle at which the ball should proceed*/
    public double getAngle(){
        return angleOut;
    }
}
