package vehicle;

import vehicle.vehicleVisitor.VehicleVisitor;

/**
 * Bike class
 */
public class Bike extends Vehicle {
    /**
     * Bike constructor
     */
    public static final int maxNbTimeRented = 6;

    public Bike(int id) {
        super(id);
    }

    @Override
    public String decorateEquipment() {
        return "This is a Bike";
    }

    @Override
    protected int nbMaxTimeRented() {
        return maxNbTimeRented;
    }

    @Override
    public void accept(VehicleVisitor visitor) throws Exception {
        visitor.visit(this);
    }
}
