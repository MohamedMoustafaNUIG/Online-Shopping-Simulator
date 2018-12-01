PROJECT TITLE:Online Shopping Simulator
PURPOSE OF PROJECT:Getting familiar with project design, task decentralisation, and class collaboration
AUTHORS:Mohamed Moustafa
DESCRIPTION:
This project is made to mimic a simple online store system.
A Customer object is initialised along with a ShoppingCart object. Item objects are added to an ArrayList in the ShoppingCart object. The cart is then closed and an Order object is initialised. The Items ArrayList is moved to the Order object and a delivery address Address object is added to the order. A billing address is initialised and is added as a parameter when initialising a payment object. If the payment is valid(valid expiry date, valid credit card number length, and one of two accepted credit card types) an "email" containing order details is sent to the user(mimiced by printing the contents out). Otherwise an email is sent with the reason the payment was regected.
