package com.example.demo.service;

import com.example.demo.model.Actor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ActorService {
    List<Actor> getAllActors();

    Actor getActorById(Long id);

    Actor createActor(Actor actor);

    Actor updateActorById(long id,Actor actor);

    boolean deleteActorById(long id);
}
