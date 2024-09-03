package com.kgisl.springboot.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.springboot.entity.Person;
import com.kgisl.springboot.service.PersonService;

@RequestMapping("/person")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> person = personService.getAllPersons();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        //return ResponseEntity.ok(person, HttpStatus.OK);
    }

    // @PutMapping("/update/{id}")
    // public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody Person person) {
    //     personRepository.save(person);
    //     return new ResponseEntity<>("Updated Successfully", HttpStatus.ACCEPTED);
    // }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person){
        personService.updatePerson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // @GetMapping("/getById/{id}")
    // public Optional<Person> getPerson(@PathVariable Long id) {
    //     return personRepository.findById(id);
    // }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        Person person = personService.getPerson(id);
        return new ResponseEntity<>(person, person !=null? HttpStatus.OK: HttpStatus.NOT_FOUND);
        
    }
    // @PostMapping("/post")
    // public ResponseEntity<Person> insertPerson(@RequestBody Person person) {
    //     personRepository.save(person);
    //     return new ResponseEntity<>(person, HttpStatus.CREATED);
    // }

    @PostMapping("/post")
    public ResponseEntity<Person> insertPerson(@RequestBody Person person){
        personService.insertPerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
