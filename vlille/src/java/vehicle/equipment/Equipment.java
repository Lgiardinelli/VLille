package vehicle.equipment;

import vehicle.Vehicle;

/**
 * Equipment class.
 */
public class Equipment extends Vehicle {

    private Vehicle vehicle;

    /**
     * Constructor.
     * @param vehicle the vehicle
     */
    public Equipment(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void decorateEquipment() {
        vehicle.decorateEquipment();
    }
}
