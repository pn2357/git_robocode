package asdf;

//import java.awt.Color;

import robocode.*;

public class Exec extends AdvancedRobot
{
	static final int quaterturn=90;
	static final int halfturn=180;
	static final int fullturn=360;
	
	int count=0;			//出力確認用
	boolean flag=true;	
	double dist=10000;
	TurnCompleteCondition c =new TurnCompleteCondition(this);
	RadarTurnCompleteCondition rc =new RadarTurnCompleteCondition(this);
	
	double tx=500;
	double ty=500;
	double sx;
	double sy;
	
	public void run()
	{
		sx=getX();
		sy=getY();
		
		addCustomEvent(c);
		addCustomEvent(rc);
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		setAdjustRadarForRobotTurn(true);
		
		int turntemp=fullturn;
		
		//初期位置に移動
		setPosition();
		
		while(true)
		{
			if(flag)
			{
				initialscan();
			}
			
			setAhead(dist);
			setTurnRight(turntemp);
			waitFor(c);
			turntemp = -turntemp;
		}
	}
	
	public void setPosition()
	{
		out.println((calcDegree(sx,sy,tx,ty)));
		turnRight(nomalizeDegree(calcDegree(sx,sy,tx,ty))-getHeading());
		ahead(calcDistance(sx,sy,tx,ty));
	}
	
	public  double calcDegree(
		double x1,
		double y1,
		double x2,
		double y2){
		
		//逆正接Math.atan2 を使って，角度（ラジアン）を求める．    
		double radian = Math.atan2((y2 - y1), (x2 - x1));

		//ラジアンを度に変換
		double degree = Math.toDegrees(radian);

		//数学座標系での角度をロボコード座標系での角度に変換する
		degree = toRoboDegree(degree);

		return degree;
	}

		//(x1, y1)から(x2, y2)への距離を求める
	public static double calcDistance(
		double x1,
		double y1,
		double x2,
		double y2) {
		
		//三平方の定理を使って，2点の距離を算出
		double distance =
			Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

		return distance;
	}
	
	public static double toRoboDegree(double mathDegree) {
		return -mathDegree + 90;
	}
	
	public void initialscan()
	{
		setTurnRadarRight(360);
		setTurnGunRight(360);
		setTurnRight(360);
	}
	
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
	
	double radarturn=0;
	double gunturn=0;
	double past=10;
	
	public void onScannedRobot(ScannedRobotEvent e)
	{
		flag=false;
		radarturn=nomalizeDegree(e.getBearing()+getHeading()-getRadarHeading());
		gunturn=nomalizeDegree(e.getBearing()+getHeading()-getGunHeading());
		radarturn+=(radarturn>0)?past:-past;
		setTurnRadarRight(radarturn);
		setTurnGunRight(gunturn);
		setFire(2);
		//setTurnGunRight(0);
		//setTurnRight(0);
	}
	
	public void onCustomEvent(CustomEvent e)
	{
		if(e.getCondition() instanceof RadarTurnCompleteCondition)
		{
		}
		//this.removeCustomEvent(e.getCondition());	//一度使ったらもう呼ばないということ
	}
}
