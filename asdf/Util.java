package asdf;

public class Util implements Consts {
	public  Util() {
	}

    // 引数の正負を返す
    public static double sign(double x) {
        return (x > 0.0 ? 1 : (x < 0.0 ? -1 : 0));
    }

    // sin関数を360度単位で使用できるようにするためのメソッド
    public static double sin(double v) {
        return Math.sin(Math.toRadians(v));
    }
    
    // cos関数を360度単位で使用できるようにするためのメソッド
    public static double cos(double v) {
        return Math.cos(Math.toRadians(v));
    }
    
    // atan関数を360度単位/ロボコード座標系で使用できるようにするためのメソッド
    public static double atan(double y, double x) {
        return QUATER_TURN - Math.toDegrees(Math.atan2(y, x));
    }
    

    //  ロボコード座標系での角度を、数学座標系に変換
	public static double toMathDegree(double roboDegree) {
		return -roboDegree + QUATER_TURN;
	}
    
    //  数学座標系での角度を、ロボコード座標系に変換
	public static double toRoboDegree(double mathDegree) {
		return -mathDegree + QUATER_TURN;
	}

	// 角度を-180度から180度に正規化
	public static double normalizeDegree(double degree) {
		degree = degree % FULL_TURN;

		if (degree < -HARF_TURN) {
			degree += FULL_TURN;
		}
		if (degree > HARF_TURN) {
			degree -= FULL_TURN;
		}

		return degree;
	}

	// 角度を-90度から90度 & 方向に変換
	public  class ShortTurn {
		private double degree = 0;
		private int dir = 1;

		public ShortTurn(double degree) {
			degree = normalizeDegree(degree);
			if (Math.abs(degree) <= QUATER_TURN) {
				this.degree = degree;
				this.dir = 1;
			} else {
				if (degree > QUATER_TURN) {
					this.degree = degree - HARF_TURN;
				} else {
					this.degree = degree + HARF_TURN;
				}
				this.dir = -1;
			}
		}

		// 角度を返す [-90,90]
		public double getDegree() {
			return degree;
		}

		// 方向を返す +1,-1
		public int getDirection() {
			return dir;
		}
	}
}