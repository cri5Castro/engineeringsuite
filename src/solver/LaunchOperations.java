package solver;

import gui.Config;

import java.util.LinkedList;

/**
 * This class calls the evaluations methods with time limit. And changing the
 * method if is a one equation system or not.
 * 
 * @author pablo
 */
@SuppressWarnings("static-access")
public class LaunchOperations implements Runnable {
	/**
	 * One equation system = true
	 */
	boolean One = false;
	/**
	 * LinkedList with the position of the functions of our equation system in
	 * CheckStringt.Functions
	 */
	LinkedList<Integer> Functions;
	/**
	 * The position, of the variables implied in the equation system, in
	 * CheckString.Variables
	 */
	LinkedList<Integer> Vars;
	/**
	 * Function for one equation system
	 */
	String function;
	/**
	 * Variable for one equation system
	 */
	String var;

	/**
	 * Equation system constructor
	 * 
	 * @param Functions
	 * @param Vars
	 */
	public LaunchOperations(LinkedList<Integer> Functions,
			LinkedList<Integer> Vars) {
		One = false;
		this.Functions = Functions;
		this.Vars = Vars;
	}

	/**
	 * Single equation constructor
	 * 
	 * @param function
	 * @param var
	 */
	public LaunchOperations(String function, String var) {
		this.One = true;
		this.function = function;
		this.var = var;
	}

	@Override
	/**
	 * Calls the appropriated solver method. 
	 * 
	 */
	public void run() {
		try {
			if (One) {
				// At first we try the ConstantSolver. If the return is false
				// then we will try a different method
				if (!Newton.ConstantSolver(function, var)) {
					switch (Config.SingleVariableMethod) {
					case 1:
						PrepareUncmin PU1 = new PrepareUncmin(function, var);
						PU1.Solve(1);
						break;
					case 2:
						PrepareUncmin PU2 = new PrepareUncmin(function, var);
						;
						PU2.Solve(2);
						break;
					case 3:
						PrepareUncmin PU3 = new PrepareUncmin(function, var);
						PU3.Solve(3);
						break;
					default:
						PrepareUncmin PU4 = new PrepareUncmin(function, var,
								true);
						PU4.LMSolve();
					}
				}
			} else {
				if (Functions.size() != 1) {
					switch (Config.MultiVariableMethod) {
					case 1:
						PrepareUncmin PU1 = new PrepareUncmin(Functions, Vars);
						PU1.Solve(1);
						break;
					case 2:
						PrepareUncmin PU2 = new PrepareUncmin(Functions, Vars);
						PU2.Solve(2);
						break;
					case 3:
						PrepareUncmin PU3 = new PrepareUncmin(Functions, Vars);
						PU3.Solve(3);
						break;
					default:
						PrepareUncmin PU4 = new PrepareUncmin(Functions, Vars,
								true);
						PU4.LMSolve();
					}
				} else {

					switch (Config.SingleVariableMethod) {
					case 1:
						PrepareUncmin PU1 = new PrepareUncmin(Functions, Vars);
						PU1.Solve(1);
						break;
					case 2:
						PrepareUncmin PU2 = new PrepareUncmin(Functions, Vars);
						PU2.Solve(2);
						break;
					case 3:
						PrepareUncmin PU3 = new PrepareUncmin(Functions, Vars);
						PU3.Solve(3);
						break;
					default:
						PrepareUncmin PU4 = new PrepareUncmin(Functions, Vars,
								true);
						PU4.LMSolve();
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}