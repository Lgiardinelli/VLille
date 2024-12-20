package controlCenter;

import controlCenter.redistibutionStrategy.RedistributionRobin;
import controlCenter.redistibutionStrategy.RedistributionStrategy;
import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import exeption.StationFullException;
import station.Station;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Control center classControl center class
 */
public class ControlCenter implements SubscribeControlCenter {

    private Map<Station, Integer> stations;
    private List<Vehicle> vehicles;
    private RedistributionStrategy strategy;

    /**
     * ControlCenter's constructor
     */
    public ControlCenter() {
        this.stations = new HashMap<>();
        this.vehicles = new ArrayList<>();
        this.strategy = new RedistributionRobin();
    }

    /**
     * ControlCenter's constructor with a non-empty list en predefine station
     */
    public ControlCenter(List<Station> s){
        this.stations = new HashMap<>();
        this.vehicles = new ArrayList<>();
        this.strategy = new RedistributionRobin();
        if(!s.isEmpty()) {
            s.forEach(t -> this.stations.put(t, 0));
        }
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
    public void executeStrategy(Station station) throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException {
        this.strategy.reallocation(stations.keySet(), station);
    }

    /**
     * Get number of vehicle to parameter station
     * @param station - the station
     * @return nb vehicle in this station
     */
    public int getNbVehicleStation(Station station) {
        return stations.get(station);
    }

    /**
     * Get map stations
     * @return the map of all stations
     */
    public Map<Station, Integer> getStations() {
        return this.stations;
    }

    /**
     * Add station in list controlCenter
     * @param station - The station to add
     */
    public void addStationToListControlCenter(Station station) {
        // Ne pas oublier d'abonner la station au control center en vérifiant que la station n'est pas dans la map
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

    public void addStationInitToTheMap(Station s){
        this.stations.putIfAbsent(s,0);
    }


}
