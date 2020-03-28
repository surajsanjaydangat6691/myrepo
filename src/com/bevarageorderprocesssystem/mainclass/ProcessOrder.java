package com.bevarageorderprocesssystem.mainclass;

import java.util.HashMap;
import java.util.Map;

import com.bevarageorderprocesssystem.pojos.AppConstants;

import com.bevarageorderprocesssystem.pojos.MenuItems;


/**
 * It is main processing class.
 * @author      Suraj Sanjay Dangat
 * @version		BeverageFactory_1.0.0
 * <p>Don't use and share this code for your any private work. Code is submitted for first round of interview for "tavisca" only.</p>
 */
public class ProcessOrder {

	private static Float totalBill = 0f;

	public static void main(String[] args) {

		//String[] orders = {"Chai, -sugar"};
		//String[] orders = {"Chai, -sugar, -milk"};
		//String[] orders = {"Chai"};
		String[] orders = {"Chai, -sugar", "Chai", "Coffee, -milk"};
		


		
		if(orders!= null && orders.length > 0) {
			processOrders(orders);
		}else {
			System.out.println("Order list is empty!!!");
		}



	}
	
	public static void processOrders(String[] orders ) {
		Map<String, Float> billForOrders = new HashMap<>();
		
		if(orders!= null && orders.length > 0) {
			
			
			//create menu items
			MenuItems.createMenuItems();

			System.out.println("Given order : ");
			for(int i=0;i<orders.length;i++) {
				System.out.println("Order "+(i+1)+" : "+orders[i]);
			}
			
			//Process each order
			for(String order : orders) {
				billForOrders.put(order, 0.0f);
				String[] orderAndExclusion = order.split(AppConstants.COMMA_AND_SPACE);
				if(orderAndExclusion!=null && orderAndExclusion.length>0) {

					if(orderAndExclusion[0]!=null && !orderAndExclusion[0].isEmpty()) {
						float orderBill = MenuItems.calculateOrderBill(orderAndExclusion[0],orderAndExclusion);
						billForOrders.put(order, orderBill);
					}else {
						System.out.println("Please provide valid order!!!");
					}

				}else {
					System.out.println("Please provide valid order!!!");
				}	

			}

			//Print bill for each order
			System.out.println("-----------------------------------------------------");
			System.out.println("Order and its bill : "/*+billForOrders*/);


			totalBill = 0.0f;
			billForOrders.forEach( (k,v) -> {
				System.out.println(k+" : "+v);
				if(v!=null) {
					totalBill=totalBill+v;
				}

			});
			System.out.println("-----------------------------------------------------");
			System.out.println("TotalBill : "+totalBill+"$");
			System.out.println("-----------------------------------------------------");


		
		}else {
			System.out.println("Order list is empty!!!");
		}
		
	}
}
