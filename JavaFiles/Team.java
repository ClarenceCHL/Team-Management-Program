/**
This is a container class that defines a team and its operations. 
@author Haolun Cheng
*/
public class Team 
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   /**
   Construct a team array storing team member objects and initialize the array size to 4.
   */
   public Team()
   {
       team = new TeamMember[GROW_SIZE];
   }
   
   /** 
   Finds the index of team member that needs to be removed from team. 
   @param team member object thats needs to be checked in list.
   @return index if team member found, not found otherwise.
   */
   private int find(TeamMember m)
   {
       for ( int i = 0; i < team.length; i ++ ){
           if ( m.equals(team[i]) ){
               return i;
           }
       }
       return NOT_FOUND;
   }
   
   /** 
   Increases team length by 4 new indecies. 
   Checks if team length equals number of members, then creates new list and copies old list into new list and re-references.
   */
   private void grow()
   {
      if ( team.length == numMembers ){
          TeamMember [] teamGrow = new TeamMember[team.length + GROW_SIZE];
          for ( int i = 0; i < team.length; i ++ ){
              teamGrow[i] = team[i];
          }
          team = teamGrow;
      }
   }
   
   /**
   Checks if the team list is empty.
   @return true if the team list is empty, false otherwise.
   */
   public boolean isEmpty()
   {
       if ( numMembers == 0 ){
           return true;
       }
       return false;
   }
   
   /**
   Appends new team member object to end of array.
   This methods first checks if there is space in the current list and then appends new item. It also, increases the number of members after appending.  
   @param new team member object that needs to be added. 
   */
   public void add(TeamMember m)
   {
       if ( numMembers == team.length ){
           grow();
       }
       team[numMembers] = m;
       numMembers ++;
   }
   
   /**
   Calls find method and finds the index of the team member to be removed.
   This method inserts the last item in the array to fill the index after object was removed. 
   It then sets the reference of the last item to null and decreases number of members by one. 
   @param team member object that needs to be removed.
   @return true if member was deleted, false otherwise. 
   */
   public boolean remove(TeamMember m)
   {
       int index = 0;
       if ( find(m) != NOT_FOUND ){
           int indexRemove = find(m);
           while ( team[index] != null ){
        	   index ++;
           }
           int indexLastMember = index - 1;
           team[indexRemove] = team[indexLastMember];
           team[indexLastMember] = null;
           numMembers--;
           return true;
       }
       return false;
   } 
   
   /**
   Checks if the team member list already contains team member object. 
   @param team member object that needs to be compared to items in array. 
   @return true if array contains member, false otherwise. 
   */
   public boolean contains(TeamMember m)
   {
       //System.out.println("Starting Contains");
       int index = 0;
       
       while ( team[index] != null ){
         if ( team[index].toString().equals(m.toString()) ){
             return true;   
        }
        index ++;
        if ( index == team.length ){
            break;
        }
        }
        //System.out.println("Ending Contains");
        return false;
      
   } 
   
   /**
   Prints the contents of the array
   toString method to print the objects in the array until array is null or loop reaches end of array. 
   */
   public void print()
   {
      //set up a for loop and call the toString() method
      int index = 0;
      while ( team[index] != null ){
           System.out.println(team[index].toString());
           index ++;
           if ( index == team.length ){
             break;  
           }
      }
   } 
}
