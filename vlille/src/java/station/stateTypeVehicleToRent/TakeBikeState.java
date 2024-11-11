package station.stateTypeVehicleToRent;

import station.Station;
import vehicle.Bike;
import vehicle.Vehicle;

public class TakeBikeState extends StateTypeVehicleToRent{

    public TakeBikeState(Station station) {
        super(station);
    }

    @Override
    public void toTakeBike() {

    }

    @Override
    public void toTakeScooter() {
        this.station.setStateTypeVehicleToRent(new TakeScooterState(this.station));
    }

    @Override
    public void toTakeOverBoard() {
        this.station.setStateTypeVehicleToRent(new TakeOverBoardState(this.station));
    }

    @Override
    public boolean testTypeVehcile(Vehicle vehicle) {
        return vehicle instanceof Bike;
    }
}
