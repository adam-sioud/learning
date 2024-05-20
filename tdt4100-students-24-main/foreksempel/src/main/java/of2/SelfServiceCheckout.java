package of2;

import java.util.Arrays;
import java.util.List;

public class SelfServiceCheckout {

    private String day;
    private String phoneNumber;
    private Double totalSum = 0.0;

    public static final List<String> days = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");

    public SelfServiceCheckout(String day){
        this.vaildDay(day);
        this.day = day;
    }

    private void vaildDay(String day){
        if(!days.contains(day)){
            throw new IllegalArgumentException("Not a valid day");
        }
    }

    public void setPhoneNumber(String phoneNumber){
        if(this.validPhoneNumber(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }
        else{
            throw new IllegalArgumentException("Not a valid phone number");
        }

    }

    private boolean validPhoneNumber(String phoneNumber){
        String cleanPhoneNumber = phoneNumber.replaceAll("\\s", "");

        if (cleanPhoneNumber.startsWith("0047")){
            if(!(cleanPhoneNumber.length() == 12)){
                return false;
            }

            if(!(cleanPhoneNumber.startsWith("00479")|| cleanPhoneNumber.startsWith("00474"))){
                return false;
            }

        }

        else if (cleanPhoneNumber.startsWith("+47")){
            if(!(cleanPhoneNumber.length() == 11)){
                return false;
            }
            if(!(cleanPhoneNumber.startsWith("+479")|| cleanPhoneNumber.startsWith("+474"))){
                return false;
            }
        }
        
        else{
            return false;
        }

        String subCleanPhoneNumber = cleanPhoneNumber.substring(cleanPhoneNumber.length()-8);

        char[] chars = subCleanPhoneNumber.toCharArray();

        for(char c: chars){
            if(!Character.isDigit(c)){
                return false;
            }

        }

        return true;


    }

    public void scanItem(String name, Double price, int number){
        if(day.equals("thu")){
            if(this.validPhoneNumber(this.phoneNumber)){
                this.totalSum += price*0.9;
                System.out.println(number + "x" + price + ":" + (price*0.9));
            }
            else{
                this.totalSum += price;
                System.out.println(number + "x" + price + ":" + (price));
            }
        
        }

        else{
            this.totalSum += price;
            System.out.println(number + "x" + price + ":" + (price));
        }

    }



    public static void main(String[] args) {
        SelfServiceCheckout s1 = new SelfServiceCheckout("thu");
        s1.setPhoneNumber("0047 41289988");
        s1.scanItem("jordbær", 10.0, 1);

    }
    
}
