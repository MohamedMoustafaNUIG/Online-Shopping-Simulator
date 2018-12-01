    import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
public class Payment
{
    private Order order;
    private Customer customer;
    private String cardType;
    private String cardNum;
    private String date;
    private Address billingAddress;
    private String bankName;
    private boolean valid;
    private String remark;
    public Payment(Order order,String cardType,String cardNum,String date,Address billAdd,String bankName)
    {
        this.order=order;
        customer=order.getCustomer();
        this.cardType=cardType;
        this.cardNum=cardNum;
        this.date=date;
        billingAddress=billAdd;
        customer.setBillingAddress(billAdd);
        this.bankName=bankName;
        valid=this.isValid(cardType,cardNum,date);
        order.sendEmail(valid,this.billingAddress,remark);
    }
    
    public boolean checkExpiry(String inDate)
    {
        SimpleDateFormat formatD = new SimpleDateFormat("dd");
        SimpleDateFormat formatM = new SimpleDateFormat("MM");
        SimpleDateFormat formatY = new SimpleDateFormat("yyyy");
        
        String day_today = formatD.format(new Date());
        String month_today = formatM.format(new Date());
        String year_today = formatY.format(new Date());
        
        StringTokenizer st = new StringTokenizer(inDate,"/");
        String day_inDate = st.nextToken();
        String month_inDate = st.nextToken();
        String year_inDate = st.nextToken();

        if(Integer.parseInt(year_today)==Integer.parseInt(year_inDate))
        {
            if(Integer.parseInt(month_today)==Integer.parseInt(month_inDate))
            {
                if(Integer.parseInt(day_today)==Integer.parseInt(day_inDate))
                {
                    return false;
                }else if(Integer.parseInt(day_today)<Integer.parseInt(day_inDate))
                {
                    return true;
                }else
                {
                    return false;
                }
            }else if(Integer.parseInt(month_today)<Integer.parseInt(month_inDate))
            {
                return true;
            }else
            {
                return false;
            }
        }else if(Integer.parseInt(year_today)<Integer.parseInt(year_inDate))
        {
            return true;
        }else
        {
            return false;
        }
    }
    
    public boolean isValid(String cardType,String cardNum,String date)
    {
        if(cardType.equals("MasterCard") || cardType.equals("Visa")){
            if(cardNum.length()==16){
               if(checkExpiry(date)){
                    return true;
                }else{
                    remark="Credit Card Expired";
                    return false;
                }
            }else{
                remark="Invalid Credit Card Number";
                return false;
            }
        }else{
            remark="Invalid Credit Card Type";
            return false;
        }
    }
}
