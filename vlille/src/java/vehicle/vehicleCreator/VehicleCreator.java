package vehicle.vehicleCreator;

import vehicle.Vehicle;

/**
 * class VehicleCreator
 */
public abstract class VehicleCreator {

    /**
     * Constructor
     */
    public VehicleCreator() {
    }

    /**
     * method that creates a vehicle and return it, when the vehicle is created a unique id is generated for it by the method generateId()
     * @return Vehicle
     */
    public abstract Vehicle createVehicle();

    /**
     * method that generates a unique id for a vehicle
     * @return int
     */
    private int generateId() {
        return 0;
    }
}