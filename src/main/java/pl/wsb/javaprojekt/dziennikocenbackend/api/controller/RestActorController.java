package pl.wsb.javaprojekt.dziennikocenbackend.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.javaprojekt.dziennikocenbackend.api.dto.ActorDTO;
import pl.wsb.javaprojekt.dziennikocenbackend.api.mapper.ActorMapper;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Actor;
import pl.wsb.javaprojekt.dziennikocenbackend.service.ActorService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/actor")
public class RestActorController {

    private final ActorService actorService;

    private final ActorMapper actorMapper;

    public RestActorController(
            ActorService actorService,
            ActorMapper actorMapper
    ) {
        this.actorService = actorService;
        this.actorMapper = actorMapper;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<ActorDTO>> index() {
        try {
            return new ResponseEntity<>(
                    actorMapper.map(
                            actorService.listAll()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createActor(@RequestBody ActorDTO actorDTO) {
        try {
            actorService.save(
                    actorMapper.actorDTOToActor(
                            actorDTO
                    )
            );
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorDTO> updateActor(
            @PathVariable("id") Integer id,
            @RequestBody ActorDTO actorDTO
    ) {
        try {
            Actor actorEntity = actorService.find(id);
            if (actorEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            actorService.save(
                    actorMapper.actorDTOToActor(
                            actorDTO,
                            actorEntity
                    )
            );
            return new ResponseEntity<>(
                    actorMapper.actorToActorDTO(
                            actorEntity
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable("id") Integer id) {
        try {
            Actor actorEntity = actorService.find(id);
            if (actorEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } //if
            actorService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}