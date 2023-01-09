package pl.wsb.javaprojekt.dziennikocenbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wsb.javaprojekt.dziennikocenbackend.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
