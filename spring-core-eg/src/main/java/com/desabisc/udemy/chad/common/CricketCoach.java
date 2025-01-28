package com.desabisc.udemy.chad.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary : error more than one 'primary' bean found among candidates
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling for 15 minutes!!!";
    }
}
