package doglegMethod;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;

import solver.PrepareUncmin;
import solver.matriz;
import solver.nodo;
import evaluation.DiffAndEvaluator;

/**
 * Class to work with Minpack_f77
 * 
 * @author Pablo Salinas
 * 
 */
public class Lmder_fcn {

	private static RealVector F;
	private static RealMatrix J;

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
	 * @param fjac
	 *            = The Jacobian evaluated in x
	 * @param iflag
	 *            = if 1 then evaluate only fvec, if 2 then evaluate only fjac
	 */
	public static void fcn(int m, int n, double x[], double fvec[],
			double fjac[][], int iflag[]) {
		// NOW THE VALUES ARE ONLY INTRODUCED WHEN THE FUNCTION IS GOING TO BE
		// EVALUATED
		if (iflag[1] == 1) {
			Uncmin_methods.IntroduceValues(x);
			MakeF();
			for (int i = 0; i < F.getDimension(); i++)
				fvec[i + 1] = F.getEntry(i);
		}
		if (iflag[1] == 2) {
			MakeJ();
			for (int row = 0; row < J.getRowDimension(); row++)
				for (int col = 0; col < J.getColumnDimension(); col++)
					fjac[row + 1][col + 1] = J.getEntry(row, col);
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

	/**
	 * Creates a RealMatrix with the values of the jacobian of F
	 */
	private static void MakeJ() {
		J = matriz.EvaluateJacobian(PrepareUncmin.Jacobian);
	}

}
