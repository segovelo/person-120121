package com.segovelo.tutorial09012021;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDAO {
	
	@Override
	public int insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName(), person.getAge(), this.getClass().toString()));
		return 1;
	}
	@Override
	public List<Person> selectAllPeople(){
		return DB;
	}
    @Override
    public Optional<Person> selectPersonByID(UUID id){
    	return DB.stream()
    			.filter(person -> person.getId().equals(id))
    			.findFirst();
    }
    @Override
    public int deletePersonByID(UUID id) {
    	Optional<Person> personMaybe = selectPersonByID(id);
    	if(personMaybe.isEmpty()) return 0;
    	DB.remove(personMaybe.get());
    	return 1;
    }
    
    @Override
    public int updatePersonByID(UUID id, Person updatePerson) {
    	return selectPersonByID(id)
    			.map(person -> {
    				  int indexOfPersonToUpdate = DB.indexOf(person);
    				  if(indexOfPersonToUpdate >= 0) {
    					  DB.set(indexOfPersonToUpdate, new Person(id, updatePerson.getName(), updatePerson.getAge(), this.getClass().toString()));
    					  return 1;
    				  }
    				  return 0;
    			})
    			.orElse(0);
    }
    
    @Override
    public void display() {
    	System.out.println("This is "+ this.getClass().toString());
    }
}
