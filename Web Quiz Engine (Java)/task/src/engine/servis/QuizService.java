package engine.servis;

import engine.exceptions.NotOwnerException;
import engine.exceptions.QuizNotFoundException;
import engine.model.Answer;
import engine.model.AppUser;
import engine.repository.QuizCrudRepository;
import engine.repository.QuizRepository;
import engine.model.Quiz;
import engine.dto.Mapper;
import engine.dto.QuizDTO;
import engine.model.Feedback;
import engine.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class QuizService {

    private final QuizCrudRepository quizRepository;
    private final UserRepository userRepository;

    public QuizDTO createNewQuiz(Quiz quiz) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = userRepository.findAppUserByUsername(auth.getName()).get();
        user.addQuiz(quiz);
        quiz.setUser(user);
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

        boolean isAnswerCorrect = new HashSet<>(quiz.getAnswer()).equals(new HashSet<>(answer.answer()));
        return new Feedback(isAnswerCorrect);
    }

    public void deleteQuizById(Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(QuizNotFoundException::new);

        if (!auth.getName().equals(quiz.getUser().getUsername())) {
            throw new NotOwnerException();
        }

        quizRepository.delete(quiz);
    }
}