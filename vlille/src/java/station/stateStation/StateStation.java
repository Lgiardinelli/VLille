package station.stateStation;

/**
 * Interface for all possible station states
 */
public interface StateStation {

    /**
     * Changes station status to empty
    */
    public void toEmpty();

    /**
     * Changes station status to one vehicle left
     */
    public  void toOneVehicleLeft();

    /**
     * Changes station status to Normal
     */
    public void toNormal();

    /**
     * Changes station status to Full
     */
    public void toFull();

    /**
     * Checks if the station can be stolen
     * @return boolean - true if there is a bike in the station, false otherwise
     */
    public boolean canBeRobed();

    /**
     * Checks if the station can rent a vehicle
     * @return boolean - true if there is at least one bike in the station, false otherwise
     */
    public boolean canBeRend();

    /**
     * Checks whether the station can hold vehicles
     * @return boolean - true if there is at least one free space in the station, false otherwise
     */
    public boolean canBeDropOff();

}
