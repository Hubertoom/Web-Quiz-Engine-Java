package engine.dto;

import engine.model.Quiz;

public class Mapper {

    public static QuizDTO mapQuizToQuizDTO(Quiz quiz) {
        return new QuizDTO(quiz.getId(), quiz.getTitle(), quiz.getText(), quiz.getOptions());
    }
}
