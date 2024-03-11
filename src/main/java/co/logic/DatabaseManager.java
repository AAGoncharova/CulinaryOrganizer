package co.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/*import co.logic.core.dao.Cuisine;*/
import co.logic.dao.Dietary;
/*import co.logic.core.dao.DishType;
import co.logic.core.dao.Ingredient;
import co.logic.core.dao.IngredientType;*/

public class DatabaseManager {
	
	/*public static Collection<Ingredient> getAllIngredients() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CulinaryOrganizer");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT i FROM Ingredient i");
		Collection<Ingredient> result = (Collection<Ingredient>) query.getResultList();
		em.close();
		emf.close();
	    return result;
	}*/
	
	public static Collection<Dietary> getAllDietaryTypes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("culinary-organizer");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT d FROM Dietary d");
		Collection<Dietary> result = (Collection<Dietary>) query.getResultList();
		em.close();
		emf.close();
	    return result;
	}
	
	/*public static Collection<DishType> getAllDishTypes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CulinaryOrganizer");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT d FROM DishType d");
		Collection<DishType> result = (Collection<DishType>) query.getResultList();
		em.close();
		emf.close();
	    return result;
	}
	
	public static Collection<IngredientType> getAllIngredientTypes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CulinaryOrganizer");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT i FROM IngredientType i");
		Collection<IngredientType> result = (Collection<IngredientType>) query.getResultList();
		em.close();
		emf.close();
	    return result;
	}
	
	public static Collection<Cuisine> getAllCuisineTypes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CulinaryOrganizer");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("SELECT c FROM Cuisine c");
		Collection<Cuisine> result = (Collection<Cuisine>) query.getResultList();
		em.close();
		emf.close();
	    return result;
	}*/
}
