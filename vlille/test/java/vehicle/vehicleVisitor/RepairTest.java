package vehicle.vehicleVisitor;

import controlCenter.ControlCenter;
import exeption.StationFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import station.Station;
import vehicle.Vehicle;
import vehicle.vehicleCreator.BikeCreator;
import vehicle.vehicleCreator.VehicleCreator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RepairTest {

    private Repair repair;
    private ControlCenter controlCenter;
    VehicleCreator vehicleCreator = new BikeCreator();
    Vehicle v1;
    Vehicle v2;
    Vehicle v3;
    List<Station> stations;
    Set<Vehicle> vehicles;
    Station s1;
    Station s2;

    @BeforeEach
    void setUp() throws StationFullException {
        stations = new ArrayList<>();
        vehicles = new HashSet<>();
        s1 = new Station();
        s2 = new Station();
        stations.add(s1);
        stations.add(s2);
        v1 = vehicleCreator.createVehicle();
        v2 = vehicleCreator.createVehicle();
        v3 = vehicleCreator.createVehicle();
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);
        controlCenter = new ControlCenter(vehicles);
        s1.dropOffVehicle(v1);
        s1.dropOffVehicle(v2);
        s1.dropOffVehicle(v3);
        repair = new Repair(controlCenter);
    }

    @Test
    public void testFilterCondition() {
        assertFalse(repair.filterCondition(v1));
        v1.toHS();
        assertTrue(repair.filterCondition(v1));
    }

    @Test
    public void timerControlTest() {
        // TODO
    }

}