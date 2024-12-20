package station;

import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import exeption.StationFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehicle.Bike;
import vehicle.Overboard;
import vehicle.Scooter;
import vehicle.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {


    private MockStationTestRandom station;
    private Vehicle bike;
    private Vehicle scooter;
    private Vehicle overBoard;

    @BeforeEach
    void setUp() {
        this.station = new MockStationTestRandom();
        this.overBoard = new Overboard(0);
        this.bike = new Bike(0);
        this.scooter = new Scooter(0);
    }

    @Test
    void canDropVehiclesStationNotFull() throws StationFullException {
        assertEquals(this.station.getVehicles().size(),0);
        assertTrue(this.station.canBeDropOff());
        this.station.dropOffVehicle(this.bike);
        assertEquals(this.station.getVehicles().size(),1);
        assertTrue(this.station.canBeDropOff());
    }

    @Test
    void canDropVehiclesStationIsFull() throws StationFullException {
        this.station.dropOffVehicle(this.scooter);
        this.station.dropOffVehicle(this.overBoard);

        assertEquals(this.station.getVehicles().size(),2);
        assertFalse(this.station.canBeDropOff());
        assertThrows(StationFullException.class,()-> this.station.dropOffVehicle(this.bike));
    }


    @Test
    void takeVehicleStationNotEmpty() throws NoVehicleOfThisTypeAvailableException, StationEmptyException, StationFullException {
        this.station.dropOffVehicle(this.scooter);
        this.station.dropOffVehicle(this.bike);
        int size_prec = this.station.getVehicles().size();

        assertFalse(this.station.getVehicles().isEmpty());
        assertTrue(this.station.canBeRent());
        // test take a bike
        Vehicle test1 = station.rentVehicle(v -> v instanceof Bike);

        assertEquals(size_prec-this.station.getVehicles().size(),1);
        assertInstanceOf(Bike.class,test1);

        int size_prec2 = this.station.getVehicles().size();
        assertFalse(this.station.getVehicles().isEmpty());
        assertTrue(this.station.canBeRent());
        //test take a Scooter
        Vehicle test2 = station.rentVehicle(v -> v instanceof Scooter);


        assertEquals(size_prec2-this.station.getVehicles().size(),1);
        assertInstanceOf(Scooter.class,test2);
    }

    @Test
    void takeVehicleStationNotEmptyButTheVehicleIsNotRentable() throws StationFullException {
        this.station.dropOffVehicle(this.scooter);
        this.station.dropOffVehicle(this.bike);
        //bike is not rentable
        this.bike.toHS();
        assertFalse(this.station.getVehicles().isEmpty());
        assertTrue(this.station.canBeRent());
        assertThrows(NoVehicleOfThisTypeAvailableException.class,()->station.rentVehicle(v -> v instanceof Bike));

    }


    @Test
    void takeVehicleStationNotEmptyKO() throws StationFullException {
        //case when there is no vehicle of the type wanted in the station
        this.station.dropOffVehicle(this.scooter);
        this.station.dropOffVehicle(this.bike);
        assertFalse(this.station.getVehicles().isEmpty());
        assertTrue(this.station.canBeRent());
        assertThrows(NoVehicleOfThisTypeAvailableException.class,()->station.rentVehicle(v -> v instanceof Overboard));
    }

    @Test
    void takeVehicleStationIsEmpty(){
        int size_prec = this.station.getVehicles().size();
        assertTrue(this.station.getVehicles().isEmpty());
        assertFalse(this.station.canBeRent());

        assertThrows(StationEmptyException.class,()-> this.station.rentVehicle(v -> v instanceof Bike));
        assertEquals(size_prec,this.station.getVehicles().size());
    }


}