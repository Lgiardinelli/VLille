package vehicle.vehicleVisitor;

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

    public void timerControl();
}
