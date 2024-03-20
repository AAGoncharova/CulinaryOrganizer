package co.logic.dao;

import java.io.Serializable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the cuisine database table.
 * 
 */
@Entity
@Table(name="cuisine")
public class Cuisine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="culinary_organizer.cuisine_id_seq",
			sequenceName="culinary_organizer.cuisine_id_seq",
			allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator="culinary_organizer.cuisine_id_seq")
	private Integer id;

	private String name; // I write it here once: @Column is not necessary here because the property is already persisted by default for @Entity

	//bi-directional many-to-many association to recipe_cuisine join table
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "recipe_cuisine",
			joinColumns = @JoinColumn(name = "cuisine_id"),
			inverseJoinColumns = @JoinColumn(name = "recipe_id")
	)
	private List<Recipe> recipes = new ArrayList<>(); //TODO: change to HashSet then override hashCode() and equals()

	public Cuisine() {
	}

	public Cuisine(String name) {
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
}