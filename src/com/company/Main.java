package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Main hippodrome = new Main();

        AmericanQuarterHorse americanQuarterHorse1 = new AmericanQuarterHorse();
        americanQuarterHorse1.setName("AmericanQuarterHorse1");
        americanQuarterHorse1.setAge(10);
        americanQuarterHorse1.setSpeed(4.5);

        AmericanQuarterHorse americanQuarterHorse2 = new AmericanQuarterHorse();
        americanQuarterHorse2.setName("AmericanQuarterHorse2");
        americanQuarterHorse2.setAge(14);
        americanQuarterHorse2.setSpeed(4.5);

        ArabianHorse arabianHorse1 = new ArabianHorse();
        arabianHorse1.setName("ArabianHorse1");
        arabianHorse1.setAge(8);
        arabianHorse1.setSpeed(5.2);

        ArabianHorse arabianHorse2 = new ArabianHorse();
        arabianHorse2.setName("ArabianHorse2");
        arabianHorse2.setSpeed(5.2);
        arabianHorse2.setAge(8.5);

        ThoroughbredHorse thoroughbred1 = new ThoroughbredHorse();
        thoroughbred1.setName("ThoroughbredHorse1");
        thoroughbred1.setSpeed(4.2);
        thoroughbred1.setAge(12.5);

        ThoroughbredHorse thoroughbred2 = new ThoroughbredHorse();
        thoroughbred2.setName("ThoroughbredHorse2");
        thoroughbred2.setSpeed(4.2);
        thoroughbred2.setAge(4.9);

        MorganHorse morganHorse1 = new MorganHorse();
        morganHorse1.setName("MorganHorse1");
        morganHorse1.setSpeed(5.7);
        morganHorse1.setAge(15.5);

        MorganHorse morganHorse2 = new MorganHorse();
        morganHorse2.setName("MorganHorse2");
        morganHorse2.setSpeed(5.7);
        morganHorse2.setAge(14.9);

        AkitaDog akitaDog1 = new AkitaDog();
        akitaDog1.setName("AkitaDog1");
        akitaDog1.setSpeed(6.4);
        akitaDog1.setAge(2.9);

        AkitaDog akitaDog2 = new AkitaDog();
        akitaDog2.setName("AkitaDog2");
        akitaDog2.setSpeed(6.4);
        akitaDog2.setAge(3.8);

        BelgianMalinoisDog belgianMalinoisDog1 = new BelgianMalinoisDog();
        belgianMalinoisDog1.setName("belgianMalinoisDog1");
        belgianMalinoisDog1.setSpeed(5.7);
        belgianMalinoisDog1.setAge(6.3);

        BelgianMalinoisDog belgianMalinoisDog2 = new BelgianMalinoisDog();
        belgianMalinoisDog2.setName("belgianMalinoisDog2");
        belgianMalinoisDog2.setSpeed(5.7);
        belgianMalinoisDog2.setAge(5.4);

        BoradorDog boradorDog1 = new BoradorDog();
        boradorDog1.setName("boradorDog1");
        boradorDog1.setSpeed(4.9);
        boradorDog1.setAge(3.5);

        BoradorDog boradorDog2 = new BoradorDog();
        boradorDog2.setName("boradorDog2");
        boradorDog2.setSpeed(4.9);
        boradorDog2.setAge(3.8);

        GermanShepherdDog germanShepherdDog1 = new GermanShepherdDog();
        germanShepherdDog1.setName("germanShepherdDog1");
        germanShepherdDog1.setSpeed(4.85);
        germanShepherdDog1.setAge(1.8);

        GermanShepherdDog germanShepherdDog2 = new GermanShepherdDog();
        germanShepherdDog2.setName("germanShepherdDog2");
        germanShepherdDog2.setSpeed(4.85);
        germanShepherdDog2.setAge(2.19);

        List<Raceable> participants = new ArrayList<>();
        participants.add(akitaDog1);
        participants.add(akitaDog2);
        participants.add(americanQuarterHorse1);
        participants.add(americanQuarterHorse2);
        participants.add(arabianHorse1);
        participants.add(arabianHorse2);
        participants.add(belgianMalinoisDog1);
        participants.add(belgianMalinoisDog2);
        participants.add(boradorDog1);
        participants.add(boradorDog2);
        participants.add(germanShepherdDog1);
        participants.add(germanShepherdDog2);
        participants.add(morganHorse1);
        participants.add(morganHorse2);
        participants.add(thoroughbred1);
        participants.add(thoroughbred2);

        for (Raceable participant : participants) {
            int position = hippodrome.generateStartPosition(participants.size());
            participant.setPosition(position);
        }

        int length = 1000;
        Raceable winner = null;
        while (true) {

            for (Raceable participant : participants) {
                double randomSpeedCoefficient = Math.random() * 2;
                participant.realSpeed(randomSpeedCoefficient);
                participant.makeStep();
            }

            participants.sort(Comparator.comparing(Raceable::distanceDone).reversed());

            boolean needToStopLoop = false;
            for (Raceable participant : participants) {
                if (participant.finished(length)) {
                    needToStopLoop = true;
                    winner = participant;
                    break;
                }
            }
            if (needToStopLoop) {
                break;
            }
        }

        for (Raceable participant : participants) {
            participant.setActualPosition((participants.indexOf(participant)) + 1);
            System.out.println(participant.actualPositionInfo());
        }

        System.out.println();

        int dogPositionIndex = 1;
        for (Raceable participant : participants) {
            if (participant instanceof Dog) {
                System.out.println("Group position: " + dogPositionIndex + "; " + participant.actualPositionInfo());
                dogPositionIndex++;
            }
        }

        System.out.println();

        int horsePositionIndex = 1;
        for (Raceable participant : participants) {
            if (participant instanceof Horse) {
                System.out.println("Group position: " + horsePositionIndex + "; " + participant.actualPositionInfo());
                horsePositionIndex++;
            }
        }

        System.out.println();
        System.out.println("Winner:");
        System.out.println(winner);
    }

    private int generateStartPosition(int size) {
        return (int) (Math.random() * size + 1);
    }
}


