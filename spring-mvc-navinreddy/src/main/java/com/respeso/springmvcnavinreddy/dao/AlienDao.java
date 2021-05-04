package com.respeso.springmvcnavinreddy.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.respeso.springmvcnavinreddy.model.Alien;

@Component
public class AlienDao {
	
	/*
	 * Get the bean defined in the dispatcherServlet.xml
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional // equivalent to init/end transaction bunchs of code
	public List<Alien> getAliens(){
		// init transaction code -  no need with Spring
		Session s = sessionFactory.getCurrentSession();		
		return s.createQuery("from Alien", Alien.class).list();
		// end transaction code - no need with Spring
	}

	@Transactional
	public void addAlien(Alien a) {
		Session s = sessionFactory.getCurrentSession();		
		s.save(a);
	}
	
	@Transactional
	public Alien getAlien(int aid) {
		Session s = sessionFactory.getCurrentSession();	
		Alien a = s.get(Alien.class, aid);
		return a;
	}
}
