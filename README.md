Assignment
=============================

- [Introduction](#introduction)
- [Solution](#solution)
- [Enhancements](#enhancements)

#Introduction


Calculates the total cost of a shopping cart based on a set of pricing rules.The items in a supermarket are identified by using Stock Keeping Units or SKUs. For this, we will use individual letters of the alphabet (e.g. A,B,C) and the items are priced individually. In addition to that some items are multi priced: buy n of them and they will cost you y Euro.


#Solution
 
Since items inserted into cart are Strings, I have to count the number of items corresponding to a single SKU(grouping by identity) and then check if special prize is available for input quantity. Use below mentioned formulae to calculate the offered price or single unit price in case special price is not available:

	 int discountQuantity =   quantity/totalQuantity;
	 int remainingQuantity = quantity % totalQuantity;
	 int totalPrice = dicountQuantity * specialPrice + remainingQuantity * UnitPrice;

I tried to maintain a very basic, simple and easy architecture for the application.

#Enhancements:
	1. Use of Strategy Design pattern while reading the pricing_rules from config file.
	2. Use DB to store and retrieve pricing rules to make it more dynamic and performant.
	3. Addition new feature to checkout like removeItems. 
	4. Logging and Exception handling.