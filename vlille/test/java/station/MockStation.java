package station;

import controlCenter.ControlCenter;
import exeption.NoVehicleOfThisTypeExeption;
import vehicle.Vehicle;

public class MockStation extends Station{

    public MockStation(ControlCenter c){
        super();
        this.addSubscriber(c);
    }

    @Override
    public void DropOffVehicle(Vehicle vehicle) {
        super.DropOffVehicle(vehicle);
        this.subsribers.forEach(t -> t.notifyStationVehicleAdded(this));
    }


    @Override
    public Vehicle rentVehicle() throws NoVehicleOfThisTypeExeption {
        Vehicle vehicle = super.rentVehicle();
        this.subsribers.forEach(t -> t.notifyStationVehicleTaked(this));
        return vehicle;
    }
}

