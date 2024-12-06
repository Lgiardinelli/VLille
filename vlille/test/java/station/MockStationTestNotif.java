package station;

import controlCenter.ControlCenter;

import exeption.StationFullException;
import station.stationVisitor.TypeVehicleTest;
import vehicle.Bike;
import vehicle.Vehicle;

public class MockStationTestNotif extends Station{

    public MockStationTestNotif(ControlCenter c){
        super();
        this.addSubscriber(c);
    }

    public MockStationTestNotif(){
        super();
    }

    @Override
    public void DropOffVehicle(Vehicle vehicle) throws StationFullException {
        this.subsribers.forEach(t -> t.notifyStationVehicleAdded(this));
    }



    @Override
    public Vehicle rentVehicle(TypeVehicleTest t) {
        this.subsribers.forEach(x -> x.notifyStationVehicleTaked(this));
        return new Bike();
    }
}

