import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldResponse {
	private String name;
	private String age;
	private List<Greeting> greetings = new ArrayList<>();

	@JsonCreator
	public HelloWorldResponse(@JsonProperty("name") String name, @JsonProperty("age") String age,
			@JsonProperty("greetings") List<Greeting> greetings) {
		this.name = name;
		this.age = age;
		this.greetings = greetings;
	}

	public String getAge() {
		return age;
	}

	public List<Greeting> getGreetings() {
		return greetings;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		HelloWorldResponse that = (HelloWorldResponse) o;
		return Objects.equals(name, that.name) && Objects.equals(age, that.age)
				&& Objects.equals(greetings, that.greetings);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, greetings);
	}
}
