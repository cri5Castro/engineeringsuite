package evaluation;

import gui.Config;
import gui.SolverGUI;

import org.apache.commons.math.linear.DecompositionSolver;
import org.apache.commons.math.linear.LUDecompositionImpl;
import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;

/**
 * This methods makes the PLU of an array. This is an improved version of the
 * LU.
 * 
 * @author Pablo Salinas
 * 
 */
public class LU {
	/**
	 * The zero of the machine
	 */
	private static double epsilon = Config.epsilon;

	/**
	 * 
	 * @param Jacobian
	 * @param F
	 * @return The solution to this J*X=F but the result X multiplied by -1
	 */
	public static RealVector Operate(RealMatrix Jacobian, RealVector F) {

		DecompositionSolver solver = new LUDecompositionImpl(Jacobian)
				.getSolver();

		if (!solver.isNonSingular()) {
			for (int i = 0; i < Jacobian.getColumnDimension(); i++) {// Jittering
																		// the
																		// jacobian

				double aux = Jacobian.getEntry(i, i);
				double multiplier = 1;

				if (aux < 1e-8)
					Jacobian.setEntry(i, i, epsilon * i);
				else {
					// Make the epsilon bigger, if necessary .CHECK THIS
					while (Math.abs(aux / 1000) + epsilon * multiplier == Math
							.abs(aux / 1000))
						multiplier *= 10;
					// Make the epsilon smaller, if necessary
					while (Math.abs(aux) * multiplier / (epsilon) < 10)
						multiplier /= 10;

				}
				Jacobian.setEntry(i, i, aux + epsilon * multiplier * i);
			}
			solver = new LUDecompositionImpl(Jacobian).getSolver();

			if (!solver.isNonSingular()) {
				SolverGUI.PopUpError("Matrix is singular");
				throw new RuntimeException("Matrix is singular.");
			}

		}
		F = solver.solve(F);
		return F.mapMultiplyToSelf(-1);

	}

}