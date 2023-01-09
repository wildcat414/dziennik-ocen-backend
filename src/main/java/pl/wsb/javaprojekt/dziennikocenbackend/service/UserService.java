package pl.wsb.javaprojekt.dziennikocenbackend.service;

import org.springframework.stereotype.Service;
import pl.wsb.javaprojekt.dziennikocenbackend.model.User;
import pl.wsb.javaprojekt.dziennikocenbackend.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> listAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        if (user.getCreated() == null) {
            user.setCreated(new Date());
        }
        user.setModified(new Date());
        userRepository.save(user);
    }

    public User find(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
