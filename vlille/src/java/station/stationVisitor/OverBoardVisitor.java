package station.stationVisitor;

import vehicle.Overboard;

public class OverBoardVisitor extends GetVehicleVisitor{

    @Override
    protected TypeVehicleTest testMethod() {
        return v -> v instanceof Overboard;
    }
}
