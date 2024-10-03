package com.ardagermiyanoglu.apache_kafka.controller;

import com.ardagermiyanoglu.apache_kafka.dto.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ardagermiyanoglu.apache_kafka.service.EventService;

@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping
    public String healthCheck(@RequestBody String event){

        eventService.send(event);
        return "Event sent successfully";
    }

    @PostMapping
    public Event sendEvent(@RequestBody Event event){
        eventService.send(event);
        return event;
    }
}
