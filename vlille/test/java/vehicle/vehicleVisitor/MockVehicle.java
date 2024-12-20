package vehicle.vehicleVisitor;

import vehicle.Vehicle;

public class MockVehicle extends Vehicle {

    public int applyCalled = 0;

    public MockVehicle() {
        super(0);
    }

    @Override
    public String decorateEquipment() {
        this.applyCalled += 1;
        return "";
    }

    @Override
    protected int nbMaxTimeRented() {
        return 1;
    }
}
