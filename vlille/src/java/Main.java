import controlCenter.ControlCenter;
import displayer.ConsoleDisplayer;
import displayer.DisplayerInterface;
import exeption.StationFullException;
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

import java.util.*;

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



    public static void main(String[] arg) throws StationFullException {



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

        Iterator<Vehicle> x = allVec.iterator();
        for(int i = 0; i < 10;i++){
            for(int j = 0; j < 7;j++){
                if(x.hasNext()){
                    allStation.get(i).dropOffVehicle(x.next());
                }
            }
        }
        allVec.iterator().next().toHS();
        DisplayerInterface t = new ConsoleDisplayer();
        t.displayControlCenter(mainControlCenter);

        t.displayStation(allStation.get(2));

//        int nb_tour = 0;
//        while(nb_tour < 20){
//            roundDropOff();
//            roundRent();
//            roundUpdate();
//        }




    }
}
