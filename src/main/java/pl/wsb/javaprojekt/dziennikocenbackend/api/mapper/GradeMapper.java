package pl.wsb.javaprojekt.dziennikocenbackend.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import pl.wsb.javaprojekt.dziennikocenbackend.api.dto.GradeDTO;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Grade;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradeMapper {

    GradeDTO gradeToGradeDTO(Grade entity);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Grade gradeDTOToGrade(GradeDTO dto);

    @Mappings({
            @Mapping(target="id", ignore = true)
    })
    Grade gradeDTOToGrade(GradeDTO dto, @MappingTarget Grade grade);

    List<GradeDTO> map(Iterable<Grade> grade);
}
