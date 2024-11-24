package station.stationVisitor;

import exeption.NoVehicleOfThisTypeExeption;
import station.Station;
import vehicle.Overboard;

public class OverBoardVisitor implements StationVisitor{

    @Override
    public void visit(Station station) {
        try {
            station.rentVehicle(v -> v instanceof Overboard);
        } catch (NoVehicleOfThisTypeExeption e) {
            System.out.println(e);
        }
    }
}
