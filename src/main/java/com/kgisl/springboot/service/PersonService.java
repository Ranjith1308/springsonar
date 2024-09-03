package com.kgisl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.springboot.Repository.PersonRepository;
import com.kgisl.springboot.entity.Person;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);

    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);

    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person insertPerson(Person person) {
        return personRepository.save(person);
    }

}
