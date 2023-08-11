package engine.repository;

import engine.model.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizCrudRepository extends CrudRepository<Quiz, Long> {
}
