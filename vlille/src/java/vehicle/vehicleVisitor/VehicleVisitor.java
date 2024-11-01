package vehicle.vehicleVisitor;

import vehicle.Vehicle;

/**
 * interface VehicleVisitor
 */
public interface VehicleVisitor {
    /**
     * method that visit a vehicle and do something on it
     * @param vehicle a vehicle to visit
     */
    public void visit(Vehicle vehicle);
}
