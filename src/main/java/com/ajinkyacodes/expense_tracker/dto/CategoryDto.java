package com.ajinkyacodes.expense_tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category DTO (Data Transfer Object) to transfer data between Client and Server."
)
public record CategoryDto(Long id, @Schema(description = "Category Name") String name) {
}
