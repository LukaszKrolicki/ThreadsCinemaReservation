package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int liczbaBiletow=3;
        int liczbaWatkow=10;
        PulaBiletow pulaBiletow = new PulaBiletow(liczbaBiletow);

        BiletWatek[] watki = new BiletWatek[liczbaWatkow];

        for(int i = 0; i < watki.length; i++){
            watki[i] = new BiletWatek(pulaBiletow, i%liczbaBiletow);
            watki[i].start();
        }

        for(int i=0; i<liczbaWatkow;i++){
            watki[i].join();
        }

        System.out.println("Finished");
    }
}