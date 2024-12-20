package vehicle;

/**
 * Overboard class
 */
public class Overboard extends Vehicle {

    /**
     * Overboard constructor
     */
    public Overboard() {
        super();
    }

    @Override
    public String decorateEquipment() {
        return "This is an Overboard";
    }
}
