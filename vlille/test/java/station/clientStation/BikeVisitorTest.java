package station.clientStation;

import vehicle.Bike;
import vehicle.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class BikeVisitorTest extends AbstractClientStationTest {

    @Override
    protected AbstractClientStation createAbstractClientStation() {
        return new BikeVisitor();
    }

    @Override
    protected Vehicle createVehicle() {
        return new Bike(0);
    }
}