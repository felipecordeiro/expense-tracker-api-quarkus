package br.com.felipe.repository;

import br.com.felipe.entity.Expense;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExpenseRepository
        implements PanacheRepository<Expense> {

}