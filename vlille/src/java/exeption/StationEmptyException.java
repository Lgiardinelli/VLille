package exeption;

public class StationEmptyException extends Exception{
    public StationEmptyException(String stationIsEmpty) {
        super(stationIsEmpty);
    }
}
