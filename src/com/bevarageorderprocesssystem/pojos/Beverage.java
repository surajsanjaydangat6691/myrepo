package com.bevarageorderprocesssystem.pojos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * It contains Beverage details.
 * @author      Suraj Sanjay Dangat
 * @version		BeverageFactory_1.0.0
 * <p>Don't use and share this code for your any private work. Code is submitted for first round of interview for "tavisca" only.</p>
 */
public class Beverage implements Serializable{

	private static final long serialVersionUID = 8880162510888170729L;

	private String name;
	private float cost;
	private Map<String, Ingredient> ingredients = new HashMap<>();

	public Beverage() {}
	
	public Beverage(String name, Float cost, Map<String, Ingredient> ingredients) {
		super();
		this.name = name;
		this.cost = cost;
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Map<String, Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Map<String, Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "Beverage [name=" + name + ", cost=" + cost + ", ingredients=" + ingredients + "]";
	}
	
}
