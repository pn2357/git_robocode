package asdf;

public class Calc
{
	//0~360“x‚ÌŠp“x‚©‚ç-180~180“x‚ÌŠp“x‚É•ÏŠ·
	public double nomalizeDegree(double degree)
	{
		degree%=360;
		
		if(degree>180)
		{
			degree-=360;
		}
		else if(degree<-180)
		{
			degree+=360;
		}
		return degree;
	}
}
