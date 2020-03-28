# BeverageOrderProcessingSystem
A simple Java program for Solving following Problem Statement.

## Beverage Factory:
We are the owners of a beverage factory which serves a variety of drinks, juices etc to the customers from its pre-defined set of menu Items.
We offer the customers a choice to customize their drinks in case they want to avoid some specific ingredients from their drinks,
e.g. a person ordering "Chai Latte" which has ingredients as "tea leaves, milk, water, sugar, condiments" a person can order a chai latter without sugar and condiments.
The order value is recalculated based on the actual price of the menu minus the price of the removed ingredient.
So if 1 Cup Chai costed 5 $ and sugar costed 0.5 $ and milk costed 1$ the order: "Chai, - sugar, -milk" would charge
5 - 0.5 - 1.0=3.5$ for the order.
The order to be placed to the shop is always a String concatenated by exclusions. 
1. "Chai, -sugar"
2. "Chai, -sugar, -milk"
3. "Chai"
4. ["Chai, -sugar", "Chai", "Coffee, -milk"] // Chai and Tea are menu items
are all valid orders.
As a part of this exercise you have to write a program should be able to compute the total price of the order placed. Remember the order can only be a String.

Below are the Menu Items with their respective ingredients and prices:
Coffee: "Coffee, milk, sugar, water" Price: 5$
Chai: "Tea, milk, sugar, water" Price: 4$
Banana Smoothie: "banana, milk, sugar, water" Price: 6$
Strawberry Shake: "Strawberries, sugar, milk, water" Price: 7 $
Mojito: "Lemon, sugar, water, soda, mint" Price 7.5 $
Ingredients prices:
Milk: 1 $
Sugar: 0.5 $
Soda: 0.5 $
mint: 0.5 $
water: 0.5 $

## Input :-
//For following input
String[] orders = {"Chai, -sugar", "Chai", "Coffee, -milk"};

## Output:-

Given order : 

Order 1 : Chai, -sugar

Order 2 : Chai

Order 3 : Coffee, -milk

-----------------------------------------------------

Order and its bill : 

Chai, -sugar : 3.5

Coffee, -milk : 4.0

Chai : 4.0

-----------------------------------------------------

TotalBill : 11.5$

-----------------------------------------------------


## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
Prerequisites
What things you need to install the software and how to install them
-	Java 8
-	Maven
## Installing and Running
Step – I: Clone and download project. “myrepo-master.zip” file downloaded in download folder. Copy it and Paste it in your eclipse Workspace location. Extract this zip here.

Step-II:- Start eclipse and select your work space.

Step-III:- Click on File -> Imports -> Maven -> Existing Maven Projects -> Next 
-> Select “Root directory” for “myrepo-master”->Finish

Step-IV:- Right Click on project -> Maven -> Update Project -> select “Force Update of Snapshots/Releases” -> Ok

Step-V:- Right Click on project -> Run As -> Maven Build -> Goals as “clean install” -> Clik on check box  “Update Snapshots” -> Apply -> Run-> You will get “CreateBevarageOrderProcessingSystem-0.0.1-SNAPSHOT-jar-with-dependencies.jar” in target folder of project.

Step-VI :- run this jar file by following command
java -jar CreateBevarageOrderProcessingSystem-0.0.1-SNAPSHOT-jar-with-dependencies.jar

## Built With
•	Maven - Dependency Management
## Author
•	Suraj Sanjay Dangat 
