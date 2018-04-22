package at.refugeescode.mylisttodo.persistence;

import at.refugeescode.mylisttodo.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface Repository extends MongoRepository<Todo, String> {
    List<Todo> findAll();

    boolean existsById(String id);

    Optional<Todo> findById(String id);
}
