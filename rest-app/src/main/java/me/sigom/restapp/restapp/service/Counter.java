package me.sigom.restapp.restapp.service;

import jakarta.ejb.Singleton;
import jakarta.inject.Named;

@Singleton
@Named
public class Counter {

    private int counter = 0;
    public void increment() {
        counter++;
    }
    public int getCounter() {
        return counter;}
}
