package station.stationVisitor;

import exeption.NoVehicleOfThisTypeExeption;
import station.Station;
import vehicle.Overboard;
import vehicle.Scooter;

public class ScooterVisitor implements StationVisitor{
    @Override
    public void visit(Station station) {
        try {
            station.rentVehicle(v -> v instanceof Scooter);
        } catch (NoVehicleOfThisTypeExeption e) {
            System.out.println(e);
        }
    }
}
