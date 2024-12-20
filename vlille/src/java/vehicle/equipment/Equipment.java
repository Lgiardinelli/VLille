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
        super(vehicle.getId());
        this.vehicle = vehicle;
    }

    @Override
    public String decorateEquipment() {
        return vehicle.decorateEquipment().contains("with")? String.format("%sand ",vehicle.decorateEquipment()):String.format("%s with ",vehicle.decorateEquipment());
    }

    @Override
    protected int nbMaxTimeRented() {
        return vehicle.getNbTimeRented();
    }
}
