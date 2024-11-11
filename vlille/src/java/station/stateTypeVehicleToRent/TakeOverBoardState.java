package station.stateTypeVehicleToRent;

import station.Station;
import vehicle.Overboard;
import vehicle.Vehicle;

public class TakeOverBoardState extends StateTypeVehicleToRent {
    public TakeOverBoardState(Station station) {
        super(station);
    }

    @Override
    public void toTakeOverBoard() {

    }

    @Override
    public void toTakeBike() {
        this.station.setStateTypeVehicleToRent(new TakeBikeState(this.station));

    }

    @Override
    public void toTakeScooter() {
        this.station.setStateTypeVehicleToRent(new TakeScooterState(this.station));

    }

    @Override
    public boolean testTypeVehcile(Vehicle vehicle) {
        return vehicle instanceof Overboard;
    }
}
