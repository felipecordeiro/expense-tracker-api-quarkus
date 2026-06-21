package br.com.felipe.repository;

import br.com.felipe.entity.Expense;
import br.com.felipe.service.ExpenseService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@QuarkusTest
public class ExpenseRepositoryTest {

    @Inject
    ExpenseRepository repository;

    @Inject
    ExpenseService service;

    @Test
    @Transactional
    void testCreate() {
        // Create a new expense
        Expense expense = new Expense();
        expense.description = "Test expense";
        expense.amount = BigDecimal.valueOf(100);
        expense.category = "Food";
        expense.createdAt = LocalDateTime.now();

        // Save the expense to the repository
        repository.persist(expense);

        // Check if the expense was saved correctly
        var foundExpense = repository.findById(expense.id);
        assertNotNull(foundExpense, "Expense should be found");
    }

    @Test
    @Transactional
    void testList() {
        // Create some expenses for testing
        Expense expense1 = new Expense();
        expense1.description = "Test expense 1";
        expense1.amount = BigDecimal.valueOf(200);
        expense1.category = "Food";
        expense1.createdAt = LocalDateTime.now();

        Expense expense2 = new Expense();
        expense2.description = "Test expense 2";
        expense2.amount = BigDecimal.valueOf(300);
        expense2.category = "Entertainment";
        expense2.createdAt = LocalDateTime.now();

        // Save the expenses to the repository
        repository.persist(expense1);
        repository.persist(expense2);

        // Retrieve all expenses and check if they are correct
        var foundExpenses = repository.listAll();
        assertEquals(2, foundExpenses.size(), "Expected 2 expenses");
    }

    @Test
    @Transactional
    void testSummary() {
        // Create some expenses for testing
        Expense expense1 = new Expense();
        expense1.description = "Test expense 1";
        expense1.amount = BigDecimal.valueOf(200);
        expense1.category = "Food";
        expense1.createdAt = LocalDateTime.now();

        Expense expense2 = new Expense();
        expense2.description = "Test expense 2";
        expense2.amount = BigDecimal.valueOf(300);
        expense2.category = "Entertainment";
        expense2.createdAt = LocalDateTime.now();

        // Save the expenses to the repository
        repository.persist(expense1);
        repository.persist(expense2);

        // Retrieve the summary and check if it is correct
        var summary = service.summary();
        assertEquals(2, summary.size(), "Expected 2 categories");
    }
}