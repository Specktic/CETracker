package com.spring.cetracker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CETrackerController {

    @RequestMapping
    public String CETracker() {
        return "Hello";
    }
}
