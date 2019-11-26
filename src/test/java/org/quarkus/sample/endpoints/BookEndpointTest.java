package org.quarkus.sample.endpoints;

import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.quarkus.sample.domain.Book;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class BookEndpointTest {

    private final String apiPath = "/api/v1";

    @Test
    public void listAllBookEndpoint() {
        given()
          .when().get(apiPath + "/books")
          .then()
             .statusCode(200)
             .body(notNullValue());
    }

    @Test
    public void findByIdEndpoint() {
        Book book = new Book();
        book.setId(4L);
        book.setName("book5");

        given().body(book)
                .when().get(apiPath + "/book/{id}", book.getId())
                .then().statusCode(200)
                        .body("id", equalTo(Long.valueOf(book.getId()).intValue()))
                        .body("name", equalTo(book.getName()));
    }


}