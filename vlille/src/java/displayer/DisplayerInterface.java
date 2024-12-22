package displayer;

import controlCenter.ControlCenter;
import station.Station;
import station.stationVisitor.StationVisitor;
import vehicle.Vehicle;
import vehicle.vehicleVisitor.VehicleVisitor;

/**
 * Interface displayer
 */
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
    void displayVehicleVisitor(VehicleVisitor v);

    /**
     * display in a certain way what is the status of the StationVisitor
     * @param v a StationVisitor
     */
    void displayStationVisitor(StationVisitor v);

    /**
     * Method displayDropOffVehicleInformaion
     * @param station - the station to information
     * @param vehicle - the vehicle information
     */
    void displayDropOffVehicleInformaion(Station station, Vehicle vehicle);

    /**
     * Mathod displayRentVehicleInformaion
     * @param station - the station information
     * @param vehicle - the vehicle information
     */
    void displayRentVehicleInformaion(Station station, Vehicle vehicle);

}
