package engine.dto;

import java.util.List;

public record QuizDTO(
        Long id,
        String title,
        String text,
        List<String> options) {
}