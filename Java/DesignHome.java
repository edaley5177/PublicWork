public class DesignHome
{
  public static void main(String[] args)
  {
    Rectangle bath = new Rectangle(6.0, 10.0);
	 bath.setWidth(7.0);
	 bath.setWidth(0.0);
	 bath.setWidth(-11.1);
	 bath.setWidth(8.5);
	 
	 bath.setHeight(10.5);
	 
	 double w = bath.getWidth();
	 double currentHeight = bath.getHeight();
	 
	 bath.setWidth(2.0);
	 bath.setHeight(4.0);
	 double area = bath.calculateArea();
	 
	 Rectangle livingroom = new Rectangle(22.0, 10.0);
	 Rectnagle kitchen = new Rectangle (12.0, 6.0);
	 
	 double totalArea = 
	   bath.calculateArea() + livingRoom.calculatearea() + 
		kitchen.calculateArea();
		System.out.printf("The total area is: %.1f\n", totalArea);
		
  }
}
class Rectangle
{
  private double width;
  private double height;
   public double calculateArea()
  {
    double area = width * height;
    return area;
  }
  
  public void setHeight(double newHeight)
  {
    if (newHeight > 0.0)
	   width = newHeight;
  }
  
  public void setWidth(double newWidth)
  {
    if (newWidth > 0.0)
	   width = newWidth;
	
  }
  
  public double getWidth(double Width)
  {
    return Width;
  }
  
  public Rectangle(double startWidth, double startHeight)
  {
    if (startWidth > 0.0)
      width = startWidth;
	 else 
	   width = 1.0;
	 if (startHeight > 0.0)
	   height = startHeight;
	 else
	   height = 1.0;
  }
  public double getHeight(double height)
  {
    return height;
  }
  public double calculateArea(double area, double height)
  {
    return width * height;
  }
}