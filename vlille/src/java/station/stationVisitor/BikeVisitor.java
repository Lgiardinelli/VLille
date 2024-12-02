package station.stationVisitor;

import vehicle.Bike;

public class BikeVisitor extends GetVehicleVisitor{

    @Override
    protected TypeVehicleTest testMethod() {
        return v -> v instanceof Bike;
    }

}
