package station.stateTypeVehicleToRent;

import exeption.NoVehicleOfThisTypeExeption;
import station.Station;
import vehicle.Vehicle;

public abstract class StateTypeVehicleToRent {

    protected Station station;

    public StateTypeVehicleToRent(Station station) {
        this.station = station;
    }

    /**
     * Changes the state to take a bike
     */
    public abstract void toTakeBike();

    /**
     * Changes the state to take a scooter
     */
    public abstract void toTakeScooter();

    /**
     * Changes the state to take an overboard
     */
    public abstract void toTakeOverBoard();

    /**
     * Takes a vehicle from the station and returns it
     * @return a vehicle of the choosen type
     */
    public final Vehicle takeVehicle() throws NoVehicleOfThisTypeExeption {
        for(Vehicle vehicle : station.getVehicles()){
            if(testTypeVehcile(vehicle)){
                station.getVehicles().remove(vehicle);
                return vehicle;
            }
        }
        throw new NoVehicleOfThisTypeExeption("No vehicle of this type in the station");
    }

    /**
     * Tests if the vehicle is of the right type
     * @param vehicle - the vehicle to test
     * @return a boolean - true if the vehicle is of the right type, false otherwise
     */
    public abstract boolean testTypeVehcile(Vehicle vehicle);



}
