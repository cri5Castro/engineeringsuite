package solver;

import gui.Config;

import java.util.LinkedList;

import String2ME.InitVal;

import doglegMethod.Lmder_fcn;
import doglegMethod.Minpack_f77;
import doglegMethod.Uncmin_f77;
import doglegMethod.Uncmin_methods;

/**
 * Creates the necessary gradient, hessian or Jacobian to call the solver
 * methods
 * 
 * @author Pablo Salinas This class must be static.
 */
public class PrepareUncmin {
	/**
	 * Functions evaluated
	 */
	public static vector Fx = new vector();
	/**
	 * Variables evaluated
	 */
	public static vector Xk = new vector();
	/**
	 * Analytic Jacobian
	 */
	public static String[][] Jacobian;

	/**
	 * Each element of the List is the Hessian of an equation; Example: Two
	 * functions: Cos(x)-1/2=0 ;x^2*y^3 = 25; Then this functions stores this:
	 * at the first position -> { {-cos(x) , 0}, {0 , 0}} at the second position
	 * ->{ {2*Y^3 , 6*x*y^2}, {6*x*y^2 , 6*x^2*y}}
	 */
	public static LinkedList<String[][]> Hessians;

	/**
	 * This constructor creates the f, that is a List with all the 1/2*Fx^2
	 * values; The gradient values with is a Matrix(made with list) that
	 * contains the derivatives of 1/2*Fx^2 The hessian values that contains all
	 * the diagonal and inferior partial second derivatives of the values of
	 * Fx^2
	 * 
	 * @param Fx
	 * @param Xk
	 */
	public PrepareUncmin(LinkedList<Integer> Functions,
			LinkedList<Integer> Variables) {

		clear();

		Xk.Xvector(Variables);
		Fx.Fvector(Functions);
		// Hessians = new LinkedList<String[][]>();

		CreateJacobianAndHessian();

	}

	/**
	 * This method is to use the Levenberg-marquard that does not need the
	 * hessian
	 * 
	 * @param Equation
	 * @param Var
	 * @param bol
	 */
	public PrepareUncmin(LinkedList<Integer> Functions,
			LinkedList<Integer> Variables, boolean b) {

		clear();

		Xk.Xvector(Variables);
		Fx.Fvector(Functions);

		// Create Jacobian
		/* Jacobian Matrix */
		Jacobian = matriz.JacobianLU(Xk, Fx);

	}

	/**
	 * This method is for the CheckString.OneEquationVar
	 * 
	 * @param Equation
	 * @param Var
	 */
	public PrepareUncmin(String Equation, String Var) {

		clear();

		Fx.vector.add(new nodo(Equation));// Fx stores the equation

		Xk.vector.add(new nodo(Var));// Xk stores the variable
		// Now i have to set the initial value of that variable
		Xk.vector.get(0).SetValue(Config.DefaultInitialValue);
		for (InitVal IV : Config.InitValue) {
			if (Var.equalsIgnoreCase(IV.getVariable()))
				Xk.vector.get(0).SetValue(IV.getValue());
		}
		CreateJacobianAndHessian();

	}

	/**
	 * This method is to use the Levenberg-marquard that does not need the
	 * hessian
	 * 
	 * @param Equation
	 * @param Var
	 * @param bol
	 */
	public PrepareUncmin(String Equation, String Var, boolean bol) {

		clear();

		Fx.vector.add(new nodo(Equation));// Fx stores the equation

		Xk.vector.add(new nodo(Var));// Xk stores the variable
		// Now i have to set the initial value of that variable
		Xk.vector.get(0).SetValue(Config.DefaultInitialValue);
		for (InitVal IV : Config.InitValue) {
			if (Var.equalsIgnoreCase(IV.getVariable()))
				Xk.vector.get(0).SetValue(IV.getValue());
		}
		// CreateJacobianAndHessian();
		// Create Jacobian
		/* Jacobian Matrix */
		Jacobian = matriz.JacobianLU(Xk, Fx);
	}

	/**
	 * Creates from Xk and Fx the analytic Jacobian and Hessian
	 */
	private void CreateJacobianAndHessian() {
		Hessians = new LinkedList<String[][]>();

		/* Jacobian Matrix */
		Jacobian = matriz.JacobianLU(Xk, Fx);

		/* List with arrays of the second and partial derivatives */
		/* Each element of the List is the Hessian of an equation */
		String[][] Saux;
		int i = 0;
		for (int row = 0; row < Xk.getSize(); row++) {

			Saux = new String[Xk.getSize()][Xk.getSize()];

			for (int col = 0; col < Xk.getSize(); col++) {
				i = 0;
				for (nodo n : Xk.vector) {
					Saux[col][i] = evaluation.DiffAndEvaluator.diff(
							Jacobian[row][col], n.GetCadena());
					i++;
				}
			}
			Hessians.add(Saux);
		}
	}

	/*
	 * This method sets this values and calls a method for solving the system
	 * equation
	 * 
	 * @param n The number of arguments of the function to minimize
	 * 
	 * @param x The initial estimate of the minimum point
	 * 
	 * @param minclass A class that implements the Uncmin_methods interface.
	 * Basically a method that evaluates the function the gradient and the
	 * Hesian
	 * 
	 * @param typsiz Typical size for each component of x
	 * 
	 * @param fscale Estimate of the scale of the objective function
	 * 
	 * @param method Algorithm to use to solve the minimization problem = 1 line
	 * search = 2 double dogleg = 3 More-Hebdon
	 * 
	 * @param iexp = 1 if the optimization function f_to_minimize is expensive
	 * to evaluate, = 0 otherwise. If iexp = 1, then the Hessian will be
	 * evaluated by secant update rather than analytically or by finite
	 * differences.
	 * 
	 * @param msg Message to inhibit certain automatic checks and output
	 * 
	 * @param ndigit Number of good digits in the minimization function
	 * 
	 * @param itnlim Maximum number of allowable iterations
	 * 
	 * @param iagflg = 0 if an analytic gradient is not supplied
	 * 
	 * @param iahflg = 0 if an analytic Hessian is not supplied
	 * 
	 * @param dlt Trust region radius
	 * 
	 * @param gradtl Tolerance at which the gradient is considered close enough
	 * to zero to terminate the algorithm
	 * 
	 * @param stepmx Maximum allowable step size
	 * 
	 * @param steptl Relative step size at which successive iterates are
	 * considered close enough to terminate the algorithm
	 * 
	 * @param xpls The final estimate of the minimum point
	 * 
	 * @param fpls The value of f_to_minimize at xpls
	 * 
	 * @param gpls The gradient at the local minimum xpls
	 * 
	 * @param itrmcd Termination code ITRMCD = 0: Optimal solution found ITRMCD
	 * = 1: Terminated with gradient small, X is probably optimal ITRMCD = 2:
	 * Terminated with stepsize small, X is probably optimal ITRMCD = 3: Lower
	 * point cannot be found, X is probably optimal ITRMCD = 4: Iteration limit
	 * (150) exceeded ITRMCD = 5: Too many large steps, function may be
	 * unbounded
	 * 
	 * @param a Workspace for the Hessian (or its estimate) and its Cholesky
	 * decomposition
	 * 
	 * @param udiag Workspace for the diagonal of the Hessian
	 */
	/**
	 * Solves the system of equations.
	 * 
	 * @param EvaluationMethod
	 *            Changes the method for solving the equation method; 1 =
	 *            Line-Search 2 = Double Dogleg 3 = Hebden-More
	 */
	public static void Solve(int EvaluationMethod) {

		Uncmin_methods UM = new Uncmin_methods();
		int tam = Fx.getSize();
		double[] xpls = new double[tam + 1];
		double[] fpls = new double[tam + 1];
		double[] gpls = new double[tam + 1];
		double[][] a = new double[tam + 1][tam + 1];
		double[] udiag = new double[tam + 1];

		double typsiz[] = new double[tam + 1];
		double fscale[] = new double[2];
		int method[] = new int[2];// 1 = Gauss-newton, 2 = double dogleg,3 =
									// More-Hebdon
		int iexp[] = new int[2];
		int msg[] = new int[2];
		int[] itrmcd = new int[2];
		int ndigit[] = new int[2];// Number of good digits in the minimization
									// function
		int itnlim[] = new int[2];// Number of maximun iterations
		int iagflg[] = new int[2];// =0 analytic gradient, not supplied
		int iahflg[] = new int[2];// =0 analytic hessian not supplied,
		double dlt[] = new double[2];// dlt= trust region radius
		double gradtl[] = new double[2];// tolerance at witch the gradient is
										// considered close enough to zero to
										// finish
		double stepmx[] = new double[2];// Maximum allowable stepsize
		double steptl[] = new double[2];// Relative step size at wich is
										// considered to finish

		// Set Values

		for (int i = 1; i <= tam; i++) { // tomada del default normal
											// <--------------------------------

			typsiz[i] = 1.0; // tomada del default normal
								// <--------------------------------

		}

		fscale[1] = 1.0; // tomada del default normal
							// <--------------------------------

		if (EvaluationMethod <= 3 & EvaluationMethod > 0)
			method[1] = EvaluationMethod;// 1 Line-Search; 2 double dogleg, 3
											// hebden-more
		else
			method[1] = 2;

		iexp[1] = 0;
		msg[1] = 80; // 40 means no gradient and Hessian check, 80 the same plus
						// less comments
		ndigit[1] = -1;// tomada del default normal
						// <--------------------------------
		itnlim[1] = Config.MaxNumberOfIteration;
		iagflg[1] = 1;
		iahflg[1] = 1;
		dlt[1] = Config.TrustRegionRadius;// -1 means that the first time will
											// use the Newton step length
		// double epsm = Config.epsilon;
		gradtl[1] = Config.GradientPrecision;// Deberia poder cambiarse
												// <--------------------------------
		stepmx[1] = Config.MaxJump;// Valor original 0<---Debe poder cambiarse
		steptl[1] = Config.Precision;// Math.sqrt(epsm);// <-- This was the
										// original

		try {

			if (Config.IterationAntiMinimum <= 0)
				Uncmin_f77.optif9_f77(tam, Xk.Vector2Dogleg(), UM, typsiz,
						fscale, method, iexp, msg, ndigit, itnlim, iagflg,
						iahflg, dlt, gradtl, stepmx, steptl, xpls, fpls, gpls,
						itrmcd, a, udiag);
			else {
				int MaxIterations = 0;
				vector Xkaux = Xk;
				double max = 0;
				do {
					Uncmin_f77.optif9_f77(tam, Xkaux.Vector2Dogleg(), UM,
							typsiz, fscale, method, iexp, msg, ndigit, itnlim,
							iagflg, iahflg, dlt, gradtl, stepmx, steptl, xpls,
							fpls, gpls, itrmcd, a, udiag);

					// check if the point is a good result
					if (itrmcd[1] == 1 | itrmcd[1] == 2) {
						max = 0;
						for (double d : fpls)
							if (Math.abs(d) > Math.abs(max))
								max = d;

						if (Math.abs(max) > Math.sqrt(Config.Precision)) {
							Newton N = new Newton(Fx, Xk);
							Xkaux = N.Newtonsolver(Jacobian,
									Config.IterationAntiMinimum);

						} else {
							itrmcd[1] = 0;
						}
					}

					MaxIterations++;
					if (MaxIterations >= Config.IterationAntiMinimum)
						itrmcd[1] = 0;

				} while (itrmcd[1] == 1 | itrmcd[1] == 2);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clear();
		}

	}

	/**
	 * Solves by the Levenberg-Marquard method
	 */
	public static void LMSolve() {
		Lmder_fcn Lder = new Lmder_fcn();
		int tam = Fx.getSize();
		double x[] = new double[tam + 1];
		x = Xk.Vector2Dogleg();
		double fvec[] = new double[tam + 1];
		double fjac[][] = new double[tam + 1][tam + 1];
		double tol = Config.Precision;// Math.sqrt(Config.epsilon);
		int info[] = new int[2];// This is a return value
		int ipvt[] = new int[tam + 1];// See Minpack_f77

		try { // Call the method
			Minpack_f77.lmder1_f77(Lder, tam, tam, x, fvec, fjac, tol, info,
					ipvt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			clear();
		}
	}

	/**
	 * Erase the values of Fx and Xk
	 */
	public static void clear() {
		Fx.clear();
		Xk.clear();
	}
}