package engine.controller;

import engine.servis.QuizService;
import engine.dto.QuizDTO;
import engine.model.Feedback;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public ResponseEntity<QuizDTO> getQuestion() {
        return ResponseEntity.ok(quizService.getQuestion());
    }

    @PostMapping
    public ResponseEntity<Feedback> getAnswer(@RequestParam Long answer) {
        return ResponseEntity.ok(quizService.getFeedback(answer));
    }

}
