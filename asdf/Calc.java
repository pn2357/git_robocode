package asdf;

public class Calc
{
	//0~360�x�̊p�x����-180~180�x�̊p�x�ɕϊ�
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
