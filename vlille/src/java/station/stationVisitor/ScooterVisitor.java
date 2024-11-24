package station.stationVisitor;

import vehicle.Overboard;

public class ScooterVisitor extends GetVehicleVisitor{

    @Override
    protected TypeVehicleTest testMethod() {
        return v -> v instanceof Overboard;
    }
}
