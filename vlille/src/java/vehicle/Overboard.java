package vehicle;

import vehicle.vehicleVisitor.VehicleVisitor;

/**
 * Overboard class
 */
public class Overboard extends Vehicle {

    /**
     * Overboard constructor
     */
    public Overboard(int id) {
        super(id);
    }

    @Override
    public String decorateEquipment() {
        return "This is an Overboard";
    }

    @Override
    protected int nbMaxTimeRented() {
        return 2;
    }

    @Override
    public void accept(VehicleVisitor visitor) throws Exception {
        visitor.visit(this);
    }
}
