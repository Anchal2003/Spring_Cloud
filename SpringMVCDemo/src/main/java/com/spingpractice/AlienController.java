package com.spingpractice;

import java.awt.PageAttributes.MediaType;
import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spingpractice.model.Alien;
import com.spingpractice.repository.AlienRepo;

@RestController
public class AlienController {

    private final SpringMvcDemoApplication springMvcDemoApplication;

	
	@Autowired
	AlienRepo repo;


    AlienController(SpringMvcDemoApplication springMvcDemoApplication) {
        this.springMvcDemoApplication = springMvcDemoApplication;
    }

	
	@GetMapping(path="aliens",produces = "application/xml")
	public List<Alien> getAliens()
	{
		List<Alien> aliens = repo.findAll();
		return aliens;
	}
	
	@GetMapping("alien/{aid}")
	public Alien getAlien(@PathVariable int aid)
	{	
		Alien a = repo.findById(aid).orElse(null);
		return a;
	}
	
	@PostMapping(path= "alien", consumes = "application/json")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
}
