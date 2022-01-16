#_**Problem Statement**_
https://javarevisited.blogspot.com/2016/06/design-vending-machine-in-java.html#axzz4sZVwtCgs
https://javarevisited.blogspot.com/2016/06/java-object-oriented-analysis-and-design-vending-machine-part-2.html#axzz7HvC9Ch5P
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

**InventoryService**
1. It defines the APIs of vending machine inventory, usually, all inventory functionality should go in this class

**InventoryServiceImpl**
1. A sample implementation of Inventory Service

**PaymentService**
1. It defines the APIs of vending machine cash payments, usually, all cash payment functionality should go in this class

**PaymentServiceImpl**
1. A sample implementation of Payment Service

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


**High-level Design**
   - Includes an overview of the problem, not necessary if you are writing this as part of the test because the evaluator should be familiar with problem specification. Important if your design document is intended for someone who is not very familiar with the problem domain.

    - Main interface, classes, and Exceptions
      - VendingMachine - an interface that defines public API of VendingMachine
      - VendingMachineImpl - a general-purpose implementation of the VendingMachine interface
      - Inventory - A type-safe inventory for holding objects, which is an ADAPTER or WRAPPER over java.util.Map
      - Item - type-safe Enum to represent items supported by vending machines.
      - Coin - type-safe Enum to represent coins, which is acceptable by a vending machine.
      - Bucket - A Holder class for holding two types together.
      - SoldOutException - thrown when the user selects a product that is sold out
      - NotSufficientChangeException - thrown when Vending machine doesn't have enough change to support the current transaction.
      - NotFullPaidException - thrown when the user tries to collect an item, without paying the full amount.

    - Data structures used
      - Map data structure is used to implement cash and item inventories.
      - The List is used to returning changes because it can contain duplicates, i.e. multiple coins of the same denomination.


    - Motivation behind design decisions
         - Factory design pattern is used to encapsulate the creation logic of VendingMachine.
         - Adapter pattern is used to create Inventory by wrapping java.util.Map
         - java.lang.Enum is used to represent Item and Coins, because of the following benefits
                - compile-time safety against entering an invalid item and invalid coin.
                - no need to write code for checking if the selected item or entered coin is valid.
                - reusable and well encapsulated.
         - long is used to represent price and totalSales, which are the amount because we are dealing in cents.
         Not used BigDecimal to represent money, because the vending machine can only hold a limited amount, due to the finite capacity of coin inventory.

**Low Leven Design**
1) Methods
   -  The getChange() method uses a greedy algorithm to find out whether we have sufficient coins to support an amount.

    - Initialization 
        -  When Vending Machine will be created, it's initialized with the default cash amount and item inventory. current with quantity 5 for each coin and item.

2) Testing Strategy
    - Three primary test cases to testWithExactPrice(), testWithMorePrice() and testRefund() to cover general usecase.
    - Negative test cases like testing SoldOutException, NotSufficientChangeException or NotFullPaidException
    

3) Benefits
    - The design uses Abstraction to create reusable, small classes which are easier to read and test.
    - Encapsulating Items and Coins in their respective class makes it easy to add new Coins and Items.
    - Inventory is a general-purpose class and can be used elsewhere, It also encapsulates all inventory operations.

4) Assumption
    - Vending Machine is single-threaded, only one user will operate at a time.
    - A call to reset() will reset the item and balance i.e. make them zero.