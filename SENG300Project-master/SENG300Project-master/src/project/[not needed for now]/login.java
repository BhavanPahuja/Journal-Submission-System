package project;

import java.io.File;
import java.util.Scanner;

/*
Checks the username and password against the CSV database and verifies that the credentials given matches with a record in the database.
If so, gives the user access to the system. If not, then spits out an error message.
As an Editor, I want to be able to log into my account easily 
*/

/*
public class login
{
	
	private static Scanner input;
	
	public static void main(String[] args)
	{

		String username = "karynn";
		String password = "991";
//Absolute		String filename = "C:\\Users\\RynnServer\\eclipse-workspace\\SENG300Project\\bin\\project\\users.csv";
		String filename = "users.csv"; //Relative path which is better
		
		logins(username,password,filename);
	}
	
	public static void logins(String username, String password, String filename)
	{
		boolean found = false;
		String userNameInput = userNameField.getText();
		String passwordInput = passwordField.getText();

		String tempUsername = "";
		String tempPassword = "";
		
		try
		{
			input = new Scanner(new File (filename)); //reads the users.csv file 
			input.useDelimiter("[,\n]");			//each field is separated by a comma, and each record separated by a new line
		
			while(input.hasNext() && !found)
			{
				tempUsername = input.next();
				tempPassword = input.next();
				
				if (tempUsername.trim().contentEquals(username.trim()) && tempPassword.trim().contentEquals(password.trim()))
				{
					found = true;
				}
			}
			input.close();
			System.out.println(found);
		}
		catch(Exception e)
		{
			System.out.println("Something ain't right, and it is not because of your username and password!");
		}
		
	}
}
*/