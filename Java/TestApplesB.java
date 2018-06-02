class TestApplesB
{
  public static void main (String [] args)
  {
    AppleTree app = new AppleTree();
    app.report();
    app.grow();
    app.report();
    app.drop();
    app.report();
  }
}

class AppleTree
{
  int apples = 53;

  public void drop()
  {
    apples = 11;
    System.out.println("drop sees: " + apples);
  }

  public void grow()
  { 
    int apples = 70;
    System.out.println("grow sees: " + apples);
  }

  public void report()
  {
    System.out.println("apples: " + apples);
  }
}
