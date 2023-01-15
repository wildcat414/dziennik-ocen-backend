package pl.wsb.javaprojekt.dziennikocenbackend.service;

import com.google.common.hash.Hashing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.wsb.javaprojekt.dziennikocenbackend.model.User;
import pl.wsb.javaprojekt.dziennikocenbackend.repository.UserRepository;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
            String sha256value = Hashing.sha256()
                    .hashString(user.getPasswordHash(), StandardCharsets.UTF_8)
                    .toString();
            user.setPasswordHash(sha256value);
        }
        user.setModified(new Date());
        userRepository.save(user);
    }

    public User find(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByLogin(String login) {
        List<User> users = userRepository.findByLogin(login);
        if(users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    public User authentication(String login, String password) {
        User userEntity = this.findByLogin(login);
        if (userEntity == null) {
            return null;
        }
        String sha256value = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        if(userEntity.getPasswordHash().equals(sha256value)) {
            userEntity.setAccessToken(generateRandomString(32));
            userRepository.save(userEntity);
            return userEntity;
        } else {
            return null;
        }
    }

    public String generateRandomString(int targetLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

}
