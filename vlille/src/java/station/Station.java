package station;

import controlCenter.ControlCenter;
import exeption.NoVehicleOfThisTypeExeption;
import station.stateStation.Empty;
import station.stateStation.StateStation;
import station.vehicleTypeChooser.TypeVehicleTest;
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
    private final List<ControlCenter> subsribers;

    /**
     * Constructor Station
     */
    public Station() {
        this.id = createId();
        this.capacityMax = randomCapacityMax();
        this.vehicles = new ArrayList<>(this.capacityMax);
        this.stateStation = new Empty();
        this.subsribers = new ArrayList<>();
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
    protected int randomCapacityMax() {
        return 0;
    }

    /**
     * Add a vehicle to the station
     * @param vehicle - The vehicle to be added
     */
    public void DropOffVehicle(Vehicle vehicle) {

    }

    /**
     * take a vehicle from the station if possible
     *  @throws NoVehicleOfThisTypeExeption - if there is no vehicle of this type
     */
    public Vehicle rentVehicle(TypeVehicleTest t) throws NoVehicleOfThisTypeExeption {
        for(Vehicle vehicle : this.getVehicles()){
            if(t.testTypeVehicle(vehicle) && vehicle.isRentable()){
                this.getVehicles().remove(vehicle);
                return vehicle;
            }
        }
        throw new NoVehicleOfThisTypeExeption("No vehicle of this type in the station");
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
    private void toEmpty() {
    }

    /**
     * Changes station state to 1 vehicle remaining
     */
    private void toOneVehicleLeft() {

    }

    /**
     * Changes station state to Normal
     */
    private void toNormal() {
    }

    /**
     * Changes station vehicle to full
     */
    private void toFull() {
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



    public List<Vehicle> getVehicles() {
        return vehicles;
    }


    /**
     * Add a subscriber to the station
     * @param controlCenter a subscriber
     */
    public void addSubscriber(ControlCenter controlCenter) {
    }

    /**
     * Remove a subscriber from the station
     * @param controlCenter a subscriber
     */
    public void removeSubscriber(ControlCenter controlCenter) {

    }
    public Vehicle getVehicle(){
        return this.vehicles.getFirst();
    }
}
