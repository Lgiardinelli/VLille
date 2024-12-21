package vehicle.vehicleVisitor;

import controlCenter.ControlCenter;
import timeControler.Time;
import vehicle.Vehicle;
import vehicle.stateVehicle.HS;
import vehicle.stateVehicle.Service;

/**
 * class Repair
 */
public class Repair implements VehicleVisitor {

    private Time time = new Time();
    private ControlCenter controlCenter;
    private Vehicle vehicle = null;

    /**
     * constructor
     */
    public Repair(ControlCenter controlCenter) {
        this.controlCenter = controlCenter;
    }

    public Time getTime() {
        return time;
    }

    /** method that visit a vehicle
     * @param vehicle the vehicle to visit
     * @throws Exception - If the repair is working
     */
    @Override
    public void visit(Vehicle vehicle) throws Exception {
        // vehicle.accept(this);
        if (canWork()) {
            this.controlCenter.removeVehicleList(vehicle);
            time.resetCount();
            this.vehicle = vehicle;
        }
        else
            throw new Exception("Can't repair this bike, because is already working on a vehicle !");
    }

    /** method that check if the vehicle is in the HS state
     * @param vehicle the vehicle to check
     * @return true if the vehicle is in the HS state, false otherwise
     */
    @Override
    public boolean filterCondition(Vehicle vehicle) {
        return vehicle.getState().getClass() == HS.class;
    }

    /** method that check if the repair can work
     * @return true if the repair can work, false otherwise
     */
    private boolean canWork() {
        return this.vehicle == null;
    }

    /**
     * Timer control
     */
    @Override
    public void timerControl() {
        if (!canWork()) {
            time.addOneInterValeNoModif();
            if (time.intervalNoModifSupEqHas(2)) {
                repairVehicle();
            }
        }
    }

    /**
     * method that repair a vehicle who is the HS State
     */
    private void repairVehicle() {
        controlCenter.addVehicleList(this.vehicle);
        vehicle.setState(new Service(this.vehicle));
        this.vehicle = null;
        time.resetCount();
    }

}
