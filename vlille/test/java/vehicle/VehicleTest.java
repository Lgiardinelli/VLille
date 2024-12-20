package vehicle;

import exeption.NoVehicleOfThisTypeAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import station.MockStationTestNotif;
import station.Station;

import static org.junit.jupiter.api.Assertions.*;

abstract class VehicleTest {

    protected Vehicle vehicle;
    protected Station station;

    protected abstract Vehicle createVehicle();

    @BeforeEach
    void init() {
        this.vehicle = this.createVehicle();
        this.station = new MockStationTestNotif();
    }

    @Test
    void isRentableTestOk() {
        assertTrue(vehicle.isRentable());
    }

    @Test
    void isRentableTestKo1() {
        vehicle.toHS();
        assertFalse(vehicle.isRentable());
    }

    @Test
    void isRentableTestKo2() {
        vehicle.toRobed();
        assertFalse(vehicle.isRentable());
    }

    @Test
    void getStationTest() {
        vehicle.setStation(station);
        assertEquals(vehicle.getStation(), station);
    }

    @Test
    void setStationTest() {
        vehicle.setStation(station);
        assertEquals(vehicle.getStation(), station);
    }

    @Test
    void getNbTimeRentedTest() {
        vehicle.setStation(station);
        assertEquals(0, vehicle.getNbTimeRented());
        try {
            station.rentVehicle(t -> t instanceof Vehicle);
            station.dropOffVehicle(vehicle);
            assertEquals(1, vehicle.getNbTimeRented());
        } catch (NoVehicleOfThisTypeAvailableException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    @Test
    void addOneNbTimeRentedTest() {
        assertEquals(vehicle.getNbTimeRented(), 0);
        vehicle.addOneNbTimeRented();
        assertEquals(vehicle.getNbTimeRented(), 1);
    }

    @Test
    void decorateEquipmentTest() {
        /**
        assertEquals(0, vehicle.applyCalled);
        vehicle.decorateEquipment();
        assertEquals(1, vehicle.applyCalled);
         */
    }

    }