package vehicle.vehicleVisitor;

import vehicle.Bike;
import vehicle.Overboard;
import vehicle.Scooter;
import vehicle.Vehicle;

import java.util.List;

/**
 * interface VehicleVisitor
 */
public interface VehicleVisitor {
    /**
     * method that visit a vehicle and do something on it
     * @param vehicle a vehicle to visit
     */
    public void visit(Vehicle vehicle) throws Exception;

    /**
     * method that visit a Bike and do something on it
     * @param b a bike
     * @throws Exception
     */
    void visit(Bike b) throws Exception;

    /**
     * method that visit a Scooter and do something on it
     * @param b a bike
     * @throws Exception
     */
    void visit(Scooter b) throws Exception;

    /**
     * method that visit a OverBoard and do something on it
     * @param b a bike
     * @throws Exception
     */
    void visit(Overboard b) throws Exception;

    /**
     * method that visit a vehicle and do something on it
     * @param vehicle a vehicle to visit
     * @return boolean that represent if the vehicle is accepted or not
     */
    public boolean filterCondition(Vehicle vehicle);

    /**
     * method affichage
     * @return String that represent the object
     */
    public String toString();

}
