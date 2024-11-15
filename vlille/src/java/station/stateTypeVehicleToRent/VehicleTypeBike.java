package station.stateTypeVehicleToRent;

import station.Station;
import vehicle.Bike;
import vehicle.Vehicle;

public class VehicleTypeBike extends VehicleTypeChooser {

    public VehicleTypeBike(Station station) {
        super(station);
    }


    @Override
    public boolean testTypeVehcile(Vehicle vehicle) {
        return vehicle instanceof Bike;
    }
}
