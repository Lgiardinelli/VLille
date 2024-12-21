package station.clientStation;

import vehicle.Overboard;

/**
 * reprend a client who want a Scooter
 */
public class ScooterVisitor extends AbstractClientStation {

    @Override
    protected TypeVehicleTest testMethod() {
        return v -> v instanceof Overboard;
    }
}
