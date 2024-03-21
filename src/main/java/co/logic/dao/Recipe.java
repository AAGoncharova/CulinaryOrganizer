package co.logic.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the recipe database table.
 * 
 */
@Entity
@Table(name="recipe")
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="culinary_organizer.recipe_id_seq",
			sequenceName="culinary_organizer.recipe_id_seq",
			allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator="culinary_organizer.recipe_id_seq")
	private Integer id;

	private String name;

	private String preparation;

	private byte[] picture;

	//bi-directional one-to-many association to RecipeIngredient
	@OneToMany(mappedBy = "recipe")
	private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

	//bi-directional many-to-many association to Cuisine
	@ManyToMany(mappedBy = "recipes")
	private List<Cuisine> cuisines;

	//bi-directional many-to-many association to DishType
	@ManyToMany(mappedBy = "recipes")
	private List<DishType> dishTypes;

	//bi-directional many-to-many association to Dietary
	@ManyToMany(mappedBy = "recipes")
	private List<Dietary> dietaryList;

	public Recipe() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPicture() {
		return this.picture;
	}

	public void setPicture(byte[] picture) { //TODO
		this.picture = picture;
	}

	public List<RecipeIngredient> getRecipeIngredients() {
		return this.recipeIngredients;
	}
	
	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
	
	public String getPreparation() {
		return this.preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public List<Cuisine> getRecipeCuisineList() {
		return this.cuisines;
	}

	public void setRecipeCuisineList(List<Cuisine> recipeCuisineList) {
		this.cuisines = recipeCuisineList;
	}

	public List<DishType> getRecipeDishTypeList() {
		return this.dishTypes;
	}

	public void setRecipeDishTypeList(List<DishType> recipeDishTypeList) {
		this.dishTypes = recipeDishTypeList;
	}

	public List<Dietary> getRecipeDietaryList() {
		return this.dietaryList;
	}

	public void setRecipeDietaryList(List<Dietary> recipeDietaryList) {
		this.dietaryList = recipeDietaryList;
	}

	public void caclCalorificValue(){
		//TODO: calculate from ingredients calorific values
	}
}