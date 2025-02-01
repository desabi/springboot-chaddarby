package com.desabisc.udemy.chad.rest;

import com.desabisc.udemy.chad.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    /*
    @Autowired
    public DemoController(Coach theCoach) {
        this.myCoach = theCoach;
    }*/

    // Used with @Primary in TrackCoach
    /*@Autowired
    private void setMyCoach(@Qualifier("cricketCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }*/

    @Autowired
    private void setMyCoach(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/check")
    public String check() {
        return "Beans are equals: " + this.myCoach.equals(this.anotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
