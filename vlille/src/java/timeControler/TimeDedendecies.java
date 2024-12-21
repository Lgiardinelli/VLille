package timeControler;


/**
 * Class for the Object depended to time
 */
public abstract class TimeDedendecies {

    private final Time time = new Time();

    /**
     * method that force Objet dependent to time to define a method to update time each interval
     */
    protected abstract void updateTime();
}
