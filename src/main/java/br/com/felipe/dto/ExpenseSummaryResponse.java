package br.com.felipe.dto;

import java.math.BigDecimal;

public record ExpenseSummaryResponse(
        String category,
        BigDecimal total) {
}