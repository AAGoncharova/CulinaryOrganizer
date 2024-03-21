package co.logic.dao;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the dietary database table.
 * 
 */
@Entity
@Table(name="dietary")
public class Dietary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="culinary_organizer.dietary_id_seq",
			sequenceName="culinary_organizer.dietary_id_seq",
			allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator="culinary_organizer.dietary_id_seq")
	private Integer id;

	private String name;

	//bi-directional many-to-many association to recipe_dietary join table
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "recipe_dietary",
			joinColumns = @JoinColumn(name = "dietary_id"),
			inverseJoinColumns = @JoinColumn(name = "recipe_id")
	)
	private List<Recipe> recipes = new ArrayList<>(); //TODO: change to HashSet then override hashCode() and equals()

	public Dietary() {
	}

	public Dietary(String name){
		this.name = name;
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

	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	/*public List<RecipeCategory> getRecipeCategories() {
		return this.recipeCategories;
	}

	public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
		this.recipeCategories = recipeCategories;
	}*/

}