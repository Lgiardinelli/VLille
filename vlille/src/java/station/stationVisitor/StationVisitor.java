package station.stationVisitor;

import station.Station;
import vehicle.Vehicle;

/**
 * Station visitor interface
 */
public interface StationVisitor {
    /**
     * method which allows you to visit the station
     * @param station - Station<Vehicle> la station visité
     */
    void visit(Station station);

}
