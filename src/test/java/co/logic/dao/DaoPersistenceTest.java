package co.logic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DaoPersistenceTest {

    private static SessionFactory sessionFactory;
    private static Session session;
    private static IngredientType ingredientType;
    private static Ingredient ingredient;
    private static RecipeIngredient recipeIngredient;
    private static Cuisine cuisine;
    private static DishType dishType;
    private static Dietary dietary;
    private static Recipe recipe;

    @BeforeAll
    private static void setup(){
        Configuration configuration = new Configuration().configure("hibernate-test.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();

        prepareData();
    }

    @Test
    public void persistIngredientTypeTest(){
        session.persist(ingredientType);
        assertNotNull(ingredientType.getId());
    }

    @Test
    public void persistIngredientTest(){
        session.persist(ingredient);
        assertNotNull(ingredient.getId());
    }

    @Test
    public void persistCuisineTest(){
        session.persist(cuisine);
        assertNotNull(cuisine.getId());
    }

    @Test
    public void persistDishTypeTest(){
        session.persist(dishType);
        assertNotNull(dishType.getId());
    }

    @Test
    public void persistDietaryTest(){
        session.persist(dietary);
        assertNotNull(dietary.getId());
    }

    @Test
    public void persistRecipeTest(){
        System.out.println("Recipe id before persist: " + recipe.getId());
        session.persist(recipe);
        System.out.println("Recipe id after persist: " + recipe.getId());
        assertNotNull(recipe.getId());
    }

    @Test
    public void persistRecipeIngredientTest(){
        session.persist(recipeIngredient);
        assertNotNull(recipeIngredient.getId());
        assertNotNull(recipeIngredient.getRecipe().getId());
        assertNotNull(recipeIngredient.getIngredient().getId());
    }

    private static void prepareData(){
        List<Cuisine> cuisineList = new ArrayList<Cuisine>();
        List<Dietary> dietaryList = new ArrayList<Dietary>();
        List<DishType> dishTypeList = new ArrayList<DishType>();
        List<RecipeIngredient> recipeIngredientList = new ArrayList<>();
        recipeIngredientList.add(recipeIngredient);

        ingredientType = new IngredientType();
        ingredientType.setName("test ingredient type");

        ingredient = new Ingredient();
        ingredient.setName("test ingredient");
        ingredient.setDescription("test ingredient description");
        ingredient.setCalorificValue(100);
        ingredient.setIngredientType(ingredientType);
        ingredient.setRecipeIngredients(recipeIngredientList);

        cuisine = new Cuisine("test cuisine");
        dishType = new DishType("test dish type");
        dietary = new Dietary("test dietary");

        cuisineList.add(cuisine);
        dishTypeList.add(dishType);
        dietaryList.add(dietary);

        recipe = new Recipe();
        recipe.setName("test recipe");
        recipe.setPreparation("prepare test recipe");
        recipe.setRecipeCuisineList(cuisineList);
        recipe.setRecipeDishTypeList(dishTypeList);
        recipe.setRecipeDietaryList(dietaryList);

        recipeIngredient = new RecipeIngredient(500, "gr", recipe, ingredient);
    }

    @AfterEach
    private void clearSessionCache(){
        if(session != null)
            session.clear();
    }

    @AfterAll
    private static void releaseResources(){
        if(session != null)
            session.close();
        if(sessionFactory != null)
            sessionFactory.close();
    }
}
