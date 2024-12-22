import controlCenter.ControlCenter;
import displayer.ConsoleDisplayer;
import displayer.DisplayerInterface;
import exeption.NoVehicleOfThisTypeAvailableException;
import exeption.StationEmptyException;
import exeption.StationFullException;
import listchooser.ListChooser;
import listchooser.RandomListChooser;
import listchooser.RandomSetChooser;
import listchooser.SetChooser;
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
    private static ListChooser<Vehicle> listChooserVehicle = new RandomListChooser<>();
    private static SetChooser<Vehicle> vehicleSetChooser = new RandomSetChooser<>();
    private static SetChooser<Station> stationSetChooser = new RandomSetChooser<>();
    private static Random random = new Random();

    private static void roundDropOff() throws StationFullException {
        if(!rentedVec.isEmpty()){
            int nbDropOff = random.nextInt(1,rentedVec.size()+1);
            for (int i=0; i<nbDropOff; i++) {
                dropVehicleStationAlea();
            }
        }
        else {
            System.out.println("Aucun véhicule n'a été loué !");
        }
    }

    private static void dropVehicleStationAlea() throws StationFullException {
        Vehicle vehicle = listChooserVehicle.choose(rentedVec);
        rentedVec.remove(vehicle);
        Station station = stationSetChooser.choose(mainControlCenter.getStations().keySet());
        station.dropOffVehicle(vehicle);
        System.out.println("Le véhicule " + vehicle.getClass() + " a été déposé à la station " + station.getId());
    }

    private static void roundRent() throws StationEmptyException, NoVehicleOfThisTypeAvailableException {
        Station station = stationSetChooser.choose(mainControlCenter.getStations().keySet());
        Vehicle vehicle = station.rentVehicle(Vehicle.class::isInstance);
        rentedVec.add(vehicle);
        System.out.println("Le vehicule " + vehicle.getClass() + " a été loué dans la station " + station.getId());
    }

    private static void roundUpdate(){

    }




    public static void main(String[] arg) throws StationFullException, StationEmptyException, NoVehicleOfThisTypeAvailableException {



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
//        t.displayControlCenter(mainControlCenter);
//
//        t.displayStation(allStation.get(2));

        int nb_tour = 0;
        while(nb_tour < 2){
            System.out.println("Tour n°" + nb_tour);
            t.displayControlCenter(mainControlCenter);
            roundDropOff();
            roundRent();
            roundUpdate();
            t.displayControlCenter(mainControlCenter);
            nb_tour++;
        }




    }
}
