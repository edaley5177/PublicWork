
public class Demo
{
  public static void main(String [] args)
  {
    int cost = 32;
    int extra = 0;

    if (cost > 50)
    extra += 10;

    if (cost > 100)
    extra += 5;

    if (cost > 200)
    extra += 2;

    System.out.println(extra);
  }
}
