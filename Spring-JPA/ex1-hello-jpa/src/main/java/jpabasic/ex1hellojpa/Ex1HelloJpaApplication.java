package jpabasic.ex1hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex1HelloJpaApplication {

	public static void main(String[] args) {

		EntityManagerFactory em = Persistence.createEntityManagerFactory("hello");
		EntityManager entityManager = em.createEntityManager();



		entityManager.clear();
		em.close();
	}

}
