package doglegMethod;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;

import solver.PrepareUncmin;
import solver.nodo;
import evaluation.DiffAndEvaluator;

public class Lmdif_fcn {

	private static RealVector F;

	/**
	 * 
	 * @param m
	 *            = number of equations
	 * @param n
	 *            = number of functions
	 * @param x
	 *            = point vector
	 * @param fvec
	 *            = vector of the functions evaluated in x
	 * @param iflag
	 *            = if 1 then evaluate only fvec if you use this interface then
	 *            the jacobian will be evaluated numerically
	 */
	public static void fcn(int m, int n, double x[], double fvec[], int iflag[]) {
		Uncmin_methods.IntroduceValues(x);
		if (iflag[1] == 1) {
			MakeF();
			for (int i = 0; i < F.getDimension(); i++)
				fvec[i + 1] = F.getEntry(i);
		}
	}

	/**
	 * Creates a RealVector with the values of F
	 */
	private static void MakeF() {

		F = new ArrayRealVector(PrepareUncmin.Fx.getSize());
		int i = 0;
		for (nodo n : PrepareUncmin.Fx.vector) {
			F.setEntry(i, DiffAndEvaluator.Evaluate(n.GetCadena()));
			i++;
		}
	}
}
