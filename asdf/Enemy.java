package asdf;

public class Enemy
{
    private double heading=0.0;
    private double bearing=0.0;
    private double velocity=0.0;
    private double distance=0.0;
    private double energy=0.0;
    
    /**
     * 自分のロボットを基準とする相手のロボットの相対角度
     */
    public void setBearing(double bearing) {
        this.bearing = bearing;
    }

    public double getBearing() {
        return bearing;
    }

    /**
     * 相手のロボットの向いている方向
     */
    public void setHeading(double heading) {
        this.heading = heading;
    }

    public double getHeading() {
        return heading;
    }

    /**
     * 相手のロボットの速度
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getVelocity() {
        return velocity;
    }

    /**
     * 相手のロボットまでの距離
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    /**
     * 相手のロボットの体力
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getEnergy() {
        return energy;
    }
}
