package engine.servis;

import engine.repository.QuizRepository;
import engine.model.Quiz;
import engine.dto.Mapper;
import engine.dto.QuizDTO;
import engine.model.Feedback;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizDTO getQuestion() {
        Quiz quiz = quizRepository.getQuizList().get(0);
        return Mapper.mapQuizToQuizDTO(quiz);
    }

    public Feedback getFeedback(Long answer) {
        return answer == 2 ? new Feedback(true, "Congratulations, you're right!")
                : new Feedback(false, "Wrong answer! Please, try again.");
    }
}
