package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Checks the username and password against the CSV database and verifies that the credentials given matches with a record in the database.
If so, gives the user access to the system. If not, then spits out an error message.

As an Editor, I want to be able to log into my account easily 

*/

/*
public class login
{
	
	private static Scanner usersDB;
	
	public static void main(String[] args)
	{
		String username = "karynn";
		String password = "999";
		String filename = "users.txt";
		
		logins(username,password,filename);
	}


	public static void logins(String username, String password, String filename)
	{
		boolean found = false;
		String tempUsername = "";
		String tempPassword = "";
		
//		try
//		{
			try {
				usersDB = new Scanner(new File ("users.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //reads the users.csv file 
			usersDB.useDelimiter("[,\n]");			//each field is separated by a comma, and each record separated by a new line
		
			while(usersDB.hasNext() && !found)
			{
				tempUsername = usersDB.next();
				tempPassword = usersDB.next();
				
				if (tempUsername.trim().contentEquals(username.trim()) && tempPassword.trim().contentEquals(password.trim()))
				{
					found = true;
				}
			}
			usersDB.close();
			System.out.println(found);
//		}
//		catch(Exception e)
//		{
			System.out.println("Something ain't right, and it is not because of your username and password!");
//		}
		
	}
}*/