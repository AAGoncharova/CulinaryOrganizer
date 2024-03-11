package co.logic.dao;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;


/**
 * The persistent class for the recipe database table.
 * 
 */
@Entity
@Table(name="recipe", schema="culinary_organizer")
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private byte[] picture;

	@ManyToMany
	@JoinColumns({ ///TODO just trying it
			@JoinColumn(
					name = "recipe_id",
					referencedColumnName = "id"),
			@JoinColumn(
					name = "ingredient_id",
					referencedColumnName = "id")
	})
	private List<RecipeIngredient> recipeIngredients;

	private String preparation;

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

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public List<RecipeIngredient> getRecipeIngredients() {
		return this.recipeIngredients;
	}
	
	public void getRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}
	
	public String getPreparation() {
		return this.preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

}