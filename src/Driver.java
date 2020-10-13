  
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		BibleBookCollection theNewTestament = new BibleBookCollection("BibleBooks");
		try
		{
			theNewTestament.sortByName();
			theNewTestament.displaySortedCollection();
		}
		catch(Exception e)
		{
			System.out.println("No Book Found");
		}
		
	}
}