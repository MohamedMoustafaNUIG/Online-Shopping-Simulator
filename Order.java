import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
public class Order
{
    private final long orderId;
    private Item item;
    private ArrayList<Item> items;
    private int total;
    private Customer customer;
    private String time;
    private Address deliveryAddress;
    private String status;
    public Order(ShoppingCart cart)
    {
        items = new ArrayList<Item>();
        transferItems(cart);
        orderId = makeId();
        customer=cart.getCustomer();
        time=new Date().toString();
        status="Created";
    }

    private long makeId() {
        return (long)(Math.random() * 99999999999999L);
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public long getId(){
        return orderId;
    }
    
    public String getStatus(){
        return status;
    }
    
    public int getTotal(){
        return total;
    }
    
    public Address getAddress(){
        return deliveryAddress;
    }
    
    public void transferItems(ShoppingCart cart)
    {
        while(cart.getSize()>0)
        {
            items.add(cart.transferItems());
        }
        status="Items Added";
    }
    
    public void add(Address address)
    {
        deliveryAddress=address;
        customer.setDeliveryAddress(address);
    }
    
    public void printItems()
    {
        System.out.println("");
        
        for(int i=0;i<items.size();i++){
            System.out.println(items.get(i).toString());
        }
        System.out.println("Order created on: "+time);
        System.out.println("");
    }
    
    public void printTotal()
    {
        total=0;
        for(int i=0;i<items.size();i++){
            total=total+items.get(i).getPrice();
        }
        System.out.println("Your total is "+total);
        System.out.println("Order created on: "+time);
        System.out.println("");
    }
    
    public void sendEmail(Boolean valid,Address address, String remark)
    {
        Email email = new Email(customer);
        if(valid==true){
            status="Processed";
            email.success(this,address);
        }else{
            status="ERROR";
            email.failure(remark);
        }
    }
}