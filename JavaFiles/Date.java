import java.util.StringTokenizer; 
/**
This class validates the date input including the leap year.    
A date object is created and the toString method returns the date in the appropriate format.
@author Haolun Cheng
*/
public class Date 
{
   private int  day;
   private int  month;
   private int  year;
   
   /**
   StringTokenizer splits string into tokens to create date object.
   @param string that need to be split into tokens.
   */
   public Date(String d)
   {
      //use StringTokenizer to parse the String and create a Date object  
	  StringTokenizer st = new StringTokenizer(d,"/");
      String tok1,tok2,tok3;
      if ( st.countTokens() == 3 ){
          int da, m, y;
          tok1 = st.nextToken();
          tok2 = st.nextToken();
          tok3 = st.nextToken();
          m = Integer.parseInt(tok1);
          da = Integer.parseInt(tok2);
          y = Integer.parseInt(tok3);
          month = m;
          day = da;
          year = y;
        }
        else {
            month = 0;
            day = 0;
            year = 0;
        }     
   }
   
   /**
   Initialize date object by assigning each field of the date parameter to each global variable.
   @param date object that need to be initialized.
   */
   public Date(Date d)
   {
      //this is a constructor
      this.month = d.month;
      this.day = d.day;
      this.year = d.year;
   }      
   
   /**
   Checks the date input to validate if the date can exist or not in a caldander year including leap years. 
   @return true if date is valid, false otherwise.
   */
    
   public boolean isValid()
   {
       
       if ( day > Month.DAYS_ODD || day < Month.JAN ){
           return false;
       }
       if ( month > Month.DEC || month < Month.JAN ){
           return false;
        }
       if ( year <= Month.MIN ){
           return false;
        }
        
       if ( month == Month.APR || month == Month.JUN || month == Month.SEP || month == Month.NOV ){
           if ( day == Month.DAYS_ODD ){
               return false;
            }
        }
       
       if ( month == Month.JAN || month == Month.MAR || month == Month.MAY || month == Month.JUL || 
            month == Month.AUG || month == Month.OCT || month == Month.DEC ){
            return true;
        }
       
       boolean leap_year = false;
       
       if ( year % Month.QUATERCENTENNIAL == Month.MIN ){
               leap_year = true;
            }
           else if ( year % Month.CENTENNIAL == Month.MIN ){
               leap_year = false;
            }
           else if ( year % Month.QUADRENNIAL == Month.MIN ){
               leap_year = true;
          }
       
       if ( month == Month.FEB && leap_year && day > Month.DAYS_FEB+1 ){
           return false;
          }
    
       if ( month == Month.FEB && !leap_year && day > Month.DAYS_FEB ){
           return false;
          }
          
       return true;
    }
   
   /**
   Creates string representation of a date object.
   @return string representation of month/day/year.
   */
   @Override
   public String toString()
   {
       //use the format "month/day/year"
       return month + "/" + day + "/" + year;
   }
   
   /**
   Check if two dates are equal.
   @param date object that needs to be compared.
   @return true if two dates are equal, false if two dates are not equal.
   */
   @Override
   public boolean equals(Object obj)
   {
       if ( obj instanceof Date ){
           Date temp = (Date) obj;
           return (temp.day == this.day) && (temp.month == this.month) && (temp.year == this.year);
       }
       return false;
   }

   public static void main(String [] args) 
   {
        Date test1 = new Date("2/29/2020");
        Date test2 = new Date("2/2/0");
        Date test3 = new Date("2/29/2020");
        Date test4 = new Date("3/4/1998");
        
        //Test isValid() method case 1:
        if ( test1.isValid() == true ){
        	System.out.println("Date test case 1:is valid!");
        }
        else {
        	System.out.println("Date test case 1:is invalid!");
        }
        
        //Test isValid() method case 2:
        if ( test2.isValid() == true ){
        	System.out.println("Date test case 2:is valid!");
        }
        else {
        	System.out.println("Date test case 2:is invalid!");
        }
        
        //Test equals() method case 1:
        if ( test1.equals(test3) == true ){
        	System.out.println("equal");
        }
        else {
        	System.out.println("not equal");
        }
        
        //Test equals() method case 2:
        if ( test4.equals(test3) == true ){
        	System.out.println("equal");
        }
        else {
        	System.out.println("not equal");
        }
        
        //Test toString() method:
        System.out.println(test1.toString());
        System.out.println(test4.toString());
   }
}