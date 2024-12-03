package station;

import controlCenter.ControlCenter;

import exeption.NoVehicleOfThisTypeAvailableException;
import station.stationVisitor.TypeVehicleTest;
import vehicle.Vehicle;

public class MockStation extends Station{

    public MockStation(ControlCenter c){
        super();
        this.addSubscriber(c);
    }

    public MockStation(){
        super();
    }

    @Override
    public void DropOffVehicle(Vehicle vehicle) {
        super.DropOffVehicle(vehicle);
        this.subsribers.forEach(t -> t.notifyStationVehicleAdded(this));
    }

    protected int randomCapacityMax() {
        return 2;
    }

    @Override
    public Vehicle rentVehicle(TypeVehicleTest t) throws NoVehicleOfThisTypeAvailableException {
        Vehicle vehicle = super.rentVehicle(t);
        this.subsribers.forEach(x -> x.notifyStationVehicleTaked(this));
        return vehicle;
    }
}

}
