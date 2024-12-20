package controlCenter.redistibutionStrategy;

import controlCenter.ControlCenter;
import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import exeption.StationFullException;
import station.Station;
import vehicle.Bike;
import vehicle.Scooter;
import vehicle.Vehicle;
import vehicle.vehicleCreator.BikeCreator;
import vehicle.vehicleCreator.ScooterCreator;
import vehicle.vehicleCreator.VehicleCreator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * RedistributionRandom class
 */
public class RedistributionRandom implements RedistributionStrategy{

    Random random = new Random();

    @Override
    public void reallocation(Set<Station> stations, Station station) throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException {
        if (!station.canBeDropOff())
            reallocationFullEmpty(stations, station, true);
        else if (!station.canBeRent())
            reallocationFullEmpty(stations, station, false);
    }

    private void reallocationFullEmpty(Set<Station> stations, Station station, boolean isFull) throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException {
        int nbRedistribution = random.nextInt(2,6);
        for (int i=0; i<nbRedistribution; i++)
            reallocationAlea(stations, station, isFull);
    }

    private void reallocationAlea(Set<Station> stations, Station station, boolean isFull) throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException {
        if (isFull){
            List<Station> filterStation = stations.stream().filter(s -> s.canBeDropOff()).collect(Collectors.toList());
            if (!filterStation.isEmpty()) {
                Vehicle vehicle = station.getVehicle();
                Station s = filterStation.get(random.nextInt(filterStation.size()));
                station.dropOffVehicle(vehicle);
            }
        }
        else {
            List<Station> filterStation = stations.stream().filter(s -> (s.canBeRent())).collect(Collectors.toList());
            if (!filterStation.isEmpty()) {
                Station s = filterStation.get(random.nextInt(filterStation.size()));
                Vehicle vehicle = s.rentVehicle(v -> v instanceof Vehicle);
                station.dropOffVehicle(vehicle);
            }
        }
    }

    public static void main(String[] args) throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException {
        List<Station> stations = new ArrayList<>();
        Station s1 = new Station();
        Station s2 = new Station();
        stations.add(s1);
        stations.add(s2);

        VehicleCreator v1 = new BikeCreator();
        VehicleCreator v2 = new ScooterCreator();
        s1.dropOffVehicle(v1.createVehicle());
        s1.dropOffVehicle(v2.createVehicle());
        s1.dropOffVehicle(v2.createVehicle());
        s1.dropOffVehicle(v2.createVehicle());
        s1.dropOffVehicle(v2.createVehicle());
        s1.dropOffVehicle(v2.createVehicle());

        System.out.println(s1.getVehicles());
        System.out.println(s2.getVehicles());

        ControlCenter controlCenter = new ControlCenter(stations);

        controlCenter.setStrategy(new RedistributionRandom());
        controlCenter.executeStrategy(s2);

        System.out.println(s1.getVehicles());
        System.out.println(s2.getVehicles());
    }



}
