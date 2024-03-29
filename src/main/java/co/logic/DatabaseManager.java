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
	
	/*public static Collection<Ingredient> getAllIngredients() {
		Session s = HibernateUtil.getSessionFactory().openSession();Query query = s.createQuery("SELECT i FROM Ingredient i");
		Collection<Ingredient> result = (Collection<Ingredient>) query.getResultList();
		s.close();
	    return result;
	}
	
	public static Collection<Dietary> getAllDietaryTypes() {
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
	}*/

	/*public static IngredientType getIngredientTypeByName(String ingredientName){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Query query = s.createQuery("SELECT c FROM IngredientType c where name = :name");
		query.setParameter("name", ingredientName);
		IngredientType result = (IngredientType) query.getResultList().getFirst();
		s.close();
		return result;
	}*/

	/*public static void saveNewIngredient(Ingredient ingredient){
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.persist(ingredient);
		s.getTransaction().commit();
		s.close();
	}*/

	/**
	 * Retrieves object from database by property "name", i.e. it should be column 'name' in the corresponding database
	 *
	 * @param objectName
	 * @param objectClass
	 * @return
	 * @param <T>
	 */
	public static <T> T getObjectByName(String objectName, Class<T> objectClass){ //todo: handle exceptions
		Session s = HibernateUtil.getSessionFactory().openSession();
		Query query = s.createQuery("SELECT c FROM " + objectClass.getName() + " c where name = :name");
		query.setParameter("name", objectName);
		T result = objectClass.cast(query.getResultList().getFirst());
		s.close();
		return result;
	}

	/**
	 * Saves the object into database.
	 *
	 * @param objectToSave
	 * @param <T>
	 */
	public static <T> void saveObjectToDB(T objectToSave){ //todo: handle exceptions
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		s.persist(objectToSave);
		s.getTransaction().commit();
		s.close();
	}

	/**
	 * Retrieves all data from the database that corresponds to object class.
	 *
	 * @param objectClass
	 * @return
	 * @param <T>
	 */
	public static <T> Collection<T> getAllElementsOfTypeFromDB(Class<T> objectClass) { //todo: handle exceptions
		Session s = HibernateUtil.getSessionFactory().openSession();Query query = s.createQuery("SELECT c FROM " + objectClass.getName() + " c");
		Collection<T> result = (Collection<T>) query.getResultList();
		s.close();
		return result;
	}
}
