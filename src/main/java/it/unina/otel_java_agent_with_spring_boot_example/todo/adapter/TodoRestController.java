package it.unina.otel_java_agent_with_spring_boot_example.todo.adapter;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unina.otel_java_agent_with_spring_boot_example.todo.adapter.dto.TodoDto;
import it.unina.otel_java_agent_with_spring_boot_example.todo.model.Todo;
import it.unina.otel_java_agent_with_spring_boot_example.todo.port.TodoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/todos")
@AllArgsConstructor
public class TodoRestController {
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(todoService.addTodo(todoDto));
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(todoService.getTodos());
    }
}
