package controlCenter;

import controlCenter.redistibutionStrategy.RedistributionRobin;
import controlCenter.redistibutionStrategy.RedistributionStrategy;
import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import exeption.StationFullException;
import station.Station;
import station.stationVisitor.StationVisitor;
import vehicle.Vehicle;
import vehicle.vehicleVisitor.VehicleVisitor;

import java.util.*;

/**
 * Control center classControl center class
 */
public class ControlCenter implements SubscribeControlCenter {

    private Map<Station, Integer> stations;
    private Set<Vehicle> vehicles;
    private RedistributionStrategy strategy;
    private List<Station> stationToRedistribute;

    /**
     * ControlCenter's constructor
     */
    public ControlCenter() {
        this.stations = new HashMap<>();
        this.vehicles = new HashSet<>();
        this.strategy = new RedistributionRobin();
        this.stationToRedistribute = new ArrayList<>();
    }

    /**
     * ControlCenter's constructor with a non-empty list en predefine station
     */
    public ControlCenter(List<Station> s) {
        this.stations = new HashMap<>();
        this.vehicles = new HashSet<>();
        this.strategy = new RedistributionRobin();
        this.stationToRedistribute = new ArrayList<>();
        if (!s.isEmpty()) {
            s.forEach(t -> this.stations.put(t, 0));
            s.forEach(t -> {
                if (!t.canBeRent() && t.canBeDropOff() || t.canBeRent() && !t.canBeDropOff()) {
                    this.stationToRedistribute.add(t);
                }
            });
        }
    }

    public ControlCenter(Set<Vehicle> v) {
        this.stations = new HashMap<>();
        this.vehicles = new HashSet<>();
        this.strategy = new RedistributionRobin();
        this.stationToRedistribute = new ArrayList<>();
        this.stations = new HashMap<>();
        if (!v.isEmpty())
            this.vehicles.addAll(v);
    }

    public void addVehicleList(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicleList(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public Set<Vehicle> getVehicles() {
        return this.vehicles;
    }

    /**
     * Change strategy
     *
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
     *
     * @param station - the station
     * @return nb vehicle in this station
     */
    public int getNbVehicleStation(Station station) {
        return stations.get(station);
    }

    /**
     * Get map stations
     *
     * @return the map of all stations
     */
    public Map<Station, Integer> getStations() {
        return this.stations;
    }

    @Override
    public void notifyStationEmpty(Station s) {
        this.stationToRedistribute.add(s);
    }

    @Override
    public void notifyStationFull(Station s) {
        this.stationToRedistribute.add(s);
    }

    @Override
    public void notifyStationVehicleAdded(Station s) {
        if (this.stations.containsKey(s)) {
            this.stations.put(s, this.stations.get(s) + 1);
        } else {
            this.stations.put(s, s.getVehicles().size());
        }
        this.refreshListRedistribute(s);
    }

    @Override
    public void notifyStationVehicleTaked(Station s) {
        if (this.stations.containsKey(s)) {
            this.stations.put(s, this.stations.get(s) - 1);
        } else {
            this.stations.put(s, s.getVehicles().size());
        }
        this.refreshListRedistribute(s);
    }

    /**
     * method that remove the station in list station to redistribute because she can't be redistribute anymore
     *
     * @param s
     */
    private void refreshListRedistribute(Station s) {
        this.stationToRedistribute.remove(s);
    }

    /**
     * return the list of the vehicle who potentialy need to be redistributed
     * @return
     */
    public List<Station> getStationToRedistribute() {
        return stationToRedistribute;
    }

    /**
     * Executes a vehicle-related event defined by the provided visitor.
     * @param vehicleVisitor the visitor defining the vehicle event
     */
    public void executeEventVehicle(VehicleVisitor vehicleVisitor) {
        try {
            Vehicle vehicle = vehicleFilterCondition(vehicleVisitor);
            vehicleVisitor.visit(vehicle);
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Filters the first vehicle that matches the visitor's condition.
     * @param vehicleVisitor the visitor with the filter condition
     * @return a vehicle matching the condition
     * @throws NullPointerException if no vehicle matches the condition
     */
    private Vehicle vehicleFilterCondition(VehicleVisitor vehicleVisitor) throws NullPointerException {
        Iterator<Vehicle> vehicleIterator = this.vehicles.iterator();
        while (vehicleIterator.hasNext()) {
            Vehicle vehicle = vehicleIterator.next();
            if (vehicleVisitor.filterCondition(vehicle)) {
                return vehicle;
            };
        }
        throw new NullPointerException();
    }


    /**
     * method which exexute an event of type Station visitor
     * @param v a visitor of station
     */
    public void executeEventStation(StationVisitor v){
        try{
            Station station = this.getStationCorrepondingFilter(v);
            v.visit(station);
        }
        catch (NullPointerException e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * extract the first station which correspond to StationVisitor predicate
     * @param visitor the station visitor
     * @return  a station corresponding to the predicate
     * @throws NullPointerException if there is no station corresponding
     */
    private Station getStationCorrepondingFilter(StationVisitor visitor) throws NullPointerException{
        Iterator<Station> t = this.getStations().keySet().iterator();

        while(t.hasNext()){
            Station station = t.next();
            if(visitor.predicatTestFilter(station)){
                return station;
            }
        }
        throw new NullPointerException("aucune station ne corréspond au filtre");
    }
}