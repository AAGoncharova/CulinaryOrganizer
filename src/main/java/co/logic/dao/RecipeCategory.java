package co.logic.dao;

import java.util.List;
import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the recipe_category database table.
 * 
 */
@Entity
@Table(name="recipe_category", schema="culinary_organizer")
public class RecipeCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="recipe_id")
	private Integer recipeId;

	//bi-directional many-to-one association to Cuisine
	@ManyToMany // TODO: changed it from @ManyToOne to @ManyToMany
	private List<Cuisine> cuisineList;

	//bi-directional many-to-one association to Dietary
	@ManyToOne
	@JoinColumn(name="dietary_id")
	private Dietary dietary;

	//bi-directional many-to-one association to DishType
	@ManyToOne
	@JoinColumn(name="dish_type_id")
	private DishType dishType;

	//bi-directional one-to-one association to Recipe
	@OneToOne
	@PrimaryKeyJoinColumn(name="recipe_id", referencedColumnName="id")
	private Recipe recipe;

	public RecipeCategory() {
	}

	public Integer getRecipeId() {
		return this.recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public List<Cuisine> getCuisine() {
		return this.cuisineList;
	}

	public void setCuisine(List<Cuisine> cuisineList) {
		this.cuisineList= cuisineList;
	}

	public Dietary getDietary() {
		return this.dietary;
	}

	public void setDietary(Dietary dietary) {
		this.dietary = dietary;
	}

	public DishType getDishType() {
		return this.dishType;
	}

	public void setDishType(DishType dishType) {
		this.dishType = dishType;
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

}