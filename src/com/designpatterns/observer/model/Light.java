package com.designpatterns.observer.model;

import java.util.Observable;
import java.util.Observer;

public class Light implements Observer {
    private State state = State.OFF;
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }


    public Light(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Switch) {
            if(((Switch) o).getState().equals(Switch.State.ON))
                turnOn();
            else
                turnOff();
        }
    }

    public void turnOn() {
        state = State.ON;
        System.out.println("Light " + getName() + " : " + state.toString() + ".");
    }

    public void turnOff() {
        state = State.OFF;
        System.out.println("Light "+ getName() + " : " + state.toString() + ".");
    }

    public enum State {
        ON("On"),
        OFF("Off");

        private final String name;
        State(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
