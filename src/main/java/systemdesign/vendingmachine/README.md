# _`**Problem Statement**`_
1. You need to design a Vending Machine which
2. Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter.
3. Allow user to select products Coke(25), Pepsi(35), Soda(45)
4. Allow user to take refund by canceling the request.
5. Return the selected product and remaining change if any
6. Allow reset operation for vending machine supplier.


Solution and Coding
My implementation of Java Vending Machine has the following classes and interfaces :

**VendingMachine**
1. It defines the public API of a vending machine, usually, all high-level functionality should go in this class

**VendingMachineImpl**
1. A sample implementation of Vending Machine

**VendingMachineFactory**
1. A Factory class to create different kinds of Vending Machine

**Item**
1. Java Enum to represent Item served by Vending Machine

**Inventory**
1. Java class to represent an Inventory, used for creating the case and item inventory inside Vending Machine

**Coin**
1. Another Java Enum to represent Coins supported by Vending Machine

**Bucket**
1. A parameterized class to hold two objects. It's kind of Pair class.

**NotFullPaidException**
1. An Exception is thrown by Vending Machine when a user tries to collect an item, without paying the full amount.

**NotSufficientChangeException**
1. Vending Machine throws this exception to indicate that it doesn't have sufficient change to complete this request.

**SoldOutExcepiton**
1. Vending Machine throws this exception if the user requests a product that is sold out.
