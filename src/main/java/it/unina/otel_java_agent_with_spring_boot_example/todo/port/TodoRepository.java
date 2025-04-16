package it.unina.otel_java_agent_with_spring_boot_example.todo.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unina.otel_java_agent_with_spring_boot_example.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {
    
}
