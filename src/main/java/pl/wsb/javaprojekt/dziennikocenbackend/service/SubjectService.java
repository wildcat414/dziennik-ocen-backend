package pl.wsb.javaprojekt.dziennikocenbackend.service;
import org.springframework.stereotype.Service;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Subject;
import pl.wsb.javaprojekt.dziennikocenbackend.repository.SubjectRepository;
import javax.transaction.Transactional;

import java.util.Date;

@Service
@Transactional
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {this.subjectRepository = subjectRepository;}

    public Iterable<Subject> listAll() {return subjectRepository.findAll();}

    public void save(Subject subject) {
        if (subject.getCreated() == null){
            subject.setCreated(new Date());
        }
        subject.setModified(new Date());
        subjectRepository.save(subject);
    }

     public Subject find(Integer id) {return  subjectRepository.findById(id).orElse(null);}

    public void delete(Integer id) {subjectRepository.deleteById(id);}

}
