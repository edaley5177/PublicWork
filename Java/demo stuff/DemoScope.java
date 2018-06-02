class DemoScope
{
  public static void main(String[] args)
  {
    Cat cat = new Cat();
    cat.jump();
	 
	 cat.scratch();
	 cat.print();
  }
}
class Cat
{
  int x = 1;
  public Cat(int x)
  {
    this.x = x;
  }
  public void jump()
  {
    int x = 100;
	 x++;
	 System.out.println("X: " + x);
  }
  public void scratch()
  {
    int x = 5;
	 x /= 2;
	 System.out.println("x: " + x);
  }
  public void print()
  {
    System.out.println("x: " + x);
  }

}