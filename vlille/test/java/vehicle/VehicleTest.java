package vehicle;

import org.junit.jupiter.api.BeforeEach;
import station.Station;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    Station<Bike> station;
    Bike bike;

    @BeforeEach
    void setUp() {
         station = new Station();
         bike = new Bike();
         station.addVehicle(bike);
    }










}