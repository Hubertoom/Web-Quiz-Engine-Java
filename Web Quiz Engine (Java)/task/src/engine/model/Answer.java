package engine.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public record Answer(List<Integer> answer) {
    public Answer(List<Integer> answer) {
        if (Objects.isNull(answer)) {
            this.answer = Collections.emptyList();
        } else {
            this.answer = answer;
        }
    }
}
