package com.desabisc.udemy.chad.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Primary : error more than one 'primary' bean found among candidates
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // new object instance for each injection.
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    /*// define the init method, executes when the project starts.
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartUpStuff(): " + this.getClass().getSimpleName());
    }

    // define the destroy method, executes when the project stops.
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff(): " + this.getClass().getSimpleName());
    }*/

    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling for 15 minutes!!!";
    }
}
