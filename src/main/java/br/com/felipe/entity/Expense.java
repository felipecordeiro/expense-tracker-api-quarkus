package br.com.felipe.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Expense extends PanacheEntity {

    public String description;

    public BigDecimal amount;

    public String category;

    public LocalDateTime createdAt;
}