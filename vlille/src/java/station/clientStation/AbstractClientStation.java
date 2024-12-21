package station.clientStation;

import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import station.Station;

public abstract class AbstractClientStation {

    /**
     * visit a station a take a vehicle of the type wanted
     * @param station the station selected to take a vehicle
     */
    public void visit(Station station) {
        try {
            station.rentVehicle(this.testMethod());
        } catch (NoVehicleOfThisTypeAvailableException e) {
            System.out.println(e);
        } catch (StationEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * methat which return a TypeVehicleTest
     * @return an object of type TypeVehicleTest which is an anonyme interface
     */
    protected abstract TypeVehicleTest testMethod();
}
