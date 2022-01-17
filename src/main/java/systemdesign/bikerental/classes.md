**Here are the main classes of our Bike Rental System**:

-     **BikeRentalSystem**: The main part of the organization for which this software has been designed.

-     **BikeRentalLocation**: The Bike rental system will have multiple locations, each location will have attributes 
        like ‘Name’ to distinguish it from any other locations and ‘Address’ which defines the address of the rental 
        location.

-     **Bike**: The basic building block of the system. Every Bike will have a barcode, chasis number, 
        passenger capacity, model, make, color etc. Bikes can be of multiple types, like Road Bike, Mountain Bike, Hybrid, 
        e-Bike etc.

-     **Account**: Mainly, we will have two types of accounts in the system, one will be a general member and the other 
        will be a receptionist. Another account can be of the worker taking care of the returned bike.

-     **BikeReservation**: This class will be responsible for managing reservations for a Bike.

-     **Notification**: Will take care of sending notifications to members.

-     **BikeLog**: To keep track of all the events related to a bike.

-     **RentalInsurance**: Stores details about the various rental insurances that members can add to their reservation.

-     **Equipment**: Stores details about the various types of equipment that members can add to their reservation.

-     **Service**: Stores details about the various types of service that members can add to their reservation, such as 
        additional riders, roadside assistance, etc.

-     **Bill**: Contains different bill-items for every charge for the reservation.