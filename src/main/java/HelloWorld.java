import static java.util.Arrays.asList;
import static spark.Spark.get;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HelloWorld {
	public static void main(String[] args) {

		get("hello", (req, res) -> "Hello World");
		get("greeting/parameterised", (req, res) -> {
			String name = req.queryParams("name");
			String age = req.queryParams("age");
			res.type("application/json");
			return new HelloWorldResponse(name, age,
					asList(new Greeting("2016-01-01", "hello"), new Greeting("2016-01-02", "bonjour")));
		}, model -> new ObjectMapper().writeValueAsString(model));
	}
}
