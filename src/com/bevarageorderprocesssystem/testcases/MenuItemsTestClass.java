package com.bevarageorderprocesssystem.testcases;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import com.bevarageorderprocesssystem.pojos.MenuItems;

public class MenuItemsTestClass {

	
	@Test
	public void testCreateMenuItemsAfterCreation() {
		MenuItems.createMenuItems();
		assertNotNull(MenuItems.getMenus().get("Chai"));
	}


	@Test
	public void testIngredientAfterCreation() {
		MenuItems.createMenuItems();
		assertNotNull(MenuItems.getIngredients().get("milk"));
	}
	
	@Test
	public void testGetExclusionsWithoutDash() {
		String[] exclusionItems = {"milk","-sugar"};
		String[] expected = {"milk","sugar"};
		MenuItems.getExclusionsWithoutDash(exclusionItems);
		assertTrue(Arrays.equals(expected, MenuItems.getExclusionsWithoutDash(exclusionItems)));
	}
	
	@Test
	public void testCalculateOrderBillOnlyBeverageNoExclusin() {
		String[] orders = {"Chai"}; 
		String breverage = "Chai";
		float expectedBill = 4.0f;
		
		float actualBill = MenuItems.calculateOrderBill(breverage,orders);
		assertTrue(expectedBill==actualBill); 
	}
	
	@Test
	public void testCalculateOrderBillWithExclusion() {
		String[] orders = {"Chai", "-sugar"}; 
		String breverage = "Chai";
		float expectedBill = 3.5f;
		
		float actualBill = MenuItems.calculateOrderBill(breverage,orders);
		assertTrue(expectedBill==actualBill); 
	}
	
	@Test
	public void testCalculateOrderBillWithNoBeverageExist() {
		String[] orders = {"Milk Choclate Shake"}; 
		String breverage = "Milk Choclate Shake";
		float expectedBill = 0.0f;//As no menu present
		float actualBill = MenuItems.calculateOrderBill(breverage,orders);
		assertTrue(expectedBill==actualBill); 
	}

	@Test
	public void testcalcalculateExclusionItemBillWithoutExclusin() {
		String[] exclusionItems = {}; 
		float expectedBill = 0.0f;
		float actualBill = MenuItems.calculateExclusionItemBill(exclusionItems);
		assertTrue(expectedBill==actualBill); 
	}
	
	@Test
	public void testcalcalculateExclusionItemBillWithExclusin() {
		MenuItems.createMenuItems();
		String[] exclusionItems = {"sugar"}; 
		float expectedBill = 0.5f;
		float actualBill = MenuItems.calculateExclusionItemBill(exclusionItems);
		assertTrue(expectedBill==actualBill); 
	}
	
	@Test
	public void testcalcalculateExclusionItemBillWithExclusinItemNotExist() {
		MenuItems.createMenuItems();
		String[] exclusionItems = {"sugarr"}; 
		float expectedBill = 0.0f;
		float actualBill = MenuItems.calculateExclusionItemBill(exclusionItems);
		assertTrue(expectedBill==actualBill); 
	}
}
