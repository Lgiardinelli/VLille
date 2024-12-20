package vehicle;

/**
 * Bike class
 */
public class Bike extends Vehicle {
    /**
     * Bike constructor
     */
    public Bike(int id) {
        super(id);
    }

    @Override
    public String decorateEquipment() {
        return "This is a Bike";
    }
}
