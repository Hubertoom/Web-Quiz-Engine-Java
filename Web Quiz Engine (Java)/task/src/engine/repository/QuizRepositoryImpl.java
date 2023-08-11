package engine.repository;

import engine.model.Quiz;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuizRepositoryImpl implements QuizRepository {

    private final List<Quiz> quizList = new ArrayList<>();

    public QuizRepositoryImpl() {
        Quiz quiz = new Quiz();
        quiz.setTitle("The Java Logo");
        quiz.setText("What is depicted on the Java logo?");
        quiz.setOptions(List.of("Robot", "Tea leaf", "Cup of coffee", "Bug"));
        quiz.setCorrectAnswer(2);

        quizList.add(quiz);
    }

    @Override
    public List<Quiz> getQuizList() {
        return quizList;
    }
}
