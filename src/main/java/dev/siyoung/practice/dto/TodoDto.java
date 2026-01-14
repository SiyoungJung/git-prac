package dev.siyoung.practice.dto;

import dev.siyoung.practice.entity.Todo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoDto {
    private Long id;
    private String name;
    private String state;
    private LocalDateTime deadLine;

    public Todo toEntity (Todo todo) {
        return new Todo(null, name, state, deadLine);
    }
}
