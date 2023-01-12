package pl.wsb.javaprojekt.dziennikocenbackend.service;

import org.springframework.stereotype.Service;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Grade;
import pl.wsb.javaprojekt.dziennikocenbackend.repository.GradeRepository;
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {this.gradeRepository = gradeRepository;}

    public Iterable<Grade> listAll() {return gradeRepository.findAll();}

    public void save(Grade grade) {
        if (grade.getCreated() == null){
            grade.setCreated(new Date());
        }
        grade.setModified(new Date());
        gradeRepository.save(grade);
    }

    public Grade find(Integer id) {return gradeRepository.findById(id).orElse(null);}

    public void delete(Integer id) {gradeRepository.deleteById(id);}
}
