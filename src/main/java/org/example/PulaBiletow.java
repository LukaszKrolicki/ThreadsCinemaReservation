package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PulaBiletow {
    private boolean[] bilety;
    private Lock lock;

    public PulaBiletow(int liczba_biletow){
        bilety = new boolean[liczba_biletow];
        lock = new ReentrantLock();
    }

    public void rezerwujBilet(int numerBiletu, int numerWatku){
        lock.lock();
        try{
            while(bilety[numerBiletu]){
                System.out.println("Wątek #" + numerWatku + " czeka na zwolnienie biletu #" + numerBiletu);
                lock.unlock();
                Thread.sleep(10000);
                lock.lock();
            }
            bilety[numerBiletu]=true;
            System.out.println("Wątek #" + numerWatku + " zarezerwował #" + numerBiletu);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            lock.unlock();
        }
    }

    public void anulujBilet(int numerBiletu, int numerWatku){
        lock.lock();
        try{
            bilety[numerBiletu]=false;
            System.out.println("Wątek #" + numerWatku + " anulował rezerwację biletu #" + numerBiletu);

        }
        finally {
            lock.unlock();
        }
    }
}
