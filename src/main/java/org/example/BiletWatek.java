package org.example;

public class BiletWatek extends Thread{
    private PulaBiletow pulaBiletow;
    private int numerBiletu;

    public BiletWatek(PulaBiletow pulaBiletow, int numerBiletu){
        this.pulaBiletow = pulaBiletow;
        this.numerBiletu = numerBiletu;
    }

    @Override
    public void run(){
        try{
            pulaBiletow.rezerwujBilet(numerBiletu, (int) this.getId());
            Thread.sleep(10000);
            pulaBiletow.anulujBilet(numerBiletu, (int) this.getId());
        }catch (InterruptedException e){
            System.out.println("Wątek #" + this.getId() + " został przerwany.");
        }
    }
}
