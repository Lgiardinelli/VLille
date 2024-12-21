package station.clientStation;

import vehicle.Bike;

/**
 * reprend a client who want a bike
 */
public class BikeVisitor extends AbstractClientStation {

    @Override
    protected TypeVehicleTest testMethod() {
        return v -> v instanceof Bike;
    }

}
