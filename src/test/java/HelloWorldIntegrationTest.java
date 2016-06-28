import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
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

	@Test
	public void returns_parameterised_greeting() throws IOException {
		HelloWorldResponse response = expect().given().contentType(JSON)
				.get("/greeting/parameterised?name=Franziska&age=99").as(HelloWorldResponse.class);

		HelloWorldResponse expectedResponse = getResponseFromFile("/helloWorldResponse.json", HelloWorldResponse.class);

		assertThat(response, is(expectedResponse));
	}

	private <T> T getResponseFromFile(String filename, Class<T> responseClass) throws IOException {
		return new ObjectMapper().readValue(getClass().getResourceAsStream(filename), responseClass);
	}
}
