package vehicle.stateVehicle;


/**
 * Service state for the StateVehicle interface
 */
public class Service implements StateVehicle{


    @Override
    public void toService(){};

    @Override
    public void toHS(){};

    @Override
    public void toRobed(){};

    @Override
    public boolean isRentable(){
        return true;
    };
}
