package engine.dto;

import java.util.List;

public record QuizDTO(String title,
                      String text,
                      List<String> options) {
}
