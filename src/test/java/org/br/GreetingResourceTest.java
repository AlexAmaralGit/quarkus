package org.br;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class GreetingResourceTest {
	  
    @Inject
    Teste teste;

    @BeforeAll
    public static void setup() {
    	Teste mock = Mockito.mock(Teste.class);
        Mockito.when(mock.retornaString()).thenReturn("Mock com Sucesso");
        QuarkusMock.installMockForType(mock, Teste.class);  
    }
	
    @Test
    public void testHelloEndpoint() {
    	given()
          .when()
             .get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));   
    } 
}