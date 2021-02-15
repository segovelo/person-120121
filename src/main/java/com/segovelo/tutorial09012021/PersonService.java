package com.segovelo.tutorial09012021;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private final PersonDAO personDAO;
    @Autowired
	public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) {
		super();
		this.personDAO = personDAO;
	}
	public int addPerson(Person person) {
		return personDAO.insertPerson(person);
	}
	public List<Person> getAllPeople() {
		 return personDAO.selectAllPeople();
	}
    public Optional<Person> getPersonByID(UUID id){
    	return personDAO.selectPersonByID(id);
    }
    public int deletePerson(UUID id) {
    	return personDAO.deletePersonByID(id);
    }
  
    public int updatePerson(UUID id, Person newPerson) {
    	return personDAO.updatePersonByID(id, newPerson);
    }
}
