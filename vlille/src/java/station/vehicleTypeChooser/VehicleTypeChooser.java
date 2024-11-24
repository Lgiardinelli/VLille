package station.vehicleTypeChooser;

import exeption.NoVehicleOfThisTypeExeption;
import station.Station;
import vehicle.Vehicle;

public abstract class VehicleTypeChooser {

    protected Station station;

    public VehicleTypeChooser(Station station) {
        this.station = station;
    }

    /**
     * Changes the state to take a bike
     */
    public final void toTakeBike(){
        this.station.setStateTypeVehicleToRent(new VehicleTypeOverBoard(this.station));
    }

    /**
     * Changes the state to take a scooter
     */
    public final void toTakeScooter(){
        this.station.setStateTypeVehicleToRent(new VehicleTypeScooter(this.station));
    }

    /**
     * Changes the state to take an overboard
     */
    public final void toTakeOverBoard(){
        this.station.setStateTypeVehicleToRent(new VehicleTypeOverBoard(this.station));
    }

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
