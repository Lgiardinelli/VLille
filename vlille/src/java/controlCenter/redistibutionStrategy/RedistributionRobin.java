package controlCenter.redistibutionStrategy;

import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import exeption.StationFullException;
import station.Station;
import vehicle.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * RedistributionRobin class
 */
public class RedistributionRobin implements RedistributionStrategy{

    @Override
    public void reallocation(Set<Station> stations, Station station) throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException {
        if (!station.canBeDropOff())
            reallocationRobin(stations, station, true);
        else if (!station.canBeRent())
            reallocationRobin(stations, station, false);
    }

    private void reallocationRobin(Set<Station> stations, Station station, boolean isFull) throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException {
        int nbReallocation = station.getCapacityMax()/2;
        if (isFull) {
            for (int i=0; i<nbReallocation; i++) {
                List<Station> filterStation = stations.stream().filter(s -> s.canBeDropOff()).collect(Collectors.toList());
                if (!filterStation.isEmpty()) {
                    Vehicle vehicle = station.rentVehicle(v -> v instanceof Vehicle);
                    Station s = takeEmptiestStation(filterStation);
                    s.dropOffVehicle(vehicle);
                }
            }
        }
        else {
            for (int i=0; i<nbReallocation;i++) {
                List<Station> filterStation = stations.stream().filter(s -> (s.canBeRent())).collect(Collectors.toList());
                if (!filterStation.isEmpty()) {
                    Station s = takeFullestStation(filterStation);
                    Vehicle vehicle = s.rentVehicle(v -> v instanceof Vehicle);
                    station.dropOffVehicle(vehicle);
                }
            }
        }
    }

    private Station takeFullestStation(List<Station> stations) {
        Optional<Station> stationFullest = stations.stream().max(Comparator.comparingInt(s -> s.getVehicles().size()));
        return stationFullest.orElse(null);
    }

    private Station takeEmptiestStation(List<Station> stations) {
        Optional<Station> stationFullest = stations.stream().min(Comparator.comparingInt(s -> s.getVehicles().size()));
        return stationFullest.orElse(null);
    }
}
