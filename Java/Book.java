public class Book
{
  
  private String author;
  private String title;
  
  public Book (String startAuthor, String startTitle)
  {
    author = startAuthor;
	 title = startTitle;
  }
  public String toString()
  {
	 return "Author: " + author + " Title: " + title;
  }
  
  public static void main(String [] args)
  {
    Book fun = new Book ("Seuss", "Cat in the hat");
	 String s = fun.toString();
	 System.out.println(s);
	 fun.setAuthor("Dr. Suess");
	 
	 	 
  }
  public void setAuthor(String a)
  {
   author = a;
  }
  

}