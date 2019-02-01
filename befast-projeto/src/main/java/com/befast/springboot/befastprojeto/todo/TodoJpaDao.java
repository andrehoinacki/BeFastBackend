package com.befast.springboot.befastprojeto.todo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.xml.bind.v2.TODO;

public class TodoJpaDao {

	protected EntityManager entityManager;

	TodoJpaDao() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public List<Todo> findAllByUser(String username) {
		return entityManager.createQuery("FROM Todo WHERE username = '" + username + "'", Todo.class).getResultList();
	}

	public Todo findById(long id) {
		return entityManager.createQuery("SELECT t FROM Todo t WHERE t.id = " + id, Todo.class).getSingleResult();
			
	}

	public Todo deleteById(long id) {
		Todo todo= new Todo();
		try {
            todo = findById(id);
            remove(todo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return todo;
	}

	public Todo save(Todo todo) {
		try {
			persist(todo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return todo;
	}
	
	public Todo edit(Todo todo) {
		try {
			merge(todo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return todo;
	}

	public void persist(Todo todo) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(todo);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Todo todo) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(todo);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Todo todo) {
		try {
			entityManager.getTransaction().begin();
			todo = entityManager.find(Todo.class, todo.getId());
			entityManager.remove(todo);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

}