package com.desabisc.udemy.chad.rest;

import com.desabisc.udemy.chad.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    /*
    @Autowired
    public DemoController(Coach theCoach) {
        this.myCoach = theCoach;
    }*/

    // Used with @Primary in TrackCoach
    @Autowired
    private void setMyCoach(Coach theCoach) {
        this.myCoach = theCoach;
    }

    /*@Autowired
    private void setMyCoach(@Qualifier("cricketCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
