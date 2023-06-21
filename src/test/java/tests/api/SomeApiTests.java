package tests.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class SomeApiTests {
    @Test
    public void checkStatusCodeAndBody() {
        given().
                when().
                get("https://gosbi.com.ua").
                then().
                assertThat().
                statusCode(200).
                body(containsString("Каталог продукції"));
    }

}
