package station;

public class MockStation extends Station{

    public MockStation(){
        super();
    }

    @Override
    protected int randomCapacityMax() {
        return 2;
    }
}
