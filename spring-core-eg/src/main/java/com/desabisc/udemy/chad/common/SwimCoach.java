package com.desabisc.udemy.chad.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters as a warm up";
    }
}
