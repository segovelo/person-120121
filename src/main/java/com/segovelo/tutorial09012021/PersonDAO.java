package com.segovelo.tutorial09012021;
import java.util.*;

public interface PersonDAO {
	int insertPerson(UUID id, Person person);
	
		default int insertPerson(Person person) {
			UUID id = UUID.randomUUID();
			return insertPerson(id, person);
		}
		List<Person> selectAllPeople();
		Optional<Person> selectPersonByID(UUID id);
		int deletePersonByID(UUID id);
		int updatePersonByID(UUID id, Person person);
}
