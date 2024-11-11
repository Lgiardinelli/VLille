package station.stateTypeVehicleToRent;

import station.Station;
import vehicle.Overboard;
import vehicle.Scooter;
import vehicle.Vehicle;

public class TakeScooterState extends StateTypeVehicleToRent {
    public TakeScooterState(Station station) {
        super(station);
    }

    @Override
    public void toTakeOverBoard() {
        this.station.setStateTypeVehicleToRent(new TakeOverBoardState(this.station));
    }

    @Override
    public void toTakeBike() {
        this.station.setStateTypeVehicleToRent(new TakeBikeState(this.station));

    }

    @Override
    public void toTakeScooter() {

    }

    @Override
    public boolean testTypeVehcile(Vehicle vehicle) {
        return vehicle instanceof Scooter;
    }
}
