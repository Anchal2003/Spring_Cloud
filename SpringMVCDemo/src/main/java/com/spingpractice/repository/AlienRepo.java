package com.spingpractice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spingpractice.model.Alien;

@Component
@Repository
public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
	List<Alien> findByAname(String aname);//Query DSL
	
	@Query("from Alien where aname = :name")
	List<Alien> find(@Param("name") String aname);

}
