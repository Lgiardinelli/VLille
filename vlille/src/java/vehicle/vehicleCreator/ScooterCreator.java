package vehicle.vehicleCreator;

import vehicle.Scooter;

/**
 * class ScooterCreator generates scooters
 */
public class ScooterCreator extends VehicleCreator {
    /**
     * Constructor
     */
    public ScooterCreator() {
    }
    /**
     * {@inheritDoc}.
     * Create a scooter
     * @return Scooter
     */
    public Scooter createVehicle() {
        return new Scooter();
    }
}
