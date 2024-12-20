package vehicle.vehicleVisitor;

import vehicle.Vehicle;

public class MockVehicle extends Vehicle {

    public int applyCalled = 0;

    public MockVehicle() {
        super();
    }

    @Override
    public String decorateEquipment() {
        this.applyCalled += 1;
        return "";
    }
}
