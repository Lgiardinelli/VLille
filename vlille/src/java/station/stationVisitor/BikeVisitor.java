package station.stationVisitor;

import exeption.NoVehicleOfThisTypeExeption;
import station.Station;
import vehicle.Bike;
import vehicle.Vehicle;

public class BikeVisitor implements StationVisitor{

    @Override
    public void visit(Station station) {
        try {
            Vehicle vehicle = station.rentVehicle(v -> v instanceof Bike);
        } catch (NoVehicleOfThisTypeExeption e) {
            System.out.println(e);
        }
    }

}
