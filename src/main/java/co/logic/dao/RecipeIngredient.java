package co.logic.dao;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the recipe_ingredient database table.
 * 
 */
@Entity
@Table(name="recipe_ingredient", schema="culinary_organizer")
public class RecipeIngredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RecipeIngredientPK id = new RecipeIngredientPK();

	@Column(name="ingredient_amount")
	private Integer ingredientAmount;

	@Column(name="unit_of_measurement")
	private String unitOfMeasurement;

	//bidirectional many-to-one association to Recipe
	@ManyToOne
	@JoinColumn(
			name="recipe_id",
			insertable=false, updatable=false) //avoid duplication in mapping
	private Recipe recipe;

	//bidirectional many-to-one association to Ingredient
	@ManyToOne
	@JoinColumn(
			name="ingredient_id",
			insertable=false, updatable=false) //avoid duplication in mapping
	private Ingredient ingredient;

	public RecipeIngredient() {
	}

	public RecipeIngredient(
			Integer ingredientAmount,
			String unitOfMeasurement,
			Recipe recipe,
			Ingredient ingredient) {

		this.ingredientAmount = ingredientAmount;
		this.unitOfMeasurement = unitOfMeasurement;
		this.recipe = recipe;
		this.ingredient = ingredient;

		//set id values since Recipe and Ingredient should be already persisted
		this.id.setRecipeId(recipe.getId());
		this.id.setIngredientId(ingredient.getId());

		//guarantee referential integrity since bi-directional
		recipe.getRecipeIngredients().add(this);
		ingredient.getRecipeIngredients().add(this);
	}

	public RecipeIngredientPK getId() {
		return this.id;
	}

	public void setId(RecipeIngredientPK id) {
		this.id = id;
	}

	public Integer getIngredientAmount() {
		return this.ingredientAmount;
	}

	public void setIngredientAmount(Integer ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}

	public String getUnitOfMeasurement() {
		return this.unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public Ingredient getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}