public class MyReading
{
  public static void main(String[] args)
  
 {
   Book book1 =  new Book("Moby Dick", 382);
 }
}

class Book
{
  private String title;
  private int pages;
  public int getPages()
  {
    return pages;
  }
  
  public void Book(String newTitle, int newPages)
  {
    title = newTitle;
	 
	 if (newPages > 0)
	   pages = newPages;
	 else 
	   pages = 1;
    
  }
}