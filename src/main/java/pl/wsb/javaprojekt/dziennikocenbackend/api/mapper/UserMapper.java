package pl.wsb.javaprojekt.dziennikocenbackend.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import pl.wsb.javaprojekt.dziennikocenbackend.api.dto.UserDTO;
import pl.wsb.javaprojekt.dziennikocenbackend.model.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User entity);

    @Mappings({
            @Mapping(target="id", ignore = true)
    })
    User userDTOToUser(UserDTO dto);

    @Mappings({
            @Mapping(target="id", ignore = true)
    })
    User userDTOToUser(UserDTO dto, @MappingTarget User user);

    List<UserDTO> map(Iterable<User> users);

}
