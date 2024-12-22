package displayer;

import controlCenter.ControlCenter;
import station.Station;
import station.stationVisitor.StationVisitor;
import vehicle.Vehicle;
import vehicle.vehicleVisitor.VehicleVisitor;

public interface DisplayerInterface {

    /**
     * display in a certain way what is the status of the controlCenter
     * @param c a controlCenter
     */
    void displayControlCenter(ControlCenter c);

    /**
     * display in a certain way what is the status of the Station
     * @param s a Station
     */
    void displayStation(Station s);

    /**
     * display in a certain way what is the status of the Vehicle
     * @param v a Vehicle
     */
    void displayVehicle(Vehicle v);

    /**
     * display in a certain way what is the status of the VehicleVisitor
     * @param v a VehicleVisitor
     */
    void displayVehicleVisitor(VehicleVisitor visitor,Vehicle vehicle);

    /**
     * display in a certain way what is the status of the StationVisitor
     * @param v a StationVisitor
     */
    void displayStationVisitor(StationVisitor visitor,Station station);

    /**
     * display the information when a vehicle is drop to a station
     * @param station a station
     * @param vehicle a vehicle
     */
    void displayDropOffVehicleInformaion(Station station, Vehicle vehicle);

    /**
     * display the information when a vehicle is rent from a station
     * @param station a station
     * @param vehicle a vehicle
     */
    void displayRentVehicleInformaion(Station station, Vehicle vehicle);

    /**
     * display what the program do when there is an exception
     * @param message the message from the thows
     */
    void displayExeption(String message);

    /**
     * display the station who going to be redistributed
     * @param s the station
     */
    void displayRedistributionInit(Station s);

    /**
     * display the station after the redistribution
     * @param s the station
     */
    void displayRedistributionEnd(Station s);
}
