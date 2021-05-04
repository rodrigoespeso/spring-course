package com.respeso.springwebproject;

import javax.persistence.Entity;
import javax.persistence.Id;

// To map ALIEN table to this class
@Entity
public class Alien {

	@Id
	private int aid;
	private String aname;
	private int age;
	
	// Need a default constructor
	public Alien() {}
	
	public Alien(int aid, int age) {
		this.aid = aid;
		this.age = age;
	}

	public Alien(int aid, String aname, int age) {
		this.aid = aid;
		this.aname = aname;
		this.age = age;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int id) {
		this.aid = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", age=" + age + "]";
	}
	
}
