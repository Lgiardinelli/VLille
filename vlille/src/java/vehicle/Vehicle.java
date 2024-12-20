package vehicle;

import station.Station;
import vehicle.stateVehicle.Service;
import vehicle.stateVehicle.StateVehicle;
import vehicle.vehicleVisitor.VehicleVisitor;

/**
 * class that handles the different types of vehicle
 */
public abstract class Vehicle {

    private static final int nbMaxTimeRented = 5;
    private int id;
    private Station station;
    private int nbTimeRented;
    private StateVehicle state;

    public Vehicle(int id){
        this.id = id;
        this.nbTimeRented = 0;
        this.state = new Service(this);
    }

    /**
     * method that uses the StateVehicle interface to determine if the vehicle is rentable
     * @return a boolean for the response
     */
    public boolean isRentable(){
        return false;
    }

    /**
     * getter for the station attribute
     * @return a station
     */
    public Station getStation() {
        return station;
    }

    /**
     * a setter for the station attribute
     * @param station a station
     */
    public void setStation(Station station) {
        this.station = station;
    }


    /**
     * getter for the NbTimeRented attribute
     * @return an int
     */
    public int getNbTimeRented() {
        return nbTimeRented;
    }


    /**
     * a setter for the nbTimeRented attribute
     */
    public void addOneNbTimeRented() {
        this.nbTimeRented += 1;
        this.updateState();
    }

    /**
     * method that allows to decorate our vehicle with different equipment
     */
    public abstract String decorateEquipment();

    /**
     * method that accept the visitor and give the station a parameter
     * @param visitor a visitor on objet vehicle
     */
    public void accept(VehicleVisitor visitor){
        visitor.visit(this);
    }

    /**
     * method that changes the current state to the Service state if its possible
     */
    public void toService(){
        this.state.toService();
    }

    /**
     * method that changes the current state to the HS state if its possible
     */
    public void toHS(){
        this.state.toHS();
    }

    /**
     * method that changes the current state to the Robbed state if its possible
     */
    public void toRobed(){
        this.state.toRobed();
    }


    /**
     * setter for the state of the  vehicle
     * @param state a state
     */
    public void setState(StateVehicle state) {
        this.state = state;
    }

    /**
     * test if the vehicle need to be repaired if it's the case if change the state of the vehicle
     */
    private void updateState(){
        if(nbTimeRented == nbMaxTimeRented){
            this.toHS();
        }

    }

}
