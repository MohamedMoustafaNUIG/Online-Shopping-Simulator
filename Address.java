public class Address
{
    private String street;
    private String city;
    private String zip;
    private String country;
    public Address()
    {
       this.street=" ";
       this.city=" ";
       this.zip=" ";
       this.country=" ";
    }

    public String getAddress()
    {
        return (street+","+city+","+zip+","+country);
    }
    
    public String getStreet()
    {
        return street;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public String getZip()
    {
        return zip;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public void setStreet(String street)
    {
        this.street = street;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public void setZip(String zip)
    {
        this.zip = zip;
    }
    
    public void setCountry(String country)
    {
        this.country = country;
    }
}
