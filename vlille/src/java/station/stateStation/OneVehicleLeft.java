package station.stateStation;

public class OneVehicleLeft implements StateStation {
    @Override
    public void toEmpty() {

    }

    @Override
    public void toOneVehicleLeft() {

    }

    @Override
    public void toNormal() {

    }

    @Override
    public void toFull() {

    }

    @Override
    public boolean canBeRobed() {
        return true;
    }

    @Override
    public boolean canBeRend() {
        return true;
    }

    @Override
    public boolean canBeDropOff() {
        return true;
    }
}
