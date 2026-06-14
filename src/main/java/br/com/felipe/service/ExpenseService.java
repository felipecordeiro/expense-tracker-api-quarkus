package br.com.felipe.service;

import br.com.felipe.dto.CreateExpenseRequest;
import br.com.felipe.dto.ExpenseSummaryResponse;
import br.com.felipe.entity.Expense;
import br.com.felipe.repository.ExpenseRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class ExpenseService {

        @Inject
        ExpenseRepository repository;

        @Transactional
        public Expense create(
                        CreateExpenseRequest request) {

                Expense expense = new Expense();

                expense.description = request.description();

                expense.amount = request.amount();

                expense.category = request.category();

                expense.createdAt = LocalDateTime.now();

                repository.persist(expense);

                return expense;
        }

        public List<Expense> list() {
                return repository.listAll();
        }

        public List<ExpenseSummaryResponse> summary() {

                Map<String, List<Expense>> grouped = repository.listAll()
                                .stream()
                                .collect(
                                                Collectors.groupingBy(
                                                                e -> e.category));

                return grouped.entrySet()
                                .stream()
                                .map(entry -> {

                                        var total = entry.getValue()
                                                        .stream()
                                                        .map(
                                                                        e -> e.amount)
                                                        .reduce(
                                                                        java.math.BigDecimal.ZERO,
                                                                        java.math.BigDecimal::add);

                                        return new ExpenseSummaryResponse(
                                                        entry.getKey(),
                                                        total);

                                })
                                .toList();

        }

}