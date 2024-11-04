package vehicle;

import station.Station;
import vehicle.stateVehicle.Service;
import vehicle.stateVehicle.StateVehicle;
import vehicle.vehicleVisitor.VehicleVisitor;

/**
 * class that handles the different types of vehicle
 */
public abstract class Vehicle {
    private int id;
    private Station station;
    private int nbTimeRented;
    private StateVehicle state;

    public Vehicle(){
        this.nbTimeRented = 0;
        this.state = new Service();
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
     * @param nbTimeRented an int
     */
    public void setNbTimeRented(int nbTimeRented) {
        this.nbTimeRented = nbTimeRented;
    }

    /**
     * method that allows to decorate our vehicle with different equipment
     */
    public abstract void decorateEquipment();

    /**
     * method that checks whether the object accepts the visitor
     * @param visitor a visitor on objet vehicle
     * @return a boolean for the visitor
     */
    public boolean accept(VehicleVisitor visitor){
        return false;
    }

    /**
     * method that changes the current state to the Service state if its possible
     */
    public void toService(){}

    /**
     * method that changes the current state to the HS state if its possible
     */
    public void toHS(){}

    /**
     * method that changes the current state to the Robbed state if its possible
     */
    public void toRobed(){}


    /**
     * setter for the state of the  vehicle
     * @param state a state
     */
    public void setState(StateVehicle state) {
        this.state = state;
    }


}
