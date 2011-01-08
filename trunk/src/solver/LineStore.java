package solver;

import org.apache.commons.math.linear.RealVector;

//CREO QUE ESTA CLASE SE USABA UNICAMENTE PARA EL LINESEARCH, LO QUE SIGNIFICA QUE AHORA MISMO SOBRA
class LineStore {
	private RealVector _X;
	private double _f;
	private boolean _check;

	protected LineStore(RealVector x, double F, boolean check) {
		this._X = x;
		this._f = F;
		this._check = check;
	}

	protected void setRealVector(RealVector x) {
		this._X = x;
	}

	protected void setF(double F) {
		this._f = F;
	}

	protected void setCheck(boolean check) {
		this._check = check;
	}

	protected RealVector getVector() {
		return this._X;
	}

	protected double getF() {
		return this._f;
	}

	protected boolean getCheck() {
		return this._check;
	}
}