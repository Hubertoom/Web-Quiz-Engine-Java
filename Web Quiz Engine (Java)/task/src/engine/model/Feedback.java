package engine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public final class Feedback {
    private Boolean success;
    private String feedback;

    public Feedback(Boolean success) {
        this.success = success;
        this.feedback = success ? "Congratulations, you're right!"
                                : "Wrong answer! Please, try again.";
    }
}