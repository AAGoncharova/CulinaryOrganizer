package co.logic;

import java.util.Collection;

import co.logic.dao.Ingredient;
import co.utilities.HibernateUtil;
import jakarta.persistence.Query;

import org.hibernate.Session;

import co.logic.dao.Cuisine;
import co.logic.dao.Dietary;
import co.logic.dao.DishType;
import co.logic.dao.IngredientType;

public class DatabaseManager {
	
	public static Collection<Ingredient> getAllIngredients() {
		Session s = HibernateUtil.getSessionFactory().openSession();Query query = s.createQuery("SELECT i FROM Ingredient i");
		Collection<Ingredient> result = (Collection<Ingredient>) query.getResultList();
		s.close();
	    return result;
	}
	
	public static Collection<Dietary> getAllDietaryTypes(/*Session session*/) {
		Session s = HibernateUtil.getSessionFactory().openSession();Query query = s.createQuery("SELECT d FROM Dietary d");
		Collection<Dietary> result = (Collection<Dietary>) query.getResultList();
		s.close();
	    return result;
	}
	
	public static Collection<DishType> getAllDishTypes() {
		Session s = HibernateUtil.getSessionFactory().openSession();Query query = s.createQuery("SELECT d FROM DishType d");
		Collection<DishType> result = (Collection<DishType>) query.getResultList();
		s.close();
	    return result;
	}
	
	public static Collection<IngredientType> getAllIngredientTypes() {
		Session s = HibernateUtil.getSessionFactory().openSession();Query query = s.createQuery("SELECT i FROM IngredientType i");
		Collection<IngredientType> result = (Collection<IngredientType>) query.getResultList();
		s.close();
	    return result;
	}
	
	public static Collection<Cuisine> getAllCuisineTypes() {
		Session s = HibernateUtil.getSessionFactory().openSession();Query query = s.createQuery("SELECT c FROM Cuisine c");
		Collection<Cuisine> result = (Collection<Cuisine>) query.getResultList();
		s.close();
	    return result;
	}

	public static IngredientType getIngredientTypeByName(String ingredientName){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Query query = s.createQuery("SELECT c FROM IngredientType c where name = :name");
		query.setParameter("name", ingredientName);
		IngredientType result = (IngredientType) query.getResultList().getFirst();
		s.close();
		return result;
	}

	public static void saveNewIngredient(Ingredient ingredient){
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.persist(ingredient);
		s.getTransaction().commit();
		s.close();
	}
}
