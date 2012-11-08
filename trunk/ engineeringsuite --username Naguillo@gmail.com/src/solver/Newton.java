package solver;

import java.util.StringTokenizer;

import org.apache.commons.math.linear.RealMatrix;
import org.apache.commons.math.linear.RealVector;

import evaluation.*;
import gui.Config;

/**
 * Includes simple numerical methods, such as Newton method and a constant
 * solver
 * 
 * @author pablo
 * 
 */
public class Newton {

	vector Xk = new vector();
	vector Fx = new vector();
	String[][] J;
	int size;
	RealVector norm;

	public Newton(vector Fx, vector Xk) {
		this.Xk = Xk;
		this.Fx = Fx;
	}

	/**
	 * This method try to solve a equation that is linear. If it is not a
	 * constant then the variable is restart and returns false For example:
	 * constants.
	 */
	public static boolean ConstantSolver(String equation, String var) {
		try {
			// Set initial value
			double f = Config.DefaultInitialValue;
			for (int i = 0; i < Config.InitValue.size(); i++)
				if (Config.InitValue.get(i).getVariable().equalsIgnoreCase(var)) {
					f = Config.InitValue.get(i).getValue();
					i = Config.InitValue.size();
				}

			// This is to replace the variable by the initial value f
			// Supposing f = 1, the result would be:
			// Initial equation: x - 10 ---> Substituted equation: 1 - 10
			String aux3 = new String("");
			String equation2 = new String("");
			StringTokenizer lector = new StringTokenizer(equation,
					"+/*-()[]{} ^=!", true);
			while (lector.hasMoreTokens()) {
				aux3 = lector.nextToken();
				if (aux3.equalsIgnoreCase(var))
					equation2 += Double.toString(f);
				else
					equation2 += aux3;
			}

			// Formula to solve constant equation in one step
			f = evaluation.DiffAndEvaluator.Evaluate(Double.toString(f) + "-("
					+ equation2 + ")");

			// f =
			// evaluation.DiffAndEvaluator.Evaluate(Double.toString(f)+"-("+equation.replace(var,
			// Double.toString(f))+")");
			if (Math.abs(f) < Config.Precision) {
				evaluation.DiffAndEvaluator.IntroduceValues(var + "="
						+ Double.toString(f));
				return true;
			} else {
				evaluation.DiffAndEvaluator.PurgeVar(var);
				return false;
			}

		} catch (RuntimeException r) {
			evaluation.DiffAndEvaluator.PurgeVar(var);
			return false;
		} catch (Exception e) {
			evaluation.DiffAndEvaluator.PurgeVar(var);
			return false;
		}

	}

	/*
	 * Hacer metodo de newton con parametros de , Jacobiana y F. Si es un
	 * minimo, lo que deberia ocurrir es k la jacobiana sea casi cero, pero la
	 * funcion no, por tanto deberia dar un salto muy grande asi que en
	 * principio igual una iteracion es suficiente para alejarnos del minimo
	 */
	/**
	 * This method makes the newton-raphson solver. It is used to make the
	 * antiminimun method, because the Newton method is a root solver method not
	 * an optimization method.
	 */
	public vector Newtonsolver(String[][] Jacobian, int iterations) {
		// boolean sol = false;
		RealMatrix J;
		RealVector F, Xk0;
		for (int k = 0; k < iterations; k++) {

			// Introduce the values in matheclipse
			if (Xk.vector.size() > 0)
				DiffAndEvaluator.IntroduceValues(Xk.EvaluateVector2ME());

			// Xk0 it's also used to test if the new solution is the solution
			Xk0 = Xk.vector2Realvector();

			// This method evaluates F at the Xk point
			F = Fx.FVector2LU();

			// This method evaluates the jacobian at the Xk point
			J = matriz.EvaluateJacobian(Jacobian);

			// This method solves the system equation Jacobian*P=F using P-LU
			F = LU.Operate(J, F);

			// This makes one iteration of the Newton method
			F = F.add(Xk0);

			// Refresh Xk values
			int i = 0;
			for (nodo n : Xk.vector) {
				n.SetValue(F.getEntry(i));
				i++;
			}

		}
		return Xk;
	}

	@SuppressWarnings("unused")
	/**
	 * Refresh the values of Xk in the newton method
	 */
	private void RefreshXkAndIntroduceValues(RealVector X) {
		Xk.EvaluateVector2ME(X);
		DiffAndEvaluator.IntroduceValues(Xk.EvaluateVector2ME());
	}

}