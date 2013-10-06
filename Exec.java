package asdf;

//import java.awt.Color;

import robocode.*;

public class Exec extends AdvancedRobot
{
	static final int quaterturn=90;
	static final int halfturn=180;
	static final int fullturn=360;
	
	int count=0;			//�o�͊m�F�p
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
		
		//�����ʒu�Ɉړ�
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
		
		//�t����Math.atan2 ���g���āC�p�x�i���W�A���j�����߂�D    
		double radian = Math.atan2((y2 - y1), (x2 - x1));

		//���W�A����x�ɕϊ�
		double degree = Math.toDegrees(radian);

		//���w���W�n�ł̊p�x�����{�R�[�h���W�n�ł̊p�x�ɕϊ�����
		degree = toRoboDegree(degree);

		return degree;
	}

		//(x1, y1)����(x2, y2)�ւ̋��������߂�
	public static double calcDistance(
		double x1,
		double y1,
		double x2,
		double y2) {
		
		//�O�����̒藝���g���āC2�_�̋������Z�o
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
		//this.removeCustomEvent(e.getCondition());	//��x�g����������Ă΂Ȃ��Ƃ�������
	}
}
