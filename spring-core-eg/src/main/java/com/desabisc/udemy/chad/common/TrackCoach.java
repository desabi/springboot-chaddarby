package com.desabisc.udemy.chad.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // There can only be one, it wil be the primary coach
// and if both primary and qualifier are used, qualifier has high priority.
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
