public class Email
{
    private String email;
    private String customerName;
    public Email(Customer customer)
    {
        email=customer.getEmailAddress();
        customerName=customer.getFirstName();
    }
    
    public void success(Order order,Address billingAddress)
    {
       System.out.println("---------------");
       System.out.println("Dear "+customerName+", an email has been sent to "+email+":");
       System.out.println("Payment successful!");
       System.out.println("Order Number: "+order.getId());
       System.out.println("Ordered Items: ");
       order.printItems();
       System.out.println("Ordered Total: ");
       order.printTotal();
       System.out.println("Order Delivery Address: "+order.getAddress().getAddress());
       System.out.println("Order Billing Address: "+billingAddress.getAddress());
       System.out.println("---------------");
    }
    
    public void failure(String remark)
    {
        System.out.println("---------------");
        System.out.println("Dear "+customerName+", an email has been sent to "+email+":");
        System.out.println("Payment failed due to :"+remark);
        System.out.println("---------------");
    }
}
