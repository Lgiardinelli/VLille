package station;

import exeption.StationFullException;
import vehicle.Vehicle;

public class MockStationVehcNbTimeRent extends Station{

    @Override
    public void DropOffVehicle(Vehicle vehicle) throws StationFullException {
        vehicle.addOneNbTimeRented();
    }
}
