package com.company;

public abstract class Dog {

    private static final double DEFAULT_SPEED = 6;
    private static final double DEFAULT_AGE = 5;
    private static final String DEFAULT_NAME = "KEVIN the Dog";

    protected String name;
    protected double speed;
    protected double age;
    protected int startingPosition;
    protected int actualPosition;
    protected double distanceDone;
    protected double actualSpeed;

    public void setName(String name) {
        if (name != null) {
            this.name = name.isEmpty() ? DEFAULT_NAME : name;
        } else {
            this.name = DEFAULT_NAME;
        }
    }

    public void setSpeed(double speed) {
        this.speed = speed > 0 ? speed : DEFAULT_SPEED;
    }

    public void setAge(double age) {
        this.age = age > 0 ? age : DEFAULT_AGE;
    }

    @Override
    public String toString() {
        return name + "; Starting position " + startingPosition   + "; Distance done " + distanceDone;
    }
}
