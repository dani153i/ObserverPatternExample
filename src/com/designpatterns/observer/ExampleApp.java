package com.designpatterns.observer;

import com.designpatterns.observer.model.Light;
import com.designpatterns.observer.model.Switch;

import java.util.*;

public class ExampleApp {

    List<Switch> switches = new ArrayList<>();
    Scanner scanner;
    boolean run;

    public ExampleApp() {
        // initialize needed components
        init();

        // run program
        run();
    }

    private void init() {
        // initialize new Scanner object
        scanner = new Scanner(System.in);

        // Configure switches
        Switch switchOne = new Switch("Bathroom");
        Switch switchTwo = new Switch("Kitchen");
        Switch switchThree = new Switch("Parent Switch");

        // add switches to switch collection
        switches.add(switchOne);
        switches.add(switchTwo);
        switches.add(switchThree);

        // Configure lights
        Light lightOne = new Light("Bathroom Ceiling");
        Light lightTwo = new Light("Bathroom Mirror Header");

        Light lightThree = new Light("Kitchen Ceiling - 1");
        Light lightFour = new Light("Kitchen Counter - 1");
        Light lightFive = new Light("Kitchen Counter - 2");

        // add observers for bathroom
        switchOne.addObserver(lightTwo);
        switchOne.addObserver(lightOne);

        // add observers for kitchen
        switchTwo.addObserver(lightFive);
        switchTwo.addObserver(lightFour);
        switchTwo.addObserver(lightThree);


        // add observers for main breaker
        switchThree.addObserver(lightFive);
        switchThree.addObserver(lightFour);
        switchThree.addObserver(lightThree);
        switchThree.addObserver(lightTwo);
        switchThree.addObserver(lightOne);
    }

    private void run() {
        run = true;
        while (run)
            displayMenu();
    }

    private void displayMenu() {
        Map<String, Switch> options = new HashMap<>();

        System.out.println();

        int i = 1;
        for(Switch switchObj : switches) {
            // add option
            options.put(String.valueOf(i), switchObj);
            // print option
            System.out.println(i + ")\t" + switchObj.getName() + " : " + switchObj.getState().toString());
            // increase current index
            i++;
        }

        System.out.println();

        String option = "";
        // while input is not "0" and input isn't a key in 'options' Map
        while (!(option.equals(String.valueOf(0)) || options.containsKey(option))) {
            System.out.print("Toggle switch >> ");
            option = scanner.nextLine();
        }

        // input is now "0" or equals a key in 'options' Map

        // if input equals "0"
        if(option.equals(String.valueOf(0))) {
            run = false;
            return;
        }

        System.out.println();

        // input does now equal a key in 'options' Map
        options.get(option).toggle();
    }

    public static void main(String[] args) {
        new ExampleApp();
    }
}
