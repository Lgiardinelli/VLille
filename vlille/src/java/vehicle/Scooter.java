package vehicle;

/**
 * Scooter class
 */
public class Scooter extends Vehicle {

    /**
     * Scooter constructor
     */
    public Scooter(int id) {
        super(id);
    }

    @Override
    public String decorateEquipment() {
        return "This is a Scooter";
    }

    @Override
    protected int nbMaxTimeRented() {
        return 4;
    }
}
