package pl.wsb.javaprojekt.dziennikocenbackend.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import pl.wsb.javaprojekt.dziennikocenbackend.api.dto.SubjectDTO;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Subject;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDTO subjectToSubjectDTO(Subject entity);

    @Mappings({
            @Mapping(target="id", ignore = true)
    })
    Subject subjectDTOToSubject(SubjectDTO dto);

    @Mappings({
            @Mapping(target="id", ignore = true)
    })
    Subject subjectDTOToSubject(SubjectDTO dto, @MappingTarget Subject subject);

    List<SubjectDTO> map(Iterable<Subject> subject);


}
