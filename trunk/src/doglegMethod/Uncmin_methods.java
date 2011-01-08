package doglegMethod;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;

import evaluation.DiffAndEvaluator;
import solver.PrepareUncmin;
import solver.matriz;
import solver.nodo;

//NOW THE VALUES ARE ONLY INTRODUCED WHEN THE FUNCTION IS GOING TO BE EVALUATED
/**
 * Class to use with the Uncmin_f77
 * 
 * @author pablo Salinas
 */
public class Uncmin_methods {
	private static RealVector F;
	private static RealMatrix J;

	/**
	 * Introduce the values of f= 1/2 Sum(F^2) in matheclipse
	 * 
	 * @param x
	 * @return
	 */
	public static double f_to_minimize(double x[]) {

		IntroduceValues(x); // TEMPORAL
		MakeF();
		return F.dotProduct(F.mapMultiply(0.5));

	}

	/**
	 * Creates and evaluates the gradient of f
	 * 
	 * @param x
	 * @param g
	 */
	public static void gradient(double x[], double g[]) {

		// IntroduceValues(x); //TEMPORAL

		MakeJ();

		RealVector aux = J.transpose().operate(F);

		// As Uncmin needs a vector that starts from the position 1 i will
		// create one with that characteristics

		for (int i = 0; i < aux.getDimension(); i++)
			g[i + 1] = aux.getEntry(i);

		return;
	}

	/**
	 * The Hessian is made using this formula: J'*J + Sum(Fj*Laplacian(Fj))
	 * 
	 * @param x
	 * @param h
	 */
	public static void hessian(double x[], double h[][]) {

		// IntroduceValues(x); //TEMPORAL

		RealMatrix Raux;
		Raux = J.transpose().multiply(J);
		for (int row = 0; row < PrepareUncmin.Xk.getSize(); row++)
			for (int col = 0; col < PrepareUncmin.Xk.getSize(); col++) {
				h[row + 1][col + 1] = Raux.getEntry(row, col)
						+ HelpHessian(row, col);
			}

		return;
	}

	/**
	 * Introduce the values in matheclipse and updates the values of the vector
	 * Xk
	 * 
	 * @param x
	 */
	protected static void IntroduceValues(double x[]) {
		int i = 1;
		for (nodo n : PrepareUncmin.Xk.vector) {
			n.SetValue(x[i]);
			i++;
		}

		DiffAndEvaluator.IntroduceValues(PrepareUncmin.Xk.EvaluateVector2ME());
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
	 * Creates a RealMatrix with the values of the jacobian
	 */
	private static void MakeJ() {
		J = matriz.EvaluateJacobian(PrepareUncmin.Jacobian);
	}

	/**
	 * 
	 * @param row
	 * @param col
	 * @return Sum(Fj*Laplacian(Fj)). Not exactly that, this only returns one
	 *         value of that sum;
	 */
	public static double HelpHessian(int row, int col) {
		double aux = 0;
		int i = 0;
		for (String[][] S : PrepareUncmin.Hessians) {
			aux += F.getEntry(i)
					* evaluation.DiffAndEvaluator.Evaluate(S[row][col]);
			i++;
		}
		return aux;
	}

}
