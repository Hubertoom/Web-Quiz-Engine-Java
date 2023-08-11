package engine.servis;

import engine.exceptions.QuizNotFoundException;
import engine.model.Answer;
import engine.repository.QuizCrudRepository;
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
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class QuizService {

    private final QuizCrudRepository quizRepository;

    public QuizDTO createNewQuiz(Quiz quiz) {
        Quiz tempQuiz = quizRepository.save(quiz);
        return Mapper.mapQuizToQuizDTO(tempQuiz);
    }

    public QuizDTO getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(QuizNotFoundException::new);

        return Mapper.mapQuizToQuizDTO(quiz);
    }

    public List<QuizDTO> getQuizzes() {
        return StreamSupport.stream(quizRepository
                        .findAll().spliterator(), false)
                .map(Mapper::mapQuizToQuizDTO)
                .toList();
    }

    public Feedback solveQuizById(Long id, Answer answer) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(QuizNotFoundException::new);

        if (Objects.isNull(quiz.getAnswer()) && Objects.isNull(answer.answer())) {
            System.out.println("jebac");
            return new Feedback(true);
        }
        boolean isAnswerCorrect = new HashSet<>(quiz.getAnswer()).equals(new HashSet<>(answer.answer()));
        return new Feedback(isAnswerCorrect);
    }
}