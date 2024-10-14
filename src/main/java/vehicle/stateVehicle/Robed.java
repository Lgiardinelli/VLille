package vehicle.stateVehicle;

/**
 * Robed state for the StateVehicle interface
 */
public class Robed implements StateVehicle{

    public void toService(){};

    public void toHS(){};

    public void toRobed(){};

    public boolean isRentable(){
        return false;
    };
}
