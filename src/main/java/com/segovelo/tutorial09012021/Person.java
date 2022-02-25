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
		private final int age;
		private final String service;

		public Person(@JsonProperty("id") UUID id, 
				      @JsonProperty("name") String name, @JsonProperty("age") int age, String service) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.service = service;
		}
		public UUID getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public String getService() {
			return service;
		}
		
}