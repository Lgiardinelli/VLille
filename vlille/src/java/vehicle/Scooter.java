package vehicle;

import vehicle.vehicleVisitor.VehicleVisitor;

/**
 * Scooter class
 */
public class Scooter extends Vehicle {

    /**
     * Scooter constructor
     */
    public Scooter(int id) {
        super(id);
    }

    @Override
    public String decorateEquipment() {
        return "This is a Scooter";
    }

    @Override
    protected int nbMaxTimeRented() {
        return 4;
    }

    @Override
    public void accept(VehicleVisitor visitor) throws Exception {
        visitor.visit(this);
    }
}
