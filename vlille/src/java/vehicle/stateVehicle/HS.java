package vehicle.stateVehicle;



/**
 * HS state for the StateVehicle interface
 */
public class HS implements StateVehicle{

    @Override
    public void toService(){};

    @Override
    public void toHS(){};

    @Override
    public void toRobed(){};

    @Override
    public boolean isRentable(){
        return false;
    };
}
