package station.vehicleTypeChooser;

import station.Station;
import vehicle.Overboard;
import vehicle.Vehicle;

public class VehicleTypeOverBoard extends VehicleTypeChooser {
    public VehicleTypeOverBoard(Station station) {
        super(station);
    }

    @Override
    public boolean testTypeVehcile(Vehicle vehicle) {
        return vehicle instanceof Overboard;
    }
}
