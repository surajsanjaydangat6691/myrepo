package com.bevarageorderprocesssystem.pojos;

import java.io.Serializable;

/**
 * It contains Ingredient details.
 * @author      Suraj Sanjay Dangat
 * @version		BeverageFactory_1.0.0
 * <p>Don't use and share this code for your any private work. </p>
 */
public class Ingredient implements Serializable{

	private static final long serialVersionUID = -4162675536491833619L;

	private String name;
	private float cost;
	
	public Ingredient() {}
	
	public Ingredient(String name, Float cost) {
		super();
		this.name = name;
		this.cost = cost;
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
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", cost=" + cost + "]";
	}
		
}
