package station.vehicleTypeChooser;

import station.Station;
import vehicle.Scooter;
import vehicle.Vehicle;

public class VehicleTypeScooter extends VehicleTypeChooser {
    public VehicleTypeScooter(Station station) {
        super(station);
    }


    @Override
    public boolean testTypeVehcile(Vehicle vehicle) {
        return vehicle instanceof Scooter;
    }
}
