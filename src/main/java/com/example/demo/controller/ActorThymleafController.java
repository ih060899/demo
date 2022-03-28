package com.example.demo.controller;

import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ActorThymleafController {

    private ActorService actorService;

    public ActorThymleafController(ActorService actorService) {
        this.actorService = actorService;
    }


    @GetMapping("/home")
    public String home(Model model){

        List<Actor> actors = actorService.getAllActors();
        model.addAttribute("actors", actors);
        return "home";
    }

    @GetMapping("/add")
    public String addPage(){
        return "add";
    }

    @PostMapping("/submit")
    public String submissionResult(@ModelAttribute("actor") Actor actor) {
        System.out.println(actor.getFirstName());
        return "home";
    }


}
