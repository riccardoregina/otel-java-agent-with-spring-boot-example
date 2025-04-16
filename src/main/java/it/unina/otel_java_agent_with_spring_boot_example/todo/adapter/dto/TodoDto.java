package it.unina.otel_java_agent_with_spring_boot_example.todo.adapter.dto;

import jakarta.validation.constraints.NotBlank;

public record TodoDto(
    @NotBlank
    String name
) {}
