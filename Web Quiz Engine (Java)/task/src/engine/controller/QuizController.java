package engine.controller;

import engine.model.Answer;
import engine.model.Quiz;
import engine.servis.QuizService;
import engine.dto.QuizDTO;
import engine.model.Feedback;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/quizzes")
    public ResponseEntity<QuizDTO> createNewQuiz(@Valid @RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.createNewQuiz(quiz));
    }

    @GetMapping("/quizzes/{id}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @GetMapping("/quizzes")
    public ResponseEntity<List<QuizDTO>> getQuizzes() {
        return ResponseEntity.ok(quizService.getQuizzes());
    }

    @PostMapping("/quizzes/{id}/solve")
    public ResponseEntity<Feedback> solveQuizById(@PathVariable Long id, @Valid @RequestBody(required = false) Answer answer) {
        return ResponseEntity.ok(quizService.solveQuizById(id, answer));
    }

    @DeleteMapping("quizzes/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuizById(id);
        return ResponseEntity.noContent().build();
    }
}





















