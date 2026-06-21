package br.com.felipe.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@QuarkusTest
public class ExpenseResourceTest {

    @Test
    void testCreateExpense() {
        var request = "{\"description\":\"New expense\",\"amount\":100,\"category\":\"Food\"}";
        given()
                .contentType("application/json")
                .body(request)
                .when().post("/expenses")
                .then()
                .statusCode(201);
    }

    @Test
    void testListExpenses() {
        when().get("/expenses")
                .then()
                .statusCode(200);
    }

    @Test
    void testGetExpenseByPageAndSize() {
        var page = "0";
        var size = "10";
        given()
                .when().get("/expenses/?page=" + page + "&size=" + size)
                .then()
                .statusCode(200);
    }

    @Test
    void testSummaryExpenses() {
        when().get("/expenses/summary")
                .then()
                .statusCode(200);
    }

    @Test
    void testInvalidEndpoint() {
        given()
                .when().get("/invalidendpoint")
                .then()
                .statusCode(404);
    }
}
