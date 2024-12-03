package controlCenter;

import exeption.NoVehicleOfThisTypeAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import station.MockStation;
import station.Station;
import vehicle.Bike;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ControlCenterTest {

    Station station;
    ControlCenter controlCenter;
    Bike bike;

    @BeforeEach
    void setUp() {
        station = new MockStation(controlCenter);
        List<Station> t = new ArrayList<>();
        t.add(station);
        controlCenter = new ControlCenter(t);
        bike = new Bike();
    }

    @Test
    void notifyStationVehicleAddedTest() {
        Station test = new Station();
        test.addSubscriber(controlCenter);

        //if the station is already in the map
        assertEquals(0,controlCenter.getNbVehicleStation(station));
        station.DropOffVehicle(bike);
        assertEquals(1, controlCenter.getNbVehicleStation(station));

        //if the station not in the map
        assertFalse(controlCenter.getStations().containsKey(test));
        test.DropOffVehicle(bike);
        assertTrue(controlCenter.getStations().containsKey(test));
        assertEquals(1, controlCenter.getNbVehicleStation(test));

    }

    @Test
    void notifyStationVehicleTakedTestOk() throws NoVehicleOfThisTypeAvailableException {
        Station test = new Station();
        test.addSubscriber(controlCenter);
        station.DropOffVehicle(bike);
        test.getVehicles().add(bike);

        //if the station is already in the map
        int nb_v = this.controlCenter.getNbVehicleStation(station);
        assertEquals(0,nb_v-this.station.getVehicles().size());
        station.rentVehicle(t -> t instanceof Vehicle);
        assertEquals(nb_v-1, controlCenter.getNbVehicleStation(station));

        //if the station not in the map
        int nb_vehicle_station = test.getVehicles().size();
        assertFalse(controlCenter.getStations().containsKey(test));
        test.rentVehicle(t -> t instanceof Vehicle);
        assertTrue(controlCenter.getStations().containsKey(test));
        assertEquals(controlCenter.getNbVehicleStation(test)-1,nb_vehicle_station-1);
    }

    //TODO faire test KO pour les deux précédent test
}