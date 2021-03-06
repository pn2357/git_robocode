package asdf;
// 角度を-90度から90度 & 方向に変換
public  class ShortTurn implements Consts{
	private double _degree = 0;
	private int _dir = 1;

	public void shortturn(double degree) {
		degree = Util.normalizeDegree(degree);
		if (Math.abs(degree) <= QUATER_TURN) {
			_degree = degree;
			_dir = 1;
		} else {
			if (degree > QUATER_TURN) {
				_degree = degree - HARF_TURN;
			} else {
				_degree = degree + HARF_TURN;
			}
			_dir = -1;
		}
	}
		
		public double getDegree() {
			return _degree;
		}
		
		public int getDirection() {
			return _dir;
		}
}