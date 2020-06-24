/**
This class defines the basic structures and operations of a team member.
A team member object is created by having both name and date fields.
@author Haolun Cheng
*/
public class TeamMember 
{
   private String name;
   private Date   startDate;
   
   /**
   Define a TeamMember object by assigning each parameter to each global variable.
   @param nm: name field of a TeamMember object.
   @param date: date field of a TeamMember object.
   */
   public TeamMember(String nm, Date date)
   {
       this.name = nm;
       this.startDate = date;
   }
   
   /**
   This method is a getter method for the date field of a TeamMember object.
   @return the date that a team member joined the team.
   */
   public Date getStartDate()
   {
       return this.startDate;
   }
   
   /**
   Check if two team members have exactly the same name and the same date.
   @return true if two team members have the same name the date, false otherwise.
   */
   public boolean equals(Object obj)
   {
      //name and startDate must be the same
       if ( obj instanceof TeamMember ){
           TeamMember m = (TeamMember) obj;
           return m.name.equals(this.name) && m.getStartDate().equals(this.startDate);
       }
       return false;
   }
   
   /**
   Display a string representation of name + date fields of a team member.
   @return string representation of name and startDate fields of TeamMember object.
   */
   public String toString()
   {
       //name + " " + startDate;
       return name + " " + startDate;
   }

   public static void main(String [] args)
   {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
       Date testDate1 = new Date("3/4/1998");
       Date testDate2 = new Date("2/3/2020");
       TeamMember test1 = new TeamMember("Surya", testDate1);
       TeamMember test2 = new TeamMember("Surya", testDate2);
       TeamMember test3 = new TeamMember("Surya", testDate1);
       
       System.out.println(test2.toString()); //Test the toString() method
       System.out.println(test1.getStartDate()); //Test the getStartDate() method
       
       //Test equals() method case 1
       if ( test1.equals(test2) ){
           System.out.println("Case 1: equal");
       }
       else {
           System.out.println("Case 1: not equal");
       }
       
       //Test equals() method case 2
       if ( test1.equals(test3) ){
           System.out.println("Case 2: equal");
       }
       else {
           System.out.println("Case 2: not equal");
       }
   }
}