package exeption;

public class NoVehicleOfThisTypeAvailableException extends Exception {
    public NoVehicleOfThisTypeAvailableException(String message) {
        super(message);
    }
}
