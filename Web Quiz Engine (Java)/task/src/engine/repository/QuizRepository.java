package engine.repository;

import engine.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository {
    Iterable<Quiz> findAll();

    Optional<Quiz> findById(Long id);

    <S extends Quiz> S save(S entity);
}