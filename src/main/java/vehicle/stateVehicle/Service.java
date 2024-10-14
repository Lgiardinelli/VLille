package vehicle.stateVehicle;


/**
 * Service state for the StateVehicle interface
 */
public class Service implements StateVehicle{

    public void toService(){};

    public void toHS(){};

    public void toRobed(){};


    public boolean isRentable(){
        return false;
    };
}
