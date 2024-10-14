package station.stateStation;

public interface StateStation {

    public void toEmpty();

    public  void toOneVehicleLeft();

    public void toNormal();

    public void toFull();

    public boolean canBeRobed();

    public boolean canBeRend();

    public boolean canBeDropOff();

}
