package co.logic.dao;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the ingredient database table.
 * 
 */
@Entity
@Table(name="ingredient")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="culinary_organizer.ingredient_id_seq",
			sequenceName="culinary_organizer.ingredient_id_seq",
			allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator="culinary_organizer.ingredient_id_seq")
	private Integer id;
	private String name;
	private String description;
	@Column(name = "calorific_value")
	private Integer calorificValue;

	//bidirectional one-to-one association to IngredientType
	@OneToOne
	@JoinColumn(name="ingredient_type_id")
	private IngredientType ingredientType;

	//bi-directional one-to-many association to RecipeIngredient
	@OneToMany(mappedBy="ingredient")
	private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

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