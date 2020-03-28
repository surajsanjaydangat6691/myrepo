package com.bevarageorderprocesssystem.pojos;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * It contains MenuItems details.
 * @author      Suraj Sanjay Dangat
 * @version		BeverageFactory_1.0.0
 * <p>Don't use and share this code for your any private work. </p>
 */
public class MenuItems implements Serializable {

	private static final long serialVersionUID = 2665110776147692347L;

	private static Map<String, Beverage> menus = new HashMap<>();
	private static Map<String, Ingredient> ingredients = new HashMap<>();
	
	
	
	public static Map<String, Beverage> getMenus() {
		return menus;
	}

	public static void setMenus(Map<String, Beverage> menus) {
		MenuItems.menus = menus;
	}

	public static Map<String, Ingredient> getIngredients() {
		return ingredients;
	}

	public static void setIngredients(Map<String, Ingredient> ingredients) {
		MenuItems.ingredients = ingredients;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void createMenuItems() {
		
		
		//create all ingredients
		//Given in documents
		Ingredient milk = new Ingredient("milk", 1f);
		Ingredient sugar = new Ingredient("sugar", 0.5f);
		Ingredient soda = new Ingredient("soda", 0.5f);
		Ingredient mint = new Ingredient("mint", 0.5f);
		Ingredient water = new Ingredient("water", 0.5f);
		
		//Not given but it is part of it, considering default price for it as 0$,as it is mandatory item and can not be removable 
		Ingredient coffee = new Ingredient("coffee", 0f);
		Ingredient tea = new Ingredient("tea", 0f);
		Ingredient banana = new Ingredient("banana", 0f);
		Ingredient leamon = new Ingredient("leamon", 0f);
		Ingredient strowberrie = new Ingredient("strowberrie", 0f);
		
		//Form ingredients
		ingredients.put("milk", milk);
		ingredients.put("sugar", sugar);
		ingredients.put("soda", soda);
		ingredients.put("mint", mint);
		ingredients.put("water", water);
		ingredients.put("coffee", coffee);
		ingredients.put("tea", tea);
		ingredients.put("banana", banana);
		ingredients.put("leamon", leamon);
		ingredients.put("strowberrie", strowberrie);
		
		//create all beverages ingredients
		Map<String, Ingredient> cofeeIngredients = new HashMap<>();
		cofeeIngredients.put("coffee", coffee);
		cofeeIngredients.put("milk", milk);
		cofeeIngredients.put("sugar", sugar);
		cofeeIngredients.put("water", water);
		
		
		Map<String, Ingredient> chaiIngredients = new HashMap<>();
		chaiIngredients.put("tea", tea);
		chaiIngredients.put("milk", milk);
		chaiIngredients.put("sugar", sugar);
		chaiIngredients.put("water", water);

		Map<String, Ingredient> bananaSmoothieIngredients = new HashMap<>();
		bananaSmoothieIngredients.put("banana", banana);
		bananaSmoothieIngredients.put("milk", milk);
		bananaSmoothieIngredients.put("sugar", sugar);
		bananaSmoothieIngredients.put("water", water);
		
		Map<String, Ingredient> steawberryShakeIngredients = new HashMap<>();
		steawberryShakeIngredients.put("strowberrie", strowberrie);
		steawberryShakeIngredients.put("milk", milk);
		steawberryShakeIngredients.put("sugar", sugar);
		steawberryShakeIngredients.put("water", water);
		
		
		Map<String, Ingredient> mojitoIngredients = new HashMap<>();
		mojitoIngredients.put("leamon", leamon);
		mojitoIngredients.put("soda", soda);
		mojitoIngredients.put("mint", mint);
		mojitoIngredients.put("sugar", sugar);
		mojitoIngredients.put("water", water);
		
		//create all beverages
		Beverage coffeeBeverage = new Beverage("coffee", 5.0f, cofeeIngredients);
		Beverage chaiBeverage = new Beverage("chai", 4.0f, chaiIngredients);		
		Beverage bananaSmoothieBeverage = new Beverage("banana smoothie", 6.0f, bananaSmoothieIngredients);
		Beverage steawberryShakeBeverage = new Beverage("steawberry shake", 7.0f, steawberryShakeIngredients);
		Beverage mojitoBeverage = new Beverage("mojito", 7.5f, mojitoIngredients);
		
		//create all menus
		menus.put("Coffee",coffeeBeverage);
		menus.put("Chai",chaiBeverage);
		menus.put("Banana Smoothie",bananaSmoothieBeverage);
		menus.put("Steawberry Shake",steawberryShakeBeverage);
		menus.put("Mojito",mojitoBeverage);
		
	}
	
	public static float calculateExclusionItemBill(String[] exclusionItems) {
		float exclusionAmount = 0.0f;
		if(exclusionItems!=null && exclusionItems.length > 0) {
		for(String exclusionItem : exclusionItems) {
			Ingredient ingredient = ingredients.get(exclusionItem);
			if(ingredient!=null) {
				exclusionAmount = exclusionAmount+ingredient.getCost();
			}else {
				System.out.println("Given ingredient not present : "+exclusionItem);
			}
		}
		}else {
			System.out.println("No exclusionItems present for given beverage!!!");
		}
		return exclusionAmount;		
	}
	
	public static float calculateOrderBill(String beaverage, String[] exclusionItemsWitheverage) {
		float bill = 0.0f;
		if(menus.get(beaverage)!=null) {
			bill = bill + menus.get(beaverage).getCost();
			
			if(exclusionItemsWitheverage!=null && exclusionItemsWitheverage.length>1) {
				String[] exclusionItemsWithoutBeverage= Arrays.copyOfRange(exclusionItemsWitheverage, 1, exclusionItemsWitheverage.length);
				//System.out.println("exclusionItemsWithoutBeverage: "+Arrays.toString(exclusionItemsWithoutBeverage));
				bill = bill - calculateExclusionItemBill(getExclusionsWithoutDash(exclusionItemsWithoutBeverage));
			}
			
		}else {
			System.out.println("Given order not present in menu list!!! :  "+beaverage);
		} 
		
		return bill;
	}
	
	public static String[] getExclusionsWithoutDash(String[] exclusionItems) {
		
		for(int i=0;i<exclusionItems.length;i++) {
			
				exclusionItems[i] = exclusionItems[i].replace("-", "");
			
		}
		
		//System.out.println("getExclusionsWithoutDash : "+Arrays.toString(exclusionItems));
		return exclusionItems;
	}
	
	
	
}
