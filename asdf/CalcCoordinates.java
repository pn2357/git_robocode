package asdf;

public class CalcCoordinates extends Calc
{
	static final double pi = 3.14159265358979323846;
	
	//�Q�_�Ԃ̋������Z�o
	public double calcDistance(Coordinates p1,Coordinates p2)
	{
		double x1=p1.getX();
		double y1=p1.getY();
		double x2=p2.getX();
		double y2=p2.getY();
		
		return (Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
	}
	
	//���w�̍��W�n��ł̊p�x��Robocode���W�n�̊p�x�ɕϊ�
	public double toRoboDegree(double mathDegree)
	{
		return -mathDegree + 90;
	}
	
	public double toRoboRadian(double mathRadian)
	{
		return -mathRadian + pi/2;
	}
	
	
	
	//p1�̕����猩���ꍇ��2�_�Ԃ̊p�x(Degree)
	public double calcDegree(Coordinates p1,Coordinates p2)
	{
		double x1=p1.getX();
		double y1=p1.getY();
		double x2=p2.getX();
		double y2=p2.getY();
			
		//�t����Math.atan2 ���g���āC�p�x�i���W�A���j�����߂�D    
		double radian = Math.atan2((y2 - y1), (x2 - x1));

		//���W�A����x�ɕϊ�
		double degree = Math.toDegrees(radian);

		//���w���W�n�ł̊p�x�����{�R�[�h���W�n�ł̊p�x�ɕϊ�����
		degree = toRoboDegree(degree);

		return degree;
	}
	
	//p1�̕����猩���ꍇ��2�_�Ԃ̊p�x(radian)
	public double calcRadian(Coordinates p1,Coordinates p2)
	{
		double x1=p1.getX();
		double y1=p1.getY();
		double x2=p2.getX();
		double y2=p2.getY();
			
		//�t����Math.atan2 ���g���āC�p�x�i���W�A���j�����߂�D    
		double radian = Math.atan2((y2 - y1), (x2 - x1));

		//���w���W�n�ł̊p�x�����{�R�[�h���W�n�ł̊p�x�ɕϊ�����
		radian = toRoboDegree(radian);

		return radian;
	}
}
