package station.stateStation;

import station.Station;

public class Empty extends StateStation {


    public Empty(Station s){
        super(s);
    }

    @Override
    public void toEmpty() {

    }

    @Override
    public void toNormal() {
        this.s.setStateStation(new Normal(this.s));
    }

    @Override
    public void toFull() {

    }


    @Override
    public boolean canBeRent() {
        return false;
    }

    @Override
    public boolean canBeDropOff() {
        return true;
    }
}
