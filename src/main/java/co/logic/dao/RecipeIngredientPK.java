package co.logic.dao;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the recipe_ingredient database table.
 * 
 */
@Embeddable
public class RecipeIngredientPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="recipe_id")
	private Integer recipeId;

	@Column(name="ingredient_id")
	private Integer ingredientId;

	public RecipeIngredientPK() {
	}

	public RecipeIngredientPK(Integer recipeId, Integer ingredientId) {
		this.recipeId = recipeId;
		this.ingredientId = ingredientId;
	}

	public Integer getRecipeId() {
		return this.recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public Integer getIngredientId() {
		return this.ingredientId;
	}
	public void setIngredientId(Integer ingredientId) {
		this.ingredientId = ingredientId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RecipeIngredientPK)) {
			return false;
		}
		RecipeIngredientPK castOther = (RecipeIngredientPK)other;
		return 
			this.recipeId.equals(castOther.recipeId)
			&& this.ingredientId.equals(castOther.ingredientId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.recipeId.hashCode();
		hash = hash * prime + this.ingredientId.hashCode();
		
		return hash;
	}
}