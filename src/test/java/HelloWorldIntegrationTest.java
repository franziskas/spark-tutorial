import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class HelloWorldIntegrationTest {
	@Test
	public void returns_hello_world() {
		HelloWorld.main(new String[0]);
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 4567;

		String message = given().get("/hello").then().extract().body().asString();

		assertThat(message, is("Hello World"));
	}
}
