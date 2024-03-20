package co;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.hibernate.*;

import co.logic.DatabaseManager;
import co.logic.dao.*;

import co.utilities.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.build.AllowSysOut;


public class Main {
    public static void main(String[] args) {

        System.out.println("Program started");

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("culinary-organizer");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();*/

        //SessionFactoryImplementor sfi = (SessionFactoryImplementor)HibernateUtil.getSessionFactory();
        //String name = sfi.getProperties(). Settings().getDefaultSchemaName();

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();

        /*Query query = s.createQuery("from IngredientType where name = :typeName");
        query.setParameter("typeName", "мясо");
        IngredientType ingredientType = (IngredientType)query.getResultList().getFirst();
        Query queryCuisine = s.createQuery("from Cuisine where name = :cuisineName");
        queryCuisine.setParameter("cuisineName", "русская");
        Query queryDietary = s.createQuery("from Dietary where name = :dietaryName");
        queryDietary.setParameter("dietaryName", "общая кухня");
        Query queryDishType = s.createQuery("from DishType where name = :dishTypeName");
        queryDishType.setParameter("dishTypeName", "суп");*/
        //query.getResultStream().forEach(System.out::println);

        /*Query queryCuisine = s.createQuery("from Cuisine");
        Query queryDietary = s.createQuery("from Dietary");
        Query queryDishType = s.createQuery("from DishType");*/

        /*Query queryIngredient = s.createQuery("from Ingredient");
        Query queryRecipe = s.createQuery("from Recipe");*/

        Query query = s.createQuery("from IngredientType");
        IngredientType ingredientType = (IngredientType)query.getResultList().getFirst();

        /*Cuisine c = new Cuisine("new cuisine");
        Dietary d = new Dietary("new dietary");
        DishType dt = new DishType("dish type");*/

        List<Cuisine> cuisineList = new ArrayList<Cuisine>();
        List<Dietary> dietaryList = new ArrayList<Dietary>();
        List<DishType> dishTypeList = new ArrayList<DishType>();

        /*cuisineList.add(c);
        dietaryList.add(d);
        dishTypeList.add(dt);*/
        /*queryCuisine.getResultList().add(c);
        queryDishType.getResultList().add(dt);
        queryDietary.getResultList().add(d);*/

        /*Recipe recipe = new Recipe();
        recipe.setName("борщ");
        recipe.setPreparation("Сварить борщ");
        /*recipe.setRecipeCuisineList(cuisineList);
        recipe.setRecipeDishTypeList(dishTypeList);
        recipe.setRecipeDietaryList(dietaryList);*/

        /*Recipe recipe = (Recipe)queryRecipe.getResultList().getFirst();
        Ingredient ingredient = (Ingredient) queryIngredient.getResultList().getFirst();*/

        Recipe recipe = new Recipe();
        recipe.setName("soup");
        recipe.setPreparation("prepare soup");
        recipe.setRecipeCuisineList(cuisineList);
        recipe.setRecipeDishTypeList(dishTypeList);
        recipe.setRecipeDietaryList(dietaryList);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("new ingredient");
        ingredient.setCalorificValue(100);
        ingredient.setDescription("description");
        ingredient.setIngredientType(ingredientType);

        s.persist(recipe);
        s.persist(ingredient);

        RecipeIngredient ri = new RecipeIngredient(500, "gr", recipe, ingredient);

        //IngredientType ingredientType = new IngredientType("рыба");
        /*recipe.setRecipeCuisineList(queryCuisine.getResultList());
        recipe.setRecipeDishTypeList(queryDishType.getResultList());
        recipe.setRecipeDietaryList(queryDietary.getResultList());*/
        //IngredientType ingredientType = new IngredientType("рыба");

        /*Cuisine c = (Cuisine)queryCuisine.getResultList().getFirst();
        Dietary d = (Dietary)queryDietary.getResultList().getFirst();
        DishType dt = (DishType) queryDishType.getResultList().getFirst();

        List<Recipe> recipeList = new ArrayList<Recipe>();
        recipeList.add(recipe);

        c.setRecipes(recipeList);
        d.setRecipes(recipeList);
        dt.setRecipes(recipeList);*/

        /*recipe.getRecipeCuisineList().add(c);
        recipe.getRecipeDietaryList().add(d);
        recipe.getRecipeDishTypeList().add(dt);*/

        /*em.persist(ingredientType);
        System.out.println("Persist: New ingredient name = %s, id = " + ingredientType.getId());
        em.getTransaction().commit();
        em.close();*/

        /*s.persist(recipe);
        s.persist(c);
        s.persist(d);
        s.persist(dt);*/
        s.persist(ri);

        //System.out.println("Persist: New ingredient name = " + ingredientType.getName() + ", id = " + ingredientType.getId());

        //String name = ingredient.getName();
        //System.out.println("Persist: New ingredient name = " + ingredientType.getName() + ", id = " + ingredientType.getId());

        //s.flush();
        //System.out.println("Flush: New ingredient name = " + ingredientType.getName() + ", id = " + ingredientType.getId());

        s.getTransaction().commit();
        //System.out.println("Commit: New ingredient name = " + ingredientType.getName() + ", id = " + ingredientType.getId());

        s.close();



        /*Dietary d = new Dietary();
        d.setName("vegan");
        s.persist(d);
        s.flush();*/





        //System.out.println("Program started");

        /*DatabaseManager dm = new DatabaseManager();
        List<Dietary> dList = new ArrayList<Dietary>(dm.getAllDietaryTypes(s));

        for(Dietary dd : dList){
            System.out.println("Dietary id: " + dd.getId() + ", name: " + dd.getName());
        }*/

        /*for(Iterator<Dietary> i = dList.listIterator(); i.hasNext();) {
            Dietary d = i.next();
            System.out.println("Dietary id: " + d.getId() + ", name: " + d.getName());
        }*/

        //s.close();
        /*em.getTransaction().begin();
        Dietary d = new Dietary();
        d.setName("vegan");
        em.persist(d);
        em.getTransaction().commit();
        //em.close();
        System.out.println("Created: id: " + String.valueOf(d.getId()) + ", name: " + d.getName());

        //em = emf.createEntityManager();
        Dietary retrieved = em.find(Dietary.class, 1);
        if(retrieved != null)
            System.out.println("Retrieved: id: " + String.valueOf(retrieved.getId()) + ", name: " + retrieved.getName());
        else
            System.out.println("Retrieved: null");*/


        //em.close();
        System.out.println("Program finished");



		/*Ingredient i = new Ingredient.Builder("a", null).decription("desc").build();
		System.out.println("Create: id: " + String.valueOf(i.getId()) + ", decription: " + i.getDescription());
		Ingredient i2 = new Ingredient.Builder("a", null).decription("desc").build();
		System.out.println("Create2: id: " + String.valueOf(i2.getId()) + ", decription: " + i2.getDescription());
		i2.setDecrption("dec_new");
		System.out.println("Update: id: " + String.valueOf(i2.getId()) + ", decription: " + i2.getDescription());*/

        String str;



        ////////////////emf.close();
    }
}