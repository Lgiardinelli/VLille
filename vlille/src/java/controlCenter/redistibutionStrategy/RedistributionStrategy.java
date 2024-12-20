package controlCenter.redistibutionStrategy;

import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import exeption.StationFullException;
import station.Station;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * interface that manages the different ways of redistributing vehicles to the stations
 */
public interface RedistributionStrategy {

    /**
     * method that performs a type of redistribution
     */
    void reallocation(Set<Station> stations, Station station) throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException;
}
