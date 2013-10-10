package asdf;

/**
 * 移動関数を表すインタフェース
 */
public interface EstimationFunction {
    /**
     * 時刻tにおけるx座標を返すメソッド
     * @return 求めるx座標
     * @param t 時刻 t
     */
    double getEstimatedX(double t);
    
    /**
     * 時刻tにおけるy座標を返すメソッド
     * @return 求めるy座標
     * @param t 時刻 t
     */
    double getEstimatedY(double t);

    /**
     * この移動関数の名前を返すメソッド
     * @return 移動関数名
     */
    String getName();
}
