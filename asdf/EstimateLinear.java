package asdf;

/**
 * 線形移動関数
 */
public class EstimateLinear implements EstimationFunction {
    public final static String name = "LinearFunction"; // 移動関数名
    
    double enemyVelocity; // 敵ロボットの速度 v
    double enemyHeading;  // 敵ロボットの進行方向 θ1
    double enemyInitialX; // 敵ロボットの初期位置のx座標
    double enemyInitialY; // 敵ロボットの初期位置のy座標
    
    /**
     * コンストラクタ
     * @param v 敵ロボットの速度 v
     * @param h 敵ロボットの進行方向 θ2
     * @param b 自ロボットから敵ロボットへの方向 θ1
     * @param d 自ロボットから敵ロボットまでの距離 d
     */
    public EstimateLinear(double v, double h, double b, double d){
        enemyVelocity = v;
        enemyHeading = h;
        enemyInitialX = d * Util.sin(b);
        enemyInitialY = d * Util.cos(b);
    }
    
    /**
     * 時刻tにおけるx座標を返すメソッド
     * @return 求めるx座標
     * @param t 時刻 t
     */
    public double getEstimatedX(double t) {
        double ve = enemyVelocity;
        double he = enemyHeading;
        double xe = enemyInitialX;
        return xe + ve * t * Util.sin(he);
    }
    
    /**
     * 時刻tにおけるy座標を返すメソッド
     * @return 求めるy座標
     * @param t 時刻 t
     */
    public double getEstimatedY(double t) {
        double ve = enemyVelocity;
        double he = enemyHeading;
        double ye = enemyInitialY;
        return ye + ve * t * Util.cos(he);
    }

    /**
     * toString() メソッド
     * @return 移動関数名
     */
    public String toString() {
        return getName();
    }

    /**
     * 移動関数名を返すメソッド
     * @return 移動関数名
     */
    public String getName() {
        return name;
    }
}
