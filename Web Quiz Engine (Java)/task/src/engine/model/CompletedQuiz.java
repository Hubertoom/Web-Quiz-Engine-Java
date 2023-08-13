package engine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CompletedQuiz")
@Table(name = "completed_quiz")
public class CompletedQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date completedAt;

    public CompletedQuiz(Quiz quiz, AppUser user, Date completedAt) {
        this.quiz = quiz;
        this.user = user;
        this.completedAt = completedAt;
    }
}

