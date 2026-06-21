![Java](https://img.shields.io/badge/Java-25-blue)
![Quarkus](https://img.shields.io/badge/Quarkus-Latest-red)
![Docker](https://img.shields.io/badge/Docker-ready-blue)

# Cloud Expense Tracker API

A cloud-ready expense management REST API built with Java 25, Quarkus, PostgreSQL and Docker.

This project demonstrates modern backend development practices including REST APIs, validation, layered architecture, containerization and production-oriented design.

---

## Overview

Cloud Expense Tracker allows users to:

- Create expenses
- Retrieve expense history
- Generate expense summaries grouped by category
- Validate incoming requests
- Run locally or inside containers

The goal of this project is to showcase backend engineering skills using the Java + Quarkus ecosystem.

---

## Tech Stack

- Java 25
- Quarkus
- PostgreSQL
- Hibernate ORM Panache
- REST Jackson
- Bean Validation
- Docker
- OpenAPI / Swagger

---

## Architecture

```text
Client
  ↓
REST API (Quarkus)
  ↓
Service Layer
  ↓
Repository Layer
  ↓
PostgreSQL
```

Project structure:

```text
src/

├── dto/
├── entity/
├── repository/
├── resource/
├── service/

Dockerfile
README.md
```

---

## Features

### Create Expense

Register a new expense.

```http
POST /expenses
```

Request:

```json
{
  "description": "AWS monthly invoice",
  "amount": 199.9,
  "category": "cloud"
}
```

Response:

```json
{
  "id": 1,
  "description": "AWS monthly invoice",
  "amount": 199.9,
  "category": "cloud"
}
```

---

### List Expenses

Retrieve all expenses.

```http
GET /expenses
```

---

### Expense Summary

Calculate total expenses by category.

```http
GET /expenses/summary
```

Example:

```json
[
  {
    "category": "cloud",
    "total": 399.8
  }
]
```

---

## Validation

Incoming requests are validated using Bean Validation.

Example validation rules:

- description → required
- amount → must be greater than zero
- category → required

Example invalid request:

```json
{
  "description": "",
  "amount": -50,
  "category": ""
}
```

---

## Run Locally

## Quick Start

```bash
docker compose up --build
```

### Start PostgreSQL

```bash
docker run \
-e POSTGRES_DB=expense \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=postgres \
-p 5432:5432 \
postgres:17
```

---

### Start application

```bash
./mvnw quarkus:dev
```

Application:

```text
http://localhost:8080
```

Swagger UI:

```text
http://localhost:8080/q/swagger-ui
```

---

## Run With Docker

Build image:

```bash
docker build -t expense-api .
```

Run:

```bash
docker run -p 8080:8080 expense-api
```

---

## API Documentation

Swagger UI is automatically exposed by Quarkus.

Access:

```text
http://localhost:8080/q/swagger-ui
```

---

## Future Improvements

- AWS deployment
- CI/CD pipeline
- Infrastructure as Code (Terraform)
- JWT authentication
- Pagination
- Observability
- Integration tests
- Metrics and monitoring

---

## Why this project?

This project was created to demonstrate practical experience with:

- Backend API development
- Clean architecture
- Cloud-native development
- Containerization
- Production-ready Java applications

---

## Author

Felipe Ramos

Backend Developer • Java • Quarkus • AWS

GitHub:
https://github.com/felipecordeiro
