import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
public class ShoppingCart
{
    private final long cartId;
    private String time;
    private Item item;
    private ArrayList<Item> items;
    private int total;
    private Customer customer;
    private Boolean cartOpen;
    
    public ShoppingCart(Customer customer)
    {
        items = new ArrayList<Item>();
        time=new Date().toString();
        this.customer=customer;
        cartId=makeId();
        total=0;
        cartOpen=true;
    }
    
    private long makeId() {
        return (long)(Math.random() * 99999999999999L);
    }
    
    public void addItem(Item item)
    {
        if(cartOpen==true)
        {
            for(int i=0;i<items.size();i++){
            if(item.getId()==items.get(i).getId())
            {
                item.setId(item.getId()+1);
                i=0;
            }
            else{
                continue;
            }
          }
          items.add(item);
        }else{
                System.out.println("");
                System.out.println("Sorry,cart has been closed");
                System.out.println("");
             }
    }
    
    public void removeItem(String name,long id)
    {
      if(cartOpen==true)
      {
        for(int i=0;i<items.size();i++){
            if(name.equals(items.get(i).getName()) && id==items.get(i).getId())
            {
                items.remove(i);
            }
        }
      }else{
            System.out.println("");
            System.out.println("Sorry,cart has been closed");
            System.out.println("");
           }
    }
    
    public int getSize()
    {
        return items.size();
    }
    
    public long getCartId()
    {
        return cartId;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public Item transferItems()//used to both transfer items to Order object as well as clear items from cart
    {
        Item transfer = items.get(0);
        items.remove(0);
        return transfer;
    }
    
    public int getTotal()
    {
        total = 0;
        for(int i=0;i<items.size();i++){
            total=total+items.get(i).getPrice();
        }
        return total;
    }
     
    public void printItems()
    {
        for(int i=0;i<items.size();i++){
            System.out.println(items.get(i).toString());
        }
        System.out.println("Shopping Cart created on: "+time);
        System.out.println("");
    }
    
    public void displayTotal()
    {
        total = 0;
        for(int i=0;i<items.size();i++){
            total=total+items.get(i).getPrice();
        }
        System.out.println("You have "+getSize()+" items in your cart and your total is "+total);
        System.out.println("Shopping Cart created on: "+time);
        System.out.println("");
    }
    
    public void close()
    {
        cartOpen=false;
    }
}
