package vehicle;

import vehicle.vehicleVisitor.VehicleVisitor;

/**
 * Scooter class
 */
public class Scooter extends Vehicle {

    /**
     * Constructor scooter
     * @param id - the id
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
