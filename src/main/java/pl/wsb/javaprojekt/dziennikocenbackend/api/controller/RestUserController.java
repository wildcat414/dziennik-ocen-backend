package pl.wsb.javaprojekt.dziennikocenbackend.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.javaprojekt.dziennikocenbackend.api.dto.UserDTO;
import pl.wsb.javaprojekt.dziennikocenbackend.api.mapper.UserMapper;
import pl.wsb.javaprojekt.dziennikocenbackend.model.User;
import pl.wsb.javaprojekt.dziennikocenbackend.service.UserService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/user")
public class RestUserController {

    private final UserService userService;

    private final UserMapper userMapper;

    public RestUserController(
            UserService userService,
            UserMapper userMapper
    ) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<UserDTO>> index() {
        try {
            return new ResponseEntity<>(
                    userMapper.map(
                            userService.listAll()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createUser(@RequestBody UserDTO userDTO) {
        try {
            userService.save(
                    userMapper.userDTOToUser(
                            userDTO
                    )
            );
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable("id") Integer id,
            @RequestBody UserDTO userDTO
    ) {
        try {
            User userEntity = userService.find(id);
            if (userEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            userService.save(
                    userMapper.userDTOToUser(
                            userDTO,
                            userEntity
                    )
            );
            return new ResponseEntity<>(
                    userMapper.userToUserDTO(
                            userEntity
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        try {
            User userEntity = userService.find(id);
            if (userEntity == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            userService.delete(id);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/authentication")
    public ResponseEntity<UserDTO> authenticateUser(@RequestBody LoginAndPassword params) {
        try {
            User user = userService.authentication(params.login, params.password);
            if(user != null) {
                return new ResponseEntity<>(
                        userMapper.userToUserDTO(user), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static class LoginAndPassword {
        public String login;
        public String password;
    }

    
}
