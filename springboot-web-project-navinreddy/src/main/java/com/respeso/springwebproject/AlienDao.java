package com.respeso.springwebproject;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlienDao {
	
	/*
	 * Get the bean defined in the dispatcherServlet.xml - Not defined in Spring Boot I guess
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Even if we got no defined class implemetation of this AlienRepo, Spring Data
	 * take cares of the injection
	 */
	@Autowired
	private AlienRepo repo;
	
	@Transactional // equivalent to init/end transaction bunchs of code
	public List<Alien> getAliens(){
		
		// init transaction code -  no need with Spring
		/*
		 * Produces error: org.hibernate.HibernateException: No CurrentSessionContext
		 * configured! because is not configured with Spring Boot I guess. We have to use Repository interfaces
		 */
//		Session s = sessionFactory.getCurrentSession();	
//		return s.createQuery("from Alien", Alien.class).list();
		// end transaction code - no need with Spring
		
		return repo.findAll();
	}

//	@Transactional
	public void addAlien(Alien a) {
//		Session s = sessionFactory.getCurrentSession();		
//		s.save(a);
		repo.save(a);
	}
	
//	@Transactional
//	public Alien getAlien(int aid) {
//		Session s = sessionFactory.getCurrentSession();	
//		Alien a = s.get(Alien.class, aid);
//		return a;
//	}

	public Object getAlien(int aid) {
		// TODO Auto-generated method stub
		return repo.getOne(aid);
	}
}
