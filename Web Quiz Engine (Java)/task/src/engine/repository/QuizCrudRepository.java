package engine.repository;

import engine.model.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizCrudRepository extends CrudRepository<Quiz, Long> {
}
