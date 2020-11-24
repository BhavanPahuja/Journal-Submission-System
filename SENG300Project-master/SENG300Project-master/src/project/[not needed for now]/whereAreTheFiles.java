package project;

import java.io.File;

public class whereAreTheFiles
{
	public static void main(String[]args)
	    {
	        File curDir = new File(".");
	        getAllFiles(curDir);
	    }
	
	private static void getAllFiles(File curDir)
	{
		File[] filesList = curDir.listFiles();
		for(File f : filesList)
		{
			if(f.isDirectory())
			System.out.println(f.getName());
	        if(f.isFile())
	        {
	        	System.out.println(f.getName());
	        }
		}
	}
}
