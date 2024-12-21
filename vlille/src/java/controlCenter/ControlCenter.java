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
    private List<Vehicle> vehicles;
    private RedistributionStrategy strategy;
    private List<Station> stationToRedistribute;

    /**
     * ControlCenter's constructor
     */
    public ControlCenter() {
        this.stations = new HashMap<>();
        this.vehicles = new ArrayList<>();
        this.strategy = new RedistributionRobin();
        this.stationToRedistribute = new ArrayList<>();
    }

    /**
     * ControlCenter's constructor with a non-empty list en predefine station
     */
    public ControlCenter(List<Station> s) {
        this.stations = new HashMap<>();
        this.vehicles = new ArrayList<>();
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

    /**
     * Add station in list controlCenter
     *
     * @param station - The station to add
     */
    public void addStationToListControlCenter(Station station) {
        // Ne pas oublier d'abonner la station au control center en vérifiant que la station n'est pas dans la map
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
            this.stations.put(s, 1);
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