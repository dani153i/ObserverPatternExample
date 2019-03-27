package com.designpatterns.observer.model;

import java.util.Observable;

public class Switch extends Observable {
    private State state = State.OFF;
    private String name;

    public State getState() { return state; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Switch(String name) {
        this.name = name;
    }


    public void toggle() {
        state = state.equals(State.OFF) ? State.ON : State.OFF;
        setChanged();
        notifyObservers();
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
