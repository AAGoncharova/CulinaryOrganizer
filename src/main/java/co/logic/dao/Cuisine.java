package co.logic.dao;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.List;


/**
 * The persistent class for the cuisine database table.
 * 
 */
@Entity
@Table(name="cuisine", schema="culinary_organizer")
public class Cuisine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name; // I write it here once: @Column is not necessary here because the property is already persisted by default for @Entity

	//bi-directional many-to-one association to RecipeCategory
	@OneToMany(mappedBy="cuisineList")
	private List<RecipeCategory> recipeCategories;

	public Cuisine() {
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

	public List<RecipeCategory> getRecipeCategories() {
		return this.recipeCategories;
	}

	public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
		this.recipeCategories = recipeCategories;
	}

}