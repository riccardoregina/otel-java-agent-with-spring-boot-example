package it.unina.otel_java_agent_with_spring_boot_example.todo.port;

import java.util.List;

import org.springframework.stereotype.Service;

import it.unina.otel_java_agent_with_spring_boot_example.todo.adapter.dto.TodoDto;
import it.unina.otel_java_agent_with_spring_boot_example.todo.model.Todo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class TodoService {
    private TodoRepository todoRepository;

    public Todo addTodo(TodoDto todoDto) {
        log.info("Adding a todo");
        log.debug("todoDto: {}", todoDto.toString());
        return todoRepository.save(new Todo(todoDto.name()));
    }

    public List<Todo> getTodos() {
        log.info("Getting todos");
        return todoRepository.findAll();
    }
}
