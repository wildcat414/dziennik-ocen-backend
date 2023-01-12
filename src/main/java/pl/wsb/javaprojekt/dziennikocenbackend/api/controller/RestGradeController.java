package pl.wsb.javaprojekt.dziennikocenbackend.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.javaprojekt.dziennikocenbackend.api.dto.GradeDTO;
import pl.wsb.javaprojekt.dziennikocenbackend.api.mapper.GradeMapper;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Grade;
import pl.wsb.javaprojekt.dziennikocenbackend.service.GradeService;

@CrossOrigin(origins ={"*"})
@RestController
@RequestMapping("/api/grade")

public class RestGradeController {

    private final GradeService gradeService;

    private final GradeMapper gradeMapper;

    public RestGradeController(
            GradeService gradeService,
            GradeMapper gradeMapper

    ){
      this.gradeService = gradeService;
      this.gradeMapper = gradeMapper;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<GradeDTO>> index(){
        try {
            return new ResponseEntity<>(
                    gradeMapper.map(
                            gradeService.listAll()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createGrade(@RequestBody GradeDTO gradeDTO) {
        try {
            gradeService.save(
                    gradeMapper.gradeDTOToGrade(
                            gradeDTO
                    )
            );
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeDTO> updateGrade(
            @PathVariable("id") Integer id,
            @RequestBody GradeDTO gradetDTO
    ) {
        try {
            Grade gradeEntity = gradeService.find(id);
            if (gradeEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            gradeService.save(
                    gradeMapper.gradeDTOToGrade(
                            gradetDTO,
                            gradeEntity
                    )
            );
            return new ResponseEntity<>(
                    gradeMapper.gradeToGradeDTO(
                            gradeEntity
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable("id") Integer id) {
        try {
            Grade gradeEntity = gradeService.find(id);
            if (gradeEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            gradeService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
