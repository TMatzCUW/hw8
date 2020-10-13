import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BibleBookCollection 
{
	private ArrayList<hw8> theBooks;
	
	public BibleBookCollection()
	{
		this.theBooks = new ArrayList<hw8>();
	}
	
	public BibleBookCollection(String filename)
	{
		this();
		try
		{
			Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/" + "BibleBooks"));
			while(input.hasNext())
			{
				this.theBooks.add(new hw8(input.nextLine()));
			}
			input.close();
		}
		catch(Exception e) { e.printStackTrace();}
	}
	
	public void addBibleBook(hw8 b)
	{
		this.theBooks.add(b);
	}
	
	public void addBibleBook(String colonDelimitedData)
	{
		this.theBooks.add(new hw8(colonDelimitedData));
	}
	
	public hw8 getFirstBookGivenSearchTerm(String term) throws Exception
	{
		for(hw8 aBook : this.theBooks)
		{
			if(aBook.searchSummary(term))
			{
				return aBook;
			}
		}
		throw new Exception("Term not found exception");
	}
	public ArrayList<hw8> sortByName()
	{ 
		for (int i = 0; i < this.theBooks.size()-1; i++) 
            for (int j = 0; j < this.theBooks.size()-i-1; j++) 
                if (this.theBooks.get(j).getName().compareTo(this.theBooks.get(j+1).getName()) >= 0)
                {                     
                    hw8 temp = this.theBooks.get(j); 
                    this.theBooks.set(j, this.theBooks.get(j+1));
                    this.theBooks.set(j+1, temp); 
                }
        return(this.theBooks);
	}
	
	public ArrayList<hw8> sortByNumberOfChapters()
	{
		for (int i = 0; i < this.theBooks.size()-1; i++) 
            for (int j = 0; j < this.theBooks.size()-i-1; j++) 
                if (this.theBooks.get(j).getNumber_of_chapters() > this.theBooks.get(j+1).getNumber_of_chapters())
                {  
                    hw8 temp = this.theBooks.get(j); 
                    this.theBooks.set(j, this.theBooks.get(j+1));
                    this.theBooks.set(j+1, temp); 
                }
		return(this.theBooks);
	}
	
	public void displaySortedCollection()
	{
		for (int i = 0; i < this.theBooks.size(); i++)
		{
			System.out.println("Book Name: " + this.theBooks.get(i).getName() + 
					"(" + this.theBooks.get(i).getNumber_of_chapters() +
					" chapters) - " + this.theBooks.get(i).getSummary());
		}
	}
}