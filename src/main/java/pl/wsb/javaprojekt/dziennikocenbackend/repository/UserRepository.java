package pl.wsb.javaprojekt.dziennikocenbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.javaprojekt.dziennikocenbackend.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByLogin(String login);
}
