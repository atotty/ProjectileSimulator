/**
 * Represents a model of a projectile for the simulator.
 */
public class Projectile {
    /*
     * Add any fields you find useful in your implementation. Make sure they are private!
     */


    /**
     * Creates a Projectile object.
     * If speed is negative, throws an IllegalArgumentException.
     * If timeSteps is zero or negative, throws an IllegalArgumentException.
     * @param xPos
     * @param yPos
     * @param speed
     * @param angleDeg
     * @param timeSteps
     */
    public Projectile(double xPos, double yPos, double speed, double angleDeg, int timeSteps)  {

    }

    /**
     * Advances the projectile one time step. If all time steps have elapsed for
     * this projectile, the state does not change.
     *
     * @return Returns the current time step.
     */
    public int step() {
        return -1;

    }

    /**
     * Getter for the current x-position of the projectile.
     * @return The current x-position
     */
    public double getXPos() {
        return -50.0;

    }

    /**
     * Getter for the current y-position of the projectile.
     * @return The current y-position
     */
    public double getYPos() {
        return -50.0;

    }

    /**
     * Returns a String containing information about this Projectile object.
     * This can be extremely helpful for you as you write and debug your program,
     * but you are not required to change this code.
     * @return A String with information about this object.
     */
    @Override
    public String toString() {
        return "";
    }
}
