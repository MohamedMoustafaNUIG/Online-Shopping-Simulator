 public class Customer {
    private String firstName;
    private String surName;
    private String emailAddress;
    private final long customerId;
    private Address deliveryAddress;
    private Address billingAddress;
    public Customer(String firstName, String surName, String emailAddress){
        this.firstName = firstName;
        this.surName = surName;
        this.emailAddress = emailAddress;
        customerId  = makeId();
    }
    
    public long getId() {
        return customerId;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    private long makeId() {
        return (long)(Math.random() * 99999999999999L);
    }

    public void setFirstName(String first) {
        firstName = first;
    }

    public void setSurName(String sur) {
        surName = sur;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}
