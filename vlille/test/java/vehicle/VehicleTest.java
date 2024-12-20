package vehicle;

import exeption.NoVehicleOfThisTypeAvailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import station.MockStationTestNotif;
import station.Station;
import vehicle.equipment.MockEquip;

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
            station.DropOffVehicle(vehicle);
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
    void decorateEquipmentTestWith() {
        //test case when the first decorator is wrapped
        assertFalse(this.vehicle.decorateEquipment().contains("with"));

        //decorate de equip
        Vehicle t = new MockEquip(this.vehicle);

        assertTrue(t.decorateEquipment().contains("with"));
    }

    @Test
    void decorateEquipmentTestAnd() {
        //test case when the vehicle is already decorate, the String can't have more than than 1 with so after is only and
        Vehicle t = new MockEquip(this.vehicle);
        assertTrue(t.decorateEquipment().contains("with"));

        //decorate de equip
        Vehicle u = new MockEquip(t);
        assertTrue(u.decorateEquipment().contains("and"));

        //let's add one more and see if we have 2 and
        Vehicle y = new MockEquip(u);
        assertTrue(y.decorateEquipment().contains("and MockE and MockE"));



    }

    }