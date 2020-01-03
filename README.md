Assignment
=============================

- [Introduction](#introduction)
- [Solution](#solution)
- [Enhancements](#enhancements)

#Introduction


Calculates the total cost of a shopping cart based on a set of pricing rules.The items in a supermarket are identified by using Stock Keeping Units or SKUs. For this, we will use individual letters of the alphabet (e.g. A,B,C) and the items are priced individually. In addition to that some items are multi priced: buy n of them and they will cost you y Euro.


#Solution

To be honest understanding the problem took a bit of time when I start working on this, but once that is done half of the problem is solved and now you have to transfer your thoughts into code. Since inserted items into cart are Strings, I have to count the number of items corresponding to a single SKU and then check if special prize is available for it and then use the below mentioned formula's:

	 int discountQuantity =   quantity/totalQuantity;
	 int remainingQuantity = quantity % totalQuantity;
	 int totalPrice = dicountQuantity * specialPrice + remainingQuantity * UnitPrice;

I tried to maintain the very basic, simple and easy architectue for the application, maintaining the layered approach to different Objects. 

#Enhancements:
	Right now, I have only give 3-4 hours to problem. We can add more features as well into it:
	1. Logging and exception handling.
	2. Use of Strategy Design pattern while reading the pricing_rules from different input files.
	3. Integration test suite.