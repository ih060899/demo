package com.example.demo.service;


import com.example.demo.entity.ActorEntity;
import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService{
    private ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> getAllActors() {
          List<ActorEntity> actorEntityList = actorRepository.findAll();
          List<Actor> actors = actorEntityList.stream().map(actorEntity -> new Actor(
                  actorEntity.getActorId(),
                  actorEntity.getFirstName(),
                  actorEntity.getLastName()
          )).collect(Collectors.toList());
        return actors;
    }

    @Override
    public Actor getActorById(Long id) {
        ActorEntity actorEntity = actorRepository.findById(id).get();
        Actor actor = new Actor();
        BeanUtils.copyProperties(actorEntity, actor);
        return actor;
    }

    @Override
    public Actor createActor(Actor actor) {
        ActorEntity actorEntity = new ActorEntity();
        BeanUtils.copyProperties(actor, actorEntity);
        actorRepository.save(actorEntity);
        return actor;
    }

    @Override
    public Actor updateActorById(long id, Actor actor) {
        ActorEntity actorEntity = actorRepository.findById(id).get();
        actorEntity.setFirstName(actor.getFirstName());
        actorEntity.setLastName(actor.getLastName());
        actorRepository.save(actorEntity);
        return actor;
    }

    @Override
    public boolean deleteActorById(long id) {
        ActorEntity actorEntity = actorRepository.findById(id).get();
        actorRepository.delete(actorEntity);
        return true;
    }
}
