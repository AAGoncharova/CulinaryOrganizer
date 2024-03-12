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
	private RecipeIngredientPK id;

	@Column(name="ingredient_amount")
	private Integer ingredientAmount;

	@Column(name="unit_of_measurement")
	private String unitOfMeasurement;

	//bidirectional many-to-one association to Ingredient
	//@ManyToOne
	//@PrimaryKeyJoinColumn(name="ingredient_id", referencedColumnName="id")
	private Ingredient ingredient;

	//bidirectional many-to-one association to Recipe
	//@ManyToOne
	//@PrimaryKeyJoinColumn(name="recipe_id", referencedColumnName="id")
	private Recipe recipe;

	public RecipeIngredient() {
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