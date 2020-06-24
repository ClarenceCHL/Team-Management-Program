import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class allows users to modify and print the team member's list.
 * 
 * @author Haolun Cheng
 */

public class ProjectManager {
	// Scanner stdin;
	Scanner stdin = new Scanner(System.in);
	Team team = new Team();
	static boolean done = false;
	// Team cs213;

	/**
	 * Takes user input to add, remove, print and quit program. The command is split
	 * into tokens using a String Tokenizer contructor to add or remove a team
	 * member. Depending on the command, the add or remove method is called with the
	 * respective tokens needed.
	 */
	public void run() {
		while (!done) {
			String command = stdin.nextLine();
			switch (command.charAt(0)) {
			case 'A': {
				StringTokenizer st = new StringTokenizer(command, " ");
				if (st.countTokens() == 3) {
					String tok1 = st.nextToken();
					String tok2 = st.nextToken();
					String tok3 = st.nextToken();

					add(tok2, tok3);
				} else {
					System.out.println("Invalid input, Please enter command, name, and date. ");
				}
				break;
			}
			case 'R': {
				StringTokenizer st = new StringTokenizer(command, " ");
				if (st.countTokens() == 3) {
					String tok1 = st.nextToken();
					String tok2 = st.nextToken();
					String tok3 = st.nextToken();

					remove(tok2, tok3);
				} else {
					System.out.println("Invalid input, Please enter command, name, and date.");
				}
				break;
			}
			case 'P':
				print();
				break;
			case 'Q': {
				output();
				done = true; // Terminates program.
				break;

			}
			default:
				System.out.println("Command " + "'" + command.charAt(0) + "'" + " not supported!");

			}
		}
		// write java code before you terminate the program
	} // run()

	/**
	 * Adds person with given name and date. First checks if date is valid. If
	 * valid, then creates new team member object and then using the contains()
	 * method, checks again if the team member already exists. Add() prints out if
	 * the date is invalid and the status of the team member user is trying to add.
	 * 
	 * @param name and date of person being added.
	 */
	private void add(String name, String date) {
		// must check if the date is valid
		// must call the contains() method to check if a given
		// team member is in the team already

		Date dd = new Date(date);
		if (dd.isValid()) {
			TeamMember temp = new TeamMember(name, dd);
			if (team.contains(temp)) {
				System.out.println(name + " " + dd + " " + "is already in the team.");
			} else {
				team.add(temp);
				System.out.println(name + " " + dd + " " + "has joined the team.");
			}
		} else {
			System.out.println(date + " is not a valid date!");
		}

	}

	/**
	 * Deletes person with given name and date from the list. Does nothing if name
	 * and date doesnt appear in the list.
	 * 
	 * @param name and date of person to delete
	 */
	private void remove(String name, String date) {
		// must check if the date is valid
		Date dd = new Date(date);
		TeamMember temp = new TeamMember(name, dd);
		if (dd.isValid() && team.contains(temp)) {
			team.remove(temp);
			System.out.println(name + " " + dd + " " + "has left the team.");
		} else {
			System.out.println(name + " " + dd + " " + "is not a team member.");
		}
	}

	/**
	 * Prints the team list. Calls isEmpty() if team has 0 members and calls print()
	 * method if team exists.
	 */
	private void print() {
		// must check if the team has 0 members.
		if (team.isEmpty()) {
			System.out.println("We have 0 team members!");
		} else {
			System.out.println("We have the following team members:");
			team.print();
			System.out.println("-- end of the list --");
		}
	}

	/**
	 * Prints team list.
	 */
	private void output() {
		// print with SOP and exit
		System.out.println("We have the following team members:");
		team.print();
		System.out.println("-- end of the list --");
		System.out.println("The team is ready to go!");
	}
} // ProjectManager