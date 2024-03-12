package co.logic.dao;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.List;


/**
 * The persistent class for the ingredient database table.
 * 
 */
@Entity
@Table(name="ingredient", schema="culinary_organizer")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer calorificValue;

	private String description;

	private String name;

	//bidirectional many-to-one association to IngredientType
	@ManyToOne
	@JoinColumn(name="ingredient_type_id")
	private IngredientType ingredientType;

	//bi-directional many-to-one association to RecipeIngredient
	@OneToMany(mappedBy="ingredient")
	private List<RecipeIngredient> recipeIngredients;

	public Ingredient() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCalorificValue() {
		return this.calorificValue;
	}

	public void setCalorificValue(Integer calorificValue) {
		this.calorificValue = calorificValue;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IngredientType getIngredientType() {
		return this.ingredientType;
	}

	public void setIngredientType(IngredientType ingredientType) {
		this.ingredientType = ingredientType;
	}

	public List<RecipeIngredient> getRecipeIngredients() {
		return this.recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	@Override
	public String toString() {
		return this.name;
	}
}