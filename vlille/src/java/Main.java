import controlCenter.ControlCenter;
import station.Station;
import station.stationVisitor.Rober;
import station.stationVisitor.StationVisitor;
import vehicle.Overboard;
import vehicle.Scooter;
import vehicle.Vehicle;
import vehicle.vehicleCreator.BikeCreator;
import vehicle.vehicleCreator.OverboardCreator;
import vehicle.vehicleCreator.ScooterCreator;
import vehicle.vehicleVisitor.Repair;
import vehicle.vehicleVisitor.VehicleVisitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    private static final HashSet<Vehicle> allVec = new HashSet<>();
    private static final BikeCreator bc = new BikeCreator();
    private static final OverboardCreator oc = new OverboardCreator();
    private static final ScooterCreator sc = new ScooterCreator();
    private static final ControlCenter mainControlCenter = new ControlCenter(allVec);
    private static final StationVisitor rober = new Rober();
    private static final List<VehicleVisitor> workerVec = new ArrayList<>();
    private static final List<Vehicle> rentedVec = new ArrayList<>();

    private static void roundDropOff(){
        if(!rentedVec.isEmpty()){

        }
    }

    private static void roundRent(){

    }

    private static void roundUpdate(){

    }



    public static void main(String[] arg){



        //creation of 90 vehicle
        for(int i=0; i<30;i++){
            allVec.add(bc.createVehicle());
        }
        for(int i=0; i<30;i++){
            allVec.add(oc.createVehicle());
        }
        for(int i=0; i<30;i++){
            allVec.add(sc.createVehicle());
        }

        //creation de 10 Station
        List<Station> allStation = new ArrayList<>();
        for(int i=0; i<10;i++){
            allStation.add(new Station());
        }

        //add subscribe control center to them
        allStation.forEach(t -> t.addSubscriber(mainControlCenter));


        //add repairer
        for(int i=0; i<4;i++){
            workerVec.add(new Repair(mainControlCenter));
        }
        int nb_tour = 0;
        while(nb_tour < 20){
            roundDropOff();
            roundRent();
            roundUpdate();
        }



    }
}
