package station.stationVisitor;

import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import station.Station;

public abstract class GetVehicleVisitor implements StationVisitor{

    @Override
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
