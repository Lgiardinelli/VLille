package vehicle;

/**
 * Overboard class
 */
public class Overboard extends Vehicle {

    /**
     * Overboard constructor
     */
    public Overboard(int id) {
        super(id);
    }

    @Override
    public String decorateEquipment() {
        return "This is an Overboard";
    }

    @Override
    protected int nbMaxTimeRented() {
        return 2;
    }
}
