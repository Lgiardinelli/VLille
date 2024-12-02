package controlCenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import station.Station;

import static org.junit.jupiter.api.Assertions.*;

class ControlCenterTest {

    Station station;
    ControlCenter controlCenter;

    @BeforeEach
    void setUp() {
        controlCenter = new ControlCenter();
        station = new Station();
    }

    @Test
    void notifyStationVehicleAddedTest() {
        assertTrue(controlCenter.getStations().isEmpty());
        station.addSubscriber(controlCenter);
        controlCenter.addStationToListControlCenter(station);
        controlCenter.notifyStationVehicleAdded(station);
        assertFalse(controlCenter.getStations().isEmpty());
        assertEquals(0, controlCenter.getNbVehicleStation(station));

    }

    @Test
    void notifyStationVehicleTakedTest() {
        station.addSubscriber(controlCenter);
        controlCenter.addStationToListControlCenter(station);
        controlCenter.notifyStationVehicleAdded(station);

    }
}