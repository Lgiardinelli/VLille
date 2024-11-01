package vehicle.vehicleCreator;

import vehicle.Bike;

/**
 * class BikeCreator generates bikes
 */
public class BikeCreator extends VehicleCreator {

    /**
     * Constructor
     */
    public BikeCreator() {
    }

    /**
     * {@inheritDoc}.
     * Create a Bike
     * @return Bike
     */
    public Bike createVehicle() {
        return new Bike();
    }
}
