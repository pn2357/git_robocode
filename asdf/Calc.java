package asdf;

public class Calc
{
	//0~360度の角度から-180~180度の角度に変換
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
