package vehicle;

import vehicle.stateVehicle.Service;

public class MockVehicle extends Vehicle{




    public MockVehicle(int id) {
        super(id);
    }

    @Override
    public String decorateEquipment() {
        return "";
    }

    @Override
    protected int nbMaxTimeRented() {
        return 1;
    }





}
