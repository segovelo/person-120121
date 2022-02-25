package com.segovelo.tutorial09012021;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private final PersonDAO personDAO;
	private final PersonDAO youngPersonDAO;
    @Autowired
	public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO, @Qualifier("youngDAO") PersonDAO youngPersonDAO) {
		super();
		this.personDAO = personDAO;
		this.youngPersonDAO = youngPersonDAO;
	}
	public int addPerson(Person person) {
		if(person.getAge()<30)
			return youngPersonDAO.insertPerson(person);
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
