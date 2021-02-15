package com.segovelo.tutorial09012021;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v1/person")
@RestController

public class PersonController {
	private final PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	@PostMapping
	public void addPerson(@Valid @NonNull @RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping
	public List<Person> getAllPeople(){
		return personService.getAllPeople();
	}
	
	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		return personService.getPersonByID(id)
				 .orElse( null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deletePersonByID(@PathVariable("id") UUID id) {
		personService.deletePerson(id);
	}
	
	@PutMapping(path = "{id}")
	public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate) {
		personService.updatePerson(id, personToUpdate);
	}
}
