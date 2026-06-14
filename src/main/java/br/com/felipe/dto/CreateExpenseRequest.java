package br.com.felipe.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateExpenseRequest(
                @NotBlank String description,

                @NotNull @Positive BigDecimal amount,

                @NotBlank String category) {
}
