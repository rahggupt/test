package com.vdx.statistics.model;

public class Events {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int value;

    public long getCreatedAtInSecs() {
        return createdAtInSecs;
    }

    public void setCreatedAtInSecs(long createdAtInSecs) {
        this.createdAtInSecs = createdAtInSecs;
    }

    long createdAtInSecs;


    @Override
    public String toString() {
        return "Events{" +
                "value=" + value +
                ", createdAtInSecs=" + createdAtInSecs +
                '}';
    }
}
