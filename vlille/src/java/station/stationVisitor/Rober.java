package station.stationVisitor;

import station.Station;
import vehicle.Vehicle;

/**
 * Visor Thief Class
 */
public class Rober implements StationVisitor {


     private static final int NB_VEHICLE_NEEDED_TO_ROBE = 1;
    /**
     * Rober's constructor
     */
    public Rober() {

    }

    /**
     * method which allows you to visit the station
     * @param station - Station<Vehicle> The station visited
     */
    @Override
    public void visit(Station station) throws Exception {
        robStation(station);
    }

    /**
     * Steal the vehicle from the station
     * @param station - The stolen station
     */
    private void robStation(Station station) throws Exception {
        if(this.canBeRobe(station)){
            Vehicle vec = station.getVehicle();
            station.getVehicles().remove(vec);
            station.getSubsribers().forEach(t -> {
                t.notifyStationEmpty(station);
                t.notifyStationVehicleTaked(station);
            });
            vec.toRobed();
        }
        else{
            throw new Exception("This vehicle is not stealable cause he is HS");
        }
    }

    /**
     * verify if the vehicle is not HS
     * @param s a station
     * @return a boolean
     */
    private boolean canBeRobe(Station s){
        return  s.getVehicle().isRentable();
    }

    @Override
    public boolean predicatTestFilter(Station s) {
        return s.getVehicles().size() == NB_VEHICLE_NEEDED_TO_ROBE && s.getTime().intervalNoModifSupEqHas(2);
    }
}
