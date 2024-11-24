package station;

import exeption.NoVehicleOfThisTypeExeption;
import station.stateStation.Empty;
import station.stateStation.StateStation;
import station.vehicleTypeChooser.VehicleTypeChooser;
import station.vehicleTypeChooser.VehicleTypeBike;
import station.stationVisitor.StationVisitor;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage stations
 */
public class Station{

    private static int incrId = 0;
    private final int id;
    private final List<Vehicle>vehicles;
    private final int capacityMax;
    private StateStation stateStation;
    private VehicleTypeChooser vehicleTypeChooser;

    /**
     * Constructor Station
     */
    public Station() {
        this.id = createId();
        this.capacityMax = randomCapacityMax();
        this.vehicles = new ArrayList<>(this.capacityMax);
        this.stateStation = new Empty();
        this.vehicleTypeChooser = new VehicleTypeBike(this);
    }

    /**
     * Private method that creates an identifier for each station
     * @return int - Id
     */
    private static int createId() {
        return 0;
    }

    /**
     * Private method that creates a maximum vehicle capacity for each station
     * @return int - Between 10 to 20 vehicle capacity
     */
    private int randomCapacityMax() {
        return 0;
    }

    /**
     * Add parameter vehicle to station vehicle list
     * @param vehicle - The vehicle to be added
     */
    public void addVehicle(Vehicle vehicle) {

    }

    /**
     * TODO
     * @throws NoVehicleOfThisTypeExeption - if there is no vehicle of this type
     */
    public Vehicle rentVehicle() throws NoVehicleOfThisTypeExeption {
        return this.vehicleTypeChooser.takeVehicle();
    }

    /**
     * Accept or reject visitors to the station
     * @param stationVisitor - Visitor type
     * @return boolean - True if accepted False otherwise
     */
    public boolean accept(StationVisitor stationVisitor) {
        return false;
    }

    /**
     * Changes vacuum station status
     */
    public void toEmpty() {
    }

    /**
     * Changes station state to 1 vehicle remaining
     */
    public void toOneVehicleLeft() {

    }

    /**
     * Changes station state to Normal
     */
    public void toNormal() {
    }

    /**
     * Changes station vehicle to full
     */
    public void toFull() {

    }

    /**
     * Can the station be stolen?
     * @return boolean - true or false
     */
    public boolean canBeRobed() {
        return false;
    }

    /**
     * can the station accommodate vehicle ?
     * @return boolean - true or false
     */
    public boolean canBeDropOff() {
        return false;
    }

    /**
     * can the station rent vehicle
     * return boolean - true or false
     */
    public boolean canBeRent() {
        return false;
    }

    /**
     * setter for the setStateTypeVehicleToRent
     * @param vehicleTypeChooser
     */
    public void setStateTypeVehicleToRent(VehicleTypeChooser vehicleTypeChooser) {
        this.vehicleTypeChooser = vehicleTypeChooser;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }


    public void toTakeOverBoard() {
        this.vehicleTypeChooser.toTakeOverBoard();
    }


    public void toTakeBike() {
        this.vehicleTypeChooser.toTakeBike();

    }


    public void toTakeScooter() {
        this.vehicleTypeChooser.toTakeScooter();

    }
}
