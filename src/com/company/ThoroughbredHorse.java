package com.company;

public class ThoroughbredHorse extends Horse implements Raceable {
    @Override
    public void realSpeed(double randomSpeedCoefficient) {
        actualSpeed = (age <= 7 ? speed - Math.random() : speed - (age / 10)) + randomSpeedCoefficient;
    }

    @Override
    public void setPosition(int position) {
        startingPosition = position;
    }

    @Override
    public void makeStep() {
        distanceDone += actualSpeed;
    }

    @Override
    public boolean finished(int length) {
        return distanceDone >= length;
    }

    @Override
    public double distanceDone() {
        return distanceDone;
    }

    @Override
    public int setActualPosition(int actualPosition) {
        return this.actualPosition=actualPosition;
    }

    @Override
    public String actualPositionInfo() {
        return "Actual position: "+ actualPosition +"; Participant: " + name + "; Distance done " + distanceDone +" meters";
    }
}
