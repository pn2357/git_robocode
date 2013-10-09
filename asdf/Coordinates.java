package asdf;

public class Coordinates {
	private double x;	//xÀ•W
	private double y;	//yÀ•W
	
	public Coordinates(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Coordinates()
	{
		this.x=0;
		this.y=0;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
}