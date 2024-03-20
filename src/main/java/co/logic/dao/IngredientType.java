package co.logic.dao;

import java.io.Serializable;
import jakarta.persistence.*;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * The persistent class for the ingredient_type database table.
 * 
 */
@Entity
@Table(name="ingredient_type")
public class IngredientType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="culinary_organizer.ingredient_type_id_seq",
			sequenceName="culinary_organizer.ingredient_type_id_seq",
			allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator="culinary_organizer.ingredient_type_id_seq")
	private Integer id;

	private String name; //todo: add @NotNull constraint

	//bidirectional many-to-one association to Ingredient
	//@OneToMany(mappedBy="ingredientType")
	//private List<Ingredient> ingredients;

	public IngredientType() {
	}

	public IngredientType(String name) {
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

	/*public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}*/

}