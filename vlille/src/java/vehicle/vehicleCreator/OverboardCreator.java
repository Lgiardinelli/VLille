package vehicle.vehicleCreator;

import vehicle.Overboard;

/**
 * class OverboardCreator generates overboards
 */
public class OverboardCreator extends VehicleCreator {

    private int id;

    /**
     * Constructor
     */
    public OverboardCreator() {
        this.id = generateId();
    }
    /**
     * {@inheritDoc}.
     * Create a Overboard
     * @return Overboard
     */
    public Overboard createVehicle() {
        return new Overboard();
    }

    /**
     * Return id of this vehicle
     * @return int - the id of this vehicle
     */
    public int getId() {
        return id;
    }
}
