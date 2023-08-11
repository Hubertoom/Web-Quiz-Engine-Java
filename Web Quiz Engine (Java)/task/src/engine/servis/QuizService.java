package engine.servis;

import engine.exceptions.QuizNotFoundException;
import engine.model.Answer;
import engine.repository.QuizRepository;
import engine.model.Quiz;
import engine.dto.Mapper;
import engine.dto.QuizDTO;
import engine.model.Feedback;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizDTO createNewQuiz(Quiz quiz) {
        Quiz tempQuiz = quizRepository.createNewQuiz(quiz);
        return Mapper.mapQuizToQuizDTO(tempQuiz);
    }

    public QuizDTO getQuizById(Long id) {
        Quiz quiz = quizRepository.getQuizById(id)
                .orElseThrow(QuizNotFoundException::new);

        return Mapper.mapQuizToQuizDTO(quiz);
    }

    public List<QuizDTO> getQuizzes() {
        return quizRepository.getQuizzes()
                .stream().map(Mapper::mapQuizToQuizDTO)
                .toList();
    }

    public Feedback solveQuizById(Long id, Answer answer) {
        Quiz quiz = quizRepository.getQuizById(id)
                .orElseThrow(QuizNotFoundException::new);

        if (Objects.isNull(quiz.getAnswer()) && Objects.isNull(answer.answer())) {
            System.out.println("jebac");
            return new Feedback(true);
        }
        boolean isAnswerCorrect = new HashSet<>(quiz.getAnswer()).equals(new HashSet<>(answer.answer()));
        return new Feedback(isAnswerCorrect);
    }
}