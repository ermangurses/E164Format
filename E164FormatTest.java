/** 
 * E164FormatTest is the driver class that tests E164Format implementation
 * @author Erman Gurses
 * @version 1.0
 * @since 2018-11-18
 */

import java.util.Set;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Scanner;

public class E164FormatTest {

    public static void main(String[] args) {

        // Create instance of the E164Format Class
        E164Format formatNumber = new E164Format();

        // Variable definitions
        Scanner command = new Scanner(System.in);
        Scanner number  = new Scanner(System.in);
        boolean next    = true;
        boolean first   = true;
        
        // do-while loop to take input and give result
        do{
            // The first run is unique
            if(first){
                first = false;
                System.out.println("Enter the number:");
                formatNumber.setNumber( number.nextLine() );
                System.out.println(formatNumber.convertNumber());

            } else { // After the first run
                System.out.println("Enter 'next' if you want to continue. Otherwise enter 'exit'");
                switch(command.nextLine()){

                    case "next":
                        System.out.println("Enter the number:");
                        formatNumber.setNumber( number.nextLine() );
                        System.out.println(formatNumber.convertNumber());
                        break;
                    case "exit":
                        System.out.println("Application Closed");
                        next = false;
                        break;
                    default:
                        System.out.println("Command not recognized!");
                        break;
                }
            }
        }while(next);
    }
}

