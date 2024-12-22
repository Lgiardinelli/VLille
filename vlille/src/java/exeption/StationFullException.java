package exeption;

public class StationFullException extends Exception{
    public StationFullException(String stationIsFull) {
        super(stationIsFull);
    }
}
