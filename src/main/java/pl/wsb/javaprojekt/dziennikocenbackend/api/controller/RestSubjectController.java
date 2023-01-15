package pl.wsb.javaprojekt.dziennikocenbackend.api.controller;

import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.javaprojekt.dziennikocenbackend.api.dto.SubjectDTO;
import pl.wsb.javaprojekt.dziennikocenbackend.api.mapper.SubjectMapper;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Subject;
import pl.wsb.javaprojekt.dziennikocenbackend.model.User;
import pl.wsb.javaprojekt.dziennikocenbackend.repository.SubjectRepository;
import pl.wsb.javaprojekt.dziennikocenbackend.repository.UserRepository;
import pl.wsb.javaprojekt.dziennikocenbackend.service.SubjectService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/subject")


public class RestSubjectController {


    private final SubjectService subjectService;

    private final SubjectMapper subjectMapper;
    private final SubjectRepository subjectRepository;

    public RestSubjectController(
            SubjectService subjectService,
            SubjectMapper subjectMapper,
            SubjectRepository subjectRepository,
            UserRepository userRepository) {
        this.subjectService = subjectService;
        this.subjectMapper = subjectMapper;
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<SubjectDTO>> index() {
        try {
            return new ResponseEntity<>(
                    subjectMapper.map(
                            subjectService.listAll()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createSubject(@RequestBody SubjectDTO subjectDTO) {
        try {
            subjectService.save(
                    subjectMapper.subjectDTOToSubject(
                            subjectDTO
                    )
            );
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubjectDTO> updateSubject(
            @PathVariable("id") Integer id,
            @RequestBody SubjectDTO subjectDTO
    ) {
        try {
            Subject subjectEntity = subjectService.find(id);
            if (subjectEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            subjectService.save(
                    subjectMapper.subjectDTOToSubject(
                            subjectDTO,
                            subjectEntity
                    )
            );
            return new ResponseEntity<>(
                    subjectMapper.subjectToSubjectDTO(
                            subjectEntity
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable("id") Integer id) {
        try {
            Subject subjectEntity = subjectService.find(id);
            if (subjectEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            subjectService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
