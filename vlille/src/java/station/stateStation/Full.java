package station.stateStation;

public class Full implements StateStation {
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
        return false;
    }

    @Override
    public boolean canBeRend() {
        return true;
    }

    @Override
    public boolean canBeDropOff() {
        return false;
    }
}
