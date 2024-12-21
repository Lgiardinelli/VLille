package controlCenter;

import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import exeption.StationFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import station.MockStationTestNotif;
import station.MockStationVehcNbTimeRent;
import station.Station;
import station.stateStation.Empty;
import station.stateStation.Full;
import vehicle.Bike;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ControlCenterTest {

    private Station station;
    private ControlCenter controlCenter;
    private Bike bike;

    @BeforeEach
    void setUp() {
        List<Station> t = new ArrayList<>();
        this.station = new MockStationTestNotif();
        t.add(station);
        this.controlCenter = new ControlCenter(t);
        this.station.addSubscriber(controlCenter);
        this.bike = new Bike(0);
    }

    @Test
    void notifyStationVehicleAddedTest() throws Exception {
        Station test = new Station();
        test.addSubscriber(controlCenter);

        //if the station is already in the map
        assertEquals(0, controlCenter.getNbVehicleStation(station));
        station.dropOffVehicle(bike);
        assertEquals(1, controlCenter.getNbVehicleStation(station));

        //if the station not in the map
        assertFalse(controlCenter.getStations().containsKey(test));
        test.dropOffVehicle(bike);
        assertTrue(controlCenter.getStations().containsKey(test));
        assertEquals(1, controlCenter.getNbVehicleStation(test));

    }

    @Test
    void notifyStationVehicleTakedTestOk() throws Exception {
        Station test = new MockStationTestNotif();
        test.addSubscriber(controlCenter);
        station.dropOffVehicle(bike);
        test.getVehicles().add(bike);

        //if the station is already in the map
        int nb_v = this.controlCenter.getNbVehicleStation(station);
        assertEquals(0, nb_v - this.station.getVehicles().size());
        station.rentVehicle(t -> t instanceof Vehicle);
        assertEquals(nb_v - 1, controlCenter.getNbVehicleStation(station));

        //if the station not in the map
        int nb_vehicle_station = test.getVehicles().size();
        assertFalse(controlCenter.getStations().containsKey(test));
        test.rentVehicle(t -> t instanceof Vehicle);
        assertTrue(controlCenter.getStations().containsKey(test));
        assertEquals(controlCenter.getNbVehicleStation(test), nb_vehicle_station - 1);
    }

    //TODO faire test KO pour les deux précédent test


    @Test
    void testNotifyWhenStationIsFullEmpty() throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException {
        //already in list of redistribute vehicle because she was empty when added at the contstruction
        assertInstanceOf(Empty.class, this.station.getStateStation());
        assertTrue(this.controlCenter.getStationToRedistribute().contains(this.station));
        this.station.dropOffVehicle(this.bike);

        //because a vehicle has been added so she don't need to be redistributed anymore
        assertFalse(this.controlCenter.getStationToRedistribute().contains(this.station));

        //station is full so she come back in the list
        this.station.dropOffVehicle(this.bike);
        assertTrue(this.controlCenter.getStationToRedistribute().contains(this.station));
        assertInstanceOf(Full.class, this.station.getStateStation());

        //if we rent all the vehicles the station is in the list
        this.station.rentVehicle(v -> v instanceof Vehicle);
        this.station.rentVehicle(v -> v instanceof Vehicle);
        assertInstanceOf(Empty.class, this.station.getStateStation());
        assertTrue(this.controlCenter.getStationToRedistribute().contains(this.station));
    }
}