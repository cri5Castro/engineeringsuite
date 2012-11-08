package evaluation;

import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.form.output.StringBufferWriter;
import org.matheclipse.core.interfaces.IExpr;

/**
 * This class is used to control the calculation time of the operations in
 * eSuite Mathematics to stop them if necessary
 * 
 * @author Pablo Salinas
 * 
 */
public class CalculateThread implements Runnable {

	String In;
	static String Output;

	public CalculateThread(String in) {
		this.In = in;

	}

	/**
	 * Starts the calculation thread
	 */
	public void run() {
		EvalUtilities util = new EvalUtilities();
		IExpr result;
		try {
			result = util.evaluate(In);
			StringBufferWriter buf = new StringBufferWriter();
			OutputFormFactory.get().convert(buf, result);
			Output = buf.toString();

		} catch (final Exception e) {
			e.printStackTrace();
			DiffAndEvaluator.SymbolicEvaluatorError = true;
			Output = e.getMessage();// Returns the error as a string to print
		} // ñççñ this is only to identify the string and print it in red
	}

	/**
	 * 
	 * @return returns the result
	 */
	public static String getOutput() {
		return Output;
	}
}