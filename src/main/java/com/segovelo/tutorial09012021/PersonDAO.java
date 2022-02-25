package com.segovelo.tutorial09012021;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {
	public static List<Person> DB = new ArrayList<>();
	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}

	List<Person> selectAllPeople();

	Optional<Person> selectPersonByID(UUID id);

	int deletePersonByID(UUID id);

	int updatePersonByID(UUID id, Person person);

	void display();
}
