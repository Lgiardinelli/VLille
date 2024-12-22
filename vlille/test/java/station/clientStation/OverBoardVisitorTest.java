package station.clientStation;

import vehicle.Overboard;
import vehicle.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class OverBoardVisitorTest extends AbstractClientStationTest {

    @Override
    protected AbstractClientStation createAbstractClientStation() {
        return new OverBoardVisitor();
    }

    @Override
    protected Vehicle createVehicle() {
        return new Overboard(0);
    }
}