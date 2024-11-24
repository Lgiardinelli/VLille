package station;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehicle.Bike;
import vehicle.Overboard;
import vehicle.Scooter;
import vehicle.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {


    private MockStation station;
    private Vehicle bike;
    private Vehicle scooter;
    private Vehicle overBoard;

    @BeforeEach
    void setUp() {
        this.station = new MockStation();
        this.overBoard = new Overboard();
        this.bike = new Bike();
        this.scooter = new Scooter();
    }

    @Test
    void canDropVehiclesStationNotFull(){
        assertEquals(this.station.getVehicles().size(),0);
        assertTrue(this.station.canBeDropOff());
        this.station.DropOffVehicle(this.bike);
        assertEquals(this.station.getVehicles().size(),1);
        assertTrue(this.station.canBeDropOff());
    }

    @Test
    void canDropVehiclesStationIsFull(){
        this.station.getVehicles().add(this.scooter);
        this.station.getVehicles().add(this.overBoard);

        assertEquals(this.station.getVehicles().size(),2);
        assertFalse(this.station.canBeDropOff());
        assertThrows(Exception.class,()-> this.station.DropOffVehicle(this.bike));
    }


    @Test
    void takeVehicleStationNotEmpty(){
        this.station.getVehicles().add(this.scooter);
        int size_prec = this.station.getVehicles().size();

        assertFalse(this.station.getVehicles().isEmpty());
        assertTrue(this.station.canBeRent());
        Vehicle test = station.getVehicle();
        assertEquals(size_prec-this.station.getVehicles().size(),1);



    }

    @Test
    void takeVehicleStationIsEmpty(){
        int size_prec = this.station.getVehicles().size();
        assertTrue(this.station.getVehicles().isEmpty());
        assertFalse(this.station.canBeRent());
        Vehicle test = station.getVehicle();
        assertThrows(Exception.class,()-> this.station.getVehicle());
    }


}