package vehicle.vehicleCreator;

import vehicle.Overboard;

/**
 * class OverboardCreator generates overboards
 */
public class OverboardCreator extends VehicleCreator {
    /**
     * Constructor
     */
    public OverboardCreator() {
    }
    /**
     * {@inheritDoc}.
     * Create a Overboard
     * @return Overboard
     */
    public Overboard createVehicle() {
        return new Overboard();
    }
}
