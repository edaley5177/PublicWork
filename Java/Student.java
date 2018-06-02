class Student extends Person
{
  private int id;
  private Book book;
  public Student(String personName, int personAge, Book theirBook, int startId)
  {
    super(personName, personAge);
	 book = theirBook;
	 id = startId;
  }
  public String toString()
  {
    return "I am a Student," + super.toString() + ", with id:" + id + "," +  book.toString();
  }
  public static void main(String [] args)
  {
    Book cis1500 = new Book("Gaddis", "java");
    Student tim = new Student("Tim", 19, cis1500, 12345);
	 System.out.println(tim.toString());
  }
}