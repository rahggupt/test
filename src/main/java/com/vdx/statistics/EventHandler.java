package com.vdx.statistics;

import com.vdx.statistics.model.Events;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventHandler {

    public EventHandler() {
    }

    Queue<Events> queue = new LinkedBlockingQueue<>();

    public void produce(Events value) throws InterruptedException
    {
            synchronized (queue)
            {
                queue.add(value);
            }
    }

    public int findMean(){
        synchronized (queue) {
            return (int) queue.stream().mapToInt(event -> event.getValue()).average().getAsDouble();
        }
    }

    public int findMean(int lastNMins){
        synchronized (queue) {
            return (int) queue.stream().filter(event -> (event.getCreatedAtInSecs() > new Date().getTime() / 1000 - lastNMins * 60)).mapToInt(event -> event.getValue()).average().getAsDouble();
        }
    }

    public float findVariance(){
        synchronized (queue) {
            int mean = findMean();
            return (float) queue.stream().map(event -> event.getValue() - mean)
                    .map(elem -> elem * elem)
                    .mapToDouble(i -> i).average().getAsDouble();
        }
    }

    public int findMin(){
        synchronized (queue) {
            return queue.stream()
                    .mapToInt(i -> i.getValue()).min().getAsInt();
        }
    }

    public int findMax(){
        synchronized (queue) {
            return queue.stream()
                    .mapToInt(i -> i.getValue()).max().getAsInt();
        }
    }


}
