package com.ajinkyacodes.expense_tracker.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "ErrorDetails DTO (Data Transfer Object) to transfer error response data between Client and Server."
)
@Getter
@Setter
public class ErrorDetails {
    @Schema(
            description = "Error Occurred Date Time"
    )
    private LocalDateTime timestamp;

    @Schema(
            description = "Error Message"
    )
    private String message;

    @Schema(
            description = "Error Details"
    )
    private String details;

    @Schema(
            description = "Error Code"
    )
    private String errorCode;
}
