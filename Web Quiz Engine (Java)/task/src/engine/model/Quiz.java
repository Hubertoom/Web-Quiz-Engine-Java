package engine.model;

import lombok.Data;

import java.util.List;

@Data
public class Quiz {
    private Long id;
    private String title;
    private String text;
    private List<String> options;
    private int answer;
}