package com.company;

public class ThoroughbredHorse extends Horse implements Raceable {
    @Override
    public void realSpeed(double randomSpeedCoefficient) {
        if ((age <= 6) & (age >= 2)) {
            actualSpeed = speed - Math.random();
        } else {
            actualSpeed = speed - (age / 10);
        }
        actualSpeed= actualSpeed + randomSpeedCoefficient;
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
