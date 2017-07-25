package com.journaldev.springhibernate.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.springhibernate.dao.PersonDAO;
import com.journaldev.springhibernate.model.Person;

@Service
@ManagedBean(name="personService")
@SessionScoped
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;
	
	private PersonServiceImpl imp ; 
	
	
    @PostConstruct
    @Transactional
    public void init(){
         
    	Person p = new Person() ; 
    	p.setCountry("ALG");
    	p.setName("ALG");
    	p.setId(1);
    	
    	imp.addPerson(p);
    	
    }
    
	 
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
 
    @Override
    @Transactional
    public void addPerson(Person p) {
        this.personDAO.addPerson(p);
    }
 
    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }
 
   
    
}
