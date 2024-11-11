package controlCenter;

import controlCenter.redistibutionStrategy.RedistributionRobin;
import controlCenter.redistibutionStrategy.RedistributionStrategy;
import station.Station;
import vehicle.Vehicle;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

/**
 * Control center classControl center class
 */
public class ControlCenter implements SubscribeControlCenter {

    private List<Station<Vehicle>> stations;
    private List<Vehicle> vehicles;
    private RedistributionStrategy strategy;

    /**
     * ControlCenter's constructor
     */
    public ControlCenter() {
        this.stations = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.strategy = new RedistributionRobin();
    }

    /**
     * Change strategy
     * @param strategy - new Strategy
     */
    public void setStrategy(RedistributionStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Execute the strategy
     */
    public void executeStrategy() {

    }

    @Override
    public void  notifyStationEmpty(Station s) {

    }

    @Override
    public void notifyStationFull(Station s) {

    }

    @Override
    public void notifyStationVehicleAdded(Station s) {

    }

    @Override
    public void notifyStationVehicleTaked(Station s) {

    }
}
