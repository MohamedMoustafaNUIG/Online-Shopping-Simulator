public class TransactionTest
{
    
    public static void main(String[] args)
    {
       TransactionTest test = new TransactionTest();
       test.transaction1();
       test.transaction2();
    }
    
    public void transaction1(){
        Customer customer = new Customer("Alan", "O'Brian", "alan@zmail.com");
        
        ShoppingCart cart = new ShoppingCart(customer);  
        
        Item item1 = new Item("Jelly Beans", 1);
        item1.setPrice(4);
        Item item2 = new Item("Pringles", 2);
        item2.setPrice(2);
        Item item3 = new Item("Coke_Diet", 3);
        item3.setPrice(5);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        
        cart.close();        
        Order order = new Order(cart);
        
        Address address1 = new Address();
        address1.setStreet("NewCastle");
        address1.setCity("Dublin");
        address1.setZip("G23 F5P2");
        address1.setCountry("Ireland");
        order.add(address1);
        
        Address address2 = new Address();
        address2.setStreet("Cararough Road");
        address2.setCity("Dublin");
        address2.setZip("D01 F5P2");
        address2.setCountry("Ireland");
        Payment payment = new Payment(order,"MasterCard","1122334455667788","18/10/2019",address2,"Bank of Ireland");
        
      } 
     
    public void transaction2(){
        Customer customer = new Customer("Joan", "O'Leary", "jo_leary@zmail.com");
        ShoppingCart cart = new ShoppingCart(customer);  
        Item item1 = new Item("Jelly Beans",1);
        item1.setPrice(4);
        Item item2 = new Item("Pringles",2);
        item2.setPrice(2);
        Item item3 = new Item("Coke_Diet",3);
        item3.setPrice(5);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        cart.printItems();
        cart.displayTotal();
        
        cart.removeItem("Jelly Beans",1);
        
        cart.close();        
        Order order = new Order(cart);
        Address address1 = new Address();
        address1.setStreet("NewCastle");
        address1.setCity("Dublin");
        address1.setZip("G32 F5P2");
        address1.setCountry("Ireland");
        order.add(address1);
        
        Address address2 = new Address();
        address2.setStreet("Cararough Road");
        address2.setCity("Dublin");
        address2.setZip("D01 F5P2");
        address2.setCountry("Ireland");
        Payment payment = new Payment(order,"MasterCard","1122334455667788","13/10/2018",address2,"Bank of Ireland");
    }
}
