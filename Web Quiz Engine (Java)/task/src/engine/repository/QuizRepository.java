package engine.repository;

import engine.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository {
    List<Quiz> getQuizzes();

    Optional<Quiz> getQuizById(Long id);

    Quiz createNewQuiz(Quiz quiz);
}