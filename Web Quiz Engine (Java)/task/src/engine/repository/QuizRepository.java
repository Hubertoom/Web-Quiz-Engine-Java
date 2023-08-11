package engine.repository;

import engine.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository {
    List<Quiz> getQuizList();
}
