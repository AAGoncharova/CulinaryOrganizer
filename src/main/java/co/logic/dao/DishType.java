package co.logic.dao;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the dish_type database table.
 * 
 */
@Entity
@Table(name="dish_type", schema="culinary_organizer")
public class DishType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bidirectional many-to-one association to RecipeCategory
	@OneToMany(mappedBy="dishType")
	private List<RecipeCategory> recipeCategories;

	public DishType() {
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