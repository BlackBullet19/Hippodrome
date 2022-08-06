package com.company;

public interface Raceable {

    void setPosition(int position);

    void makeStep();

    boolean finished (int length);

    void  realSpeed(double randomSpeedCoefficient);

    double distanceDone();

    int setActualPosition(int actualPositionIndex);

    String actualPositionInfo();
}
