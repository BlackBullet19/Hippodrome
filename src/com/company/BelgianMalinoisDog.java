package com.company;

public class BelgianMalinoisDog extends Dog implements Raceable{
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
    public void realSpeed(double randomSpeedCoefficient) {
        actualSpeed = (age <= 5 ? speed - Math.random() : speed - (age / 10)) + randomSpeedCoefficient;
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
