import java.util.Set;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;                               
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

/** 
 * E164Format class takes phone number as string and process it to return in
 * E164 format. If the input is invalid, it returns string variable that 
 * contains "Invalid".   
 * @author Erman Gurses
 * @version 1.0
 * @since 2018-11-18
 */
public class E164Format{
    
    private String stringNumber;
    private String result;
    private PhoneNumber phoneNumber;

   /**
    *
    * Default Constructor
    */    
    public E164Format(){
        stringNumber = "";
    }

   /**
    * Overloaded Constructor
    * 
    *  @param number a String type input given by the user
    */      
    public E164Format( String number ){
        stringNumber = number;
    }
    
    /**
    * setNumber method sets stringNumber instance variable
    * 
    *  @param number a String type input given by the user
    *  @return void
    */  
    public void setNumber( String number ){
        stringNumber = number;
    }
    
    /**
    * getNumber method returns stringNumber
    * 
    *  @return stringNumber a String type variable was set by the user
    */  
    public String getNumber(){
        return stringNumber;
    }
    
    /**
    * convertNumber method conducts the whole process of the conversion. 
    * It calls processNumberByRegion method in the "for" loop with different 
    * region codes to validate it. If the returned string is valid, it returns
    * it to the caller. Otherwise, it keeps running the for loop. If there is
    * no valid number returned, it returns the caller "Invalid" string.
    * 
    * @return result a String type variable that contains the formatted number 
    * or "Invalid"
    */  
    public String convertNumber(){

        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Set<String> regionsSet = phoneNumberUtil.getSupportedRegions();
        
        for(String region : regionsSet) {
            
            result = processNumberByRegion(phoneNumberUtil,region);
            
            if(!result.equals("Invalid")) {
                
                return result;
            }
        }
        return result;
    }
    
    /**
    * Overloaded convertNumber method conducts the whole process of the conversion. 
    * It calls processNumberByRegion method in the "for" loop with different 
    * region codes to validate it. If the returned string is valid, it returns
    * it to the caller. Otherwise, it keeps running the for loop. If there is
    * no valid number returned, it returns the caller "Invalid" string.
    * 
    * @param number a String type input given by the user
    * @return result a String type variable that contains the formatted number 
    * or "Invalid"
    */ 
    public String convertNumber(String number){
        
        setNumber( number );
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Set<String> regionsSet = phoneNumberUtil.getSupportedRegions();
        
        for(String region : regionsSet) {
            
            result = processNumberByRegion(phoneNumberUtil,region);
            
            if(!result.equals("Invalid")) {
                
                return result;
            }
        }
        return result;
    }
    
    /**
    * processNumberByRegion method parses stringNumber based on region 
    * information and returns it as phoneNumber object. Then, it 
    * validates the object whether is a valid number or not. If the validation is 
    * successful, it formats phoneNumber object in E164 from and returns
    * it in "result" variable. If the validation is not successful, it 
    * returns "Invalid" string in "result" variable.
    * 
    * @param phoneNumberUtil PhoneNumberUtil type tool kit contains various 
    * methods to process  stringNumber
    * @param region is a String type region code 
    * @return result a String type variable that contains the formatted 
    * number or "Invalid"
    */
    private String processNumberByRegion(PhoneNumberUtil phoneNumberUtil, String region ) {
         
        result = "Invalid";
        try {
            
            phoneNumber = phoneNumberUtil.parse(stringNumber, region);   
            if( phoneNumberUtil.isValidNumber(phoneNumber) ){
                
                result = phoneNumberUtil.format(phoneNumber, PhoneNumberFormat.E164);
                return result;
                
            }
        } catch(NumberParseException e) {
            
        }
        return result;
    }
}
