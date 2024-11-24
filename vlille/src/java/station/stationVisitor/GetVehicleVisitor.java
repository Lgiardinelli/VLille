package station.stationVisitor;

import exeption.NoVehicleOfThisTypeExeption;
import station.Station;

public abstract class GetVehicleVisitor implements StationVisitor{

    @Override
    public void visit(Station station) {
        try {
            station.rentVehicle(this.testMethod());
        } catch (NoVehicleOfThisTypeExeption e) {
            System.out.println(e);
        }
    }

    /**
     * methat which return a TypeVehicleTest
     * @return an object of type TypeVehicleTest which is an anonyme interface
     */
    protected abstract TypeVehicleTest testMethod();
}
