class Test
{
public static void main (String [] args)
{
MethodPrac mp = new MethodPrac();
mp.start();
}
}

class MethodPrac
{
int x = 20;

public void start()
{
int x = 33;
early();
System.out.println("start x: " + x);
}
public void early()
{
x += 100;
System.out.println("x: " + x);
}
}
