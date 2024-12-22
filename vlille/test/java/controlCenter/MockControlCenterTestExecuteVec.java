package controlCenter;

import vehicle.Vehicle;
import vehicle.vehicleVisitor.VehicleVisitor;

public class MockControlCenterTestExecuteVec extends ControlCenter{


    public static int call_Null_point = 0;
    public static int call_Exep_point = 0;
    @Override
    public void executeEventVehicle(VehicleVisitor vehicleVisitor) {
        try {
            Vehicle vehicle = super.vehicleFilterCondition(vehicleVisitor);
            vehicleVisitor.visit(vehicle);
        } catch (NullPointerException e) {
            call_Null_point++;
        } catch (Exception e) {
            call_Exep_point++;
        }
    }
}
