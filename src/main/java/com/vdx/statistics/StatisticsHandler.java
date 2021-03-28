package com.vdx.statistics;

import com.vdx.statistics.model.Events;

import java.util.Date;

public class StatisticsHandler implements Statistics{

    EventHandler handler = new EventHandler();
    @Override
    public void event(int value) {
        Events events = new Events();
        events.setValue(value);
        events.setCreatedAtInSecs(new Date().getTime()/1000);

        try {
            handler.produce(events);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public float mean() {
        System.out.println("finding mean");
        return handler.findMean();
    }

    @Override
    public float mean(int lastNMinutes) {
        return handler.findMean(lastNMinutes);
    }

    @Override
    public float variance() {
        return handler.findVariance();
    }

    @Override
    public int minimum() {
        return handler.findMin();
    }

    @Override
    public int maximum() {
        return handler.findMax();
    }
}
