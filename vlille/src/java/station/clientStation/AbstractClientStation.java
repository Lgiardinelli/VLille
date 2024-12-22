package station.clientStation;

import displayer.ConsoleDisplayer;
import displayer.DisplayerInterface;
import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import station.Station;
import vehicle.Vehicle;

public abstract class AbstractClientStation {


    private final DisplayerInterface diplayer = new ConsoleDisplayer();
    /**
     * visit a station a take a vehicle of the type wanted
     * @param station the station selected to take a vehicle
     */
    public Vehicle visit(Station station) {
        try {
            return station.rentVehicle(this.testMethod());
        } catch (NoVehicleOfThisTypeAvailableException | StationEmptyException e) {
            diplayer.displayExeption(e.getMessage());
        }
        return null;
    }

    /**
     * methat which return a TypeVehicleTest
     * @return an object of type TypeVehicleTest which is an anonyme interface
     */
    protected abstract TypeVehicleTest testMethod();
}
