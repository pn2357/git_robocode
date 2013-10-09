package asdf;

//import java.awt.Color;

import java.awt.Color;

import robocode.*;

public class Exec extends AdvancedRobot
{
	static final int quaterturn=90;
	static final int halfturn=180;
	static final int fullturn=360;
	
	int count=0;			//出力確認用
	boolean flag=true;	
	double dist=10000;
	TurnCompleteCondition tcc =new TurnCompleteCondition(this);				//本体が回転完了したかどうかを調べるクラス
	RadarTurnCompleteCondition rtcc =new RadarTurnCompleteCondition(this);	//レーダーが回転完了したかどうかを調べるクラス
	Coordinates p1,p2;		//座標クラス
	Calc c =new Calc();		//計算クラス
	CalcCoordinates cc = new CalcCoordinates();		//座標計算クラス
	Attack attack= new Attack();
	Enemy enemy=new Enemy();
	
	private boolean shotDetected=false;
	
	public void run()
	{
		p1 = new Coordinates(getX(),getY());
		p2 = new Coordinates(500,500);
		
		addCustomEvent(tcc);		//本体の回転完了イベントの追加
		addCustomEvent(rtcc);		//レーダーの回転完了イベントの追加
		setAdjustGunForRobotTurn(true);
		setAdjustRadarForGunTurn(true);
		setAdjustRadarForRobotTurn(true);
		setColors(Color.black, Color.black, Color.black);
		setScanColor(Color.black);
		
		int turntemp=fullturn;
		
		//初期位置に移動
		setPosition();
		
		while(true)
		{
			if(flag) initialscan();
			if(shotDetected) out.println("avoid!!" + count++);//ここに回避アルゴリズムを明記
			setAhead(dist);
			setTurnRight(turntemp);
			waitFor(tcc);
			turntemp = -turntemp;
		}
	}
		
	
	public void setPosition()
	{
		//out.println((c.calcDegree(p1,p2)));
		turnRight(c.nomalizeDegree(cc.calcDegree(p1,p2))-getHeading());
		ahead(cc.calcDistance(p1,p2));
	}
	
	public void initialscan()
	{
		setTurnRadarRight(360);
		setTurnGunRight(360);
		setTurnRight(360);
	}
	
	double radarturn;
	double gunturn;
	static final double past=10;
	double lastEnergy=0.0;
	double nowEnergy;
	private double energyLoss=0.0;
	
	public void onScannedRobot(ScannedRobotEvent e)
	{
		flag=false;
		radarturn=c.nomalizeDegree(e.getBearing()+getHeading()-getRadarHeading());
		gunturn=c.nomalizeDegree(e.getBearing()+getHeading()-getGunHeading());
		radarturn+=(radarturn>0)?past:-past;
		setTurnRadarRight(radarturn);
		setTurnGunRight(gunturn);
		setFire(attack.bulletPower());
		//setTurnGunRight(0);
		//setTurnRight(0);
		
		/*nowEnergy=e.getEnergy();
		if(enemy.getEnergy()==0) enemy.setEnergy(nowEnergy);
		energyLoss=enemy.getEnergy()-nowEnergy;
		enemy.setEnergy(nowEnergy);
		
		if(0.1<=energyLoss && energyLoss<=3.0)
			shotDetected=true;
		else
			shotDetected=false;*/
	}
	
	public void onHitByBullet(HitByBulletEvent e)
	{
		double power=e.getPower();
		double energy=4.0*power + enemy.getEnergy();
		if(power > 1.0) energy += 2.0*(power-1.0);
		enemy.setEnergy(energy);
	}
	public void onCustomEvent(CustomEvent e)
	{
		if(e.getCondition() instanceof RadarTurnCompleteCondition)
		{
		}
		//this.removeCustomEvent(e.getCondition());	//一度使ったらもう呼ばないということ
	}
	
	public void onWin(WinEvent event)
	{
		setColors(Color.white, Color.white,Color.white);
		setScanColor(Color.white);
		while(true)
		{
		setTurnRight(360);
		setTurnGunRight(360);
		setTurnRadarRight(360);
		setAhead(0);
		execute();
		}
	}
}
