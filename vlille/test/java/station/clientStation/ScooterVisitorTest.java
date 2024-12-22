package station.clientStation;

import vehicle.Scooter;
import vehicle.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class ScooterVisitorTest extends AbstractClientStationTest {

    @Override
    protected AbstractClientStation createAbstractClientStation() {
        return new ScooterVisitor();
    }

    @Override
    protected Vehicle createVehicle() {
        return new Scooter(0);
    }
}