package com.sripiranavan.java.maven;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sripiranavan.java.maven.model.Alien;

public class JpaDemo {

	public static void main(String[] args) {
		Alien alien = new Alien();
		alien.setAid(4);
		alien.setAname("Indirani");
		alien.setTech("Python");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();

//		Alien alien = em.find(Alien.class, 2);
//		System.out.println(alien);

		em.getTransaction().begin();
		em.persist(alien);
		em.getTransaction().commit();
		System.out.println("Done");
	}

}
