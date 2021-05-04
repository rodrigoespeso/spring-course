package com.respeso.springwebproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlienRepo extends JpaRepository<Alien, Integer>{

}
