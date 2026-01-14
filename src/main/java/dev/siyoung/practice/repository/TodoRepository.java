package dev.siyoung.practice.repository;

import dev.siyoung.practice.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
