package pl.wsb.javaprojekt.dziennikocenbackend.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import pl.wsb.javaprojekt.dziennikocenbackend.api.dto.ActorDTO;
import pl.wsb.javaprojekt.dziennikocenbackend.model.Actor;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    /*
    @Mappings({
            @Mapping(target="id", source="entity.id"),
            @Mapping(target="firstName", source="entity.firstName"),
            @Mapping(target="lastName", source="entity.lastName")
    })
    ActorDTO actorToActorDTO(Actor entity);
    */

    ActorDTO actorToActorDTO(Actor entity);

    @Mappings({
            @Mapping(target="id", ignore = true)
    })
    Actor actorDTOToActor(ActorDTO dto);

    @Mappings({
            @Mapping(target="id", ignore = true)
    })
    Actor actorDTOToActor(ActorDTO dto, @MappingTarget Actor actor);

    List<ActorDTO> map(Iterable<Actor> actors);

}
