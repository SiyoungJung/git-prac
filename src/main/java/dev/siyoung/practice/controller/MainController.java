package dev.siyoung.practice.controller;

import dev.siyoung.practice.entity.Todo;
import dev.siyoung.practice.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final TodoService todoService;

    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create () {
        return "create";
    }

    @PostMapping("/todos")
    public String createTodo (@RequestParam String name, @RequestParam String state, @RequestParam String deadLine) {
        Todo todo = new Todo(null, name, state, LocalDateTime.parse(deadLine));
        todoService.create(todo);
        return "redirect:/";
    }
    // 수정
    @PostMapping("/todos/state")
    public String updateState (@RequestParam Long id, @RequestParam String state) {
        todoService.updateState(id, state);
        return "redirect:/";
    }
    // 삭제
    @PostMapping("/todos/delete")
    public String deleteTodo (@RequestParam Long id) {
        todoService.delete(id);
        return "redirect:/";
    }
}
