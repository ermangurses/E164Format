**** README ****

This program is develop in Unix environment.
Please use command line interface to compile and run the commands below:

** Before Compile **

After, unzip the file;

Please download the jar file from:
https://github.com/ermangurses/E164Format/blob/master/lib/libphonenumber-8.9.9.jar
(This jar file cannot be sent via email)

Then put this file under the "lib" directory 
Here is the path for that --> "E164Format/lib/"

Then, go to under the directory called E164Format using command line
The example command to go to the directory is below:
cd path-to-directroy/E164Format

** How to compile **

make <ENTER>

** How to run **

make run<ENTER>

** How to remove executables **

make clean<ENTER>

**** Description ****

In this code, we have two files: E164Format (implementation)
and E164FormatTest (driver)

E164Format is the class has all the functionalities to convert given 
input string into E164 format. It has six methods listed below:

1) Default constructor      --->  public E164Format()
2) Overloaded constructor   --->  public E164Format( String number )
3) Public Method            --->  public void setNumber( String number )
4) Public Method            --->  public String getNumber()
5) Public Method            --->  public String convertNumber()
6) Public Overloaded Method --->  public String convertNumber(String number)
7) Private Method           --->  private String processNumberByRegion(PhoneNumberUtil phoneNumberUtil, String region )

** For the solution, I used https://github.com/googlei18n/libphonenumber 
library that provides various functionalities including phone number validation
and E164 conversion. 

** These functionalities are used in processNumberByRegion method. This method 
parses stringNumber based on region information and returns it as phoneNumber 
object. Then, it validates the object whether is a valid number or not. If the
validation is successful, it formats phoneNumber object in E164 form and 
returns it in "result" variable. If the validation is not successful, it returns
"Invalid" string in "result" variable. This method is called by convertNumber 
methods.

** convertNumber methods conduct the whole process of the conversion. It calls
processNumberByRegion method in the "for" loop with different region codes to 
validate it. If the returned string is valid, it returns it to the caller. 
Otherwise, it keeps running the "for" loop. If there is no valid number returned, 
it returns the caller "Invalid" string.

** convertNumber methods fetch the all region codes and send one of each to
processNumberByRegion method in a random order (not alphabetical since it 
is a hashset) in the "for" loop. The phone number might be valid with more 
than one region codes but convertNumber methods return the first valid match 
to the driver then exits from the loop. So there might be other valid numbers 
with different region codes that program did not check. According to code 
challenge description, one valid number with proper E164 form is enough. 
 
** The rest of the methods are the classic get and set methods that all of the 
classes have in object-oriented programming methodology to provide encapsulation.

**** External Resources ****

https://en.wikipedia.org/wiki/E.164
https://www.regextester.com/17
https://regexr.com/3c53v
https://github.com/googlei18n/libphonenumber
https://libphonenumber.appspot.com/
https://www.twilio.com/docs/glossary/what-e164#examples-of-e164-numbers
