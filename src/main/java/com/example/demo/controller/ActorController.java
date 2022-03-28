package com.example.demo.controller;


import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }


    @GetMapping
    public List<Actor> getAllActors(){
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Actor getActorById(@PathVariable Long id){
        return actorService.getActorById(id);
    }

    @PostMapping
    public Actor createActor(@RequestBody Actor actor){
        return actorService.createActor(actor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActorById(@PathVariable long id, @RequestBody Actor actor){
        actor = actorService.updateActorById(id, actor);
        return ResponseEntity.ok(actor);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Map<String, Boolean>> deleteActorById(@PathVariable long id){
        boolean deleted = false;
        deleted = actorService.deleteActorById(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }
}
