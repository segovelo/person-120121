package com.segovelo.tutorial09012021;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Persona {

		private final UUID id;
		private final String name;
		public Persona(@JsonProperty("id") UUID id, 
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
