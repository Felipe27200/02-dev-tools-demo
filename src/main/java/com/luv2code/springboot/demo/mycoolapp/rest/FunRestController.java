package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* This let you make an HTTP request
* */
@RestController
public class FunRestController
{
    // Inject properties for: coach.name and team.name

    /*
    * We must use the @Value annotation to inject
    * the values defined in application.properties file.
    * */
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // Expose the value defined for the annotations @Value
    @GetMapping("/team-info")
    public String getTeamInfo()
    {
        return "Coach: " + this.coachName +
            ", Team name: " + this.teamName;
    }

    /*
    * Define the route and the data that is going to return.
    *
    * This defined a GET request, with the route /
    * and will return a string.
    * */
    @GetMapping("/")
    public String helloWorld()
    {
        return "Hello World!!!";
    }

    // Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return "Run a hard 5km";
    }

    // Expose a new endpoint for "Fortune"
    @GetMapping("/fortune")
    public String getDailyFortune()
    {
        return "Today is your lucky day.";
    }
}
