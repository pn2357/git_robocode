package asdf;

public class CalcCoordinates extends Calc
{
	static final double pi = 3.14159265358979323846;
	
	//２点間の距離を算出
	public double calcDistance(Coordinates p1,Coordinates p2)
	{
		double x1=p1.getX();
		double y1=p1.getY();
		double x2=p2.getX();
		double y2=p2.getY();
		
		return (Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
	}
	
	//数学の座標系上での角度をRobocode座標系の角度に変換
	public double toRoboDegree(double mathDegree)
	{
		return -mathDegree + 90;
	}
	
	public double toRoboRadian(double mathRadian)
	{
		return -mathRadian + pi/2;
	}
	
	
	
	//p1の方から見た場合の2点間の角度(Degree)
	public double calcDegree(Coordinates p1,Coordinates p2)
	{
		double x1=p1.getX();
		double y1=p1.getY();
		double x2=p2.getX();
		double y2=p2.getY();
			
		//逆正接Math.atan2 を使って，角度（ラジアン）を求める．    
		double radian = Math.atan2((y2 - y1), (x2 - x1));

		//ラジアンを度に変換
		double degree = Math.toDegrees(radian);

		//数学座標系での角度をロボコード座標系での角度に変換する
		degree = toRoboDegree(degree);

		return degree;
	}
	
	//p1の方から見た場合の2点間の角度(radian)
	public double calcRadian(Coordinates p1,Coordinates p2)
	{
		double x1=p1.getX();
		double y1=p1.getY();
		double x2=p2.getX();
		double y2=p2.getY();
			
		//逆正接Math.atan2 を使って，角度（ラジアン）を求める．    
		double radian = Math.atan2((y2 - y1), (x2 - x1));

		//数学座標系での角度をロボコード座標系での角度に変換する
		radian = toRoboDegree(radian);

		return radian;
	}
}
