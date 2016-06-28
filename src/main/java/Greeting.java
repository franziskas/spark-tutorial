import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting {
	private String day;
	private String greeting;

	@JsonCreator
	public Greeting(@JsonProperty("day") String day, @JsonProperty("greeting") String greeting) {
		this.day = day;
		this.greeting = greeting;
	}

	public String getDay() {
		return day;
	}

	public String getGreeting() {
		return greeting;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Greeting greeting1 = (Greeting) o;
		return Objects.equals(day, greeting1.day) && Objects.equals(greeting, greeting1.greeting);
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, greeting);
	}
}
