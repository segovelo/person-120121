package com.segovelo.tutorial09012021;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import com.fasterxml.jackson.annotation.JsonProperty;
@Validated
public class Person {

		private final UUID id;
		@NotBlank
		private final String name;
		public Person(@JsonProperty("id") UUID id, 
				      @JsonProperty("name") String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public UUID getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		
}