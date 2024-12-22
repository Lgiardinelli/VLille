package station.clientStation;

import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import station.Station;
import vehicle.Vehicle;

public abstract class AbstractClientStation {

    /**
     * visit a station a take a vehicle of the type wanted
     * @param station the station selected to take a vehicle
     */
    public Vehicle visit(Station station) {
        try {
            return station.rentVehicle(this.testMethod());
        } catch (NoVehicleOfThisTypeAvailableException e) {
            System.out.println(e);
        } catch (StationEmptyException e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * methat which return a TypeVehicleTest
     * @return an object of type TypeVehicleTest which is an anonyme interface
     */
    protected abstract TypeVehicleTest testMethod();
}
