package solver;

import java.util.Collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;

import evaluation.DiffAndEvaluator;
import gui.Config;
import String2ME.*;

/**
 * Works with vectors. Creates the functions vector and the variables vector.
 * 
 * @author pablo Salinas
 */
public class vector {
	/**
	 * List that stores the values
	 */
	public List<nodo> vector = new LinkedList<nodo>();

	/**
	 * Add all the variables equal to default value, unless the user had set a
	 * different value
	 */
	public void Xvector() {

		Iterator<VString> it = CheckString.Var.Variables.iterator();
		String aux;
		boolean found;
		while (it.hasNext()) {
			found = false;
			aux = it.next().getVar();

			for (int i = 0; i < Config.InitValue.size(); i++) {
				// This is to check if the variable has a different initial
				// value
				if (Config.InitValue.get(i).getVariable().equalsIgnoreCase(aux)) {
					found = true;
					this.vector.add(new nodo(
							Config.InitValue.get(i).getValue(), aux));
					i = Config.InitValue.size();
				}
			}
			if (!found)
				this.vector.add(new nodo(Config.DefaultInitialValue, aux));
		}

	}

	/**
	 * Add all the variables of the list equal to default value, unless the user
	 * had set a different value
	 */
	public void Xvector(LinkedList<Integer> var) {
		Collections.sort(var);
		Iterator<Integer> it = var.listIterator();
		Iterator<VString> it2 = CheckString.Var.Variables.listIterator();
		boolean found, finish = false;
		String aux;
		int j = 0;
		int pos = it.next().intValue();
		while (it2.hasNext() & !finish) {
			found = false;
			aux = it2.next().getVar();

			if (pos == j) {
				if (it.hasNext())
					pos = it.next().intValue();
				else
					finish = true;

				for (int i = 0; i < Config.InitValue.size(); i++) {// This is
																	// not
																	// optimized
					// This is to check if the variable has a different initial
					// value
					if (Config.InitValue.get(i).getVariable().equalsIgnoreCase(
							aux)) {
						found = true;
						this.vector.add(new nodo(Config.InitValue.get(i)
								.getValue(), aux));
						i = Config.InitValue.size();
					}
				}
				if (!found)
					this.vector.add(new nodo(Config.DefaultInitialValue, aux));

			}
			j++;
		}
	}

	/**
	 * This is not a constructor, this makes a vector to contain all the
	 * equations
	 */
	public void Fvector() {
		Iterator<EqStorer> it = CheckString.Functions.iterator();
		while (it.hasNext()) {
			this.vector.add(new nodo(it.next().getEquation()));
		}
	}

	/**
	 * This is not a constructor, this makes a vector to contain all the
	 * equations of the LinkedList
	 */
	public void Fvector(LinkedList<Integer> functions) {
		Collections.sort(functions);
		Iterator<Integer> it = functions.listIterator();
		Iterator<EqStorer> it2 = CheckString.Functions.listIterator();
		int pos = it.next().intValue();
		int i = 0;
		boolean finish = false;
		EqStorer eq;
		while (it2.hasNext() & !finish) {
			eq = it2.next();
			if (pos == i) {
				if (it.hasNext())
					pos = it.next().intValue();
				else
					finish = true;

				this.vector.add(new nodo(eq.getEquation()));
			}
			i++;
		}
	}

	/**
	 * 
	 * @param number
	 * @param String
	 *            , the variable
	 */
	public void addnodo(double n, String s) {
		vector.add(new nodo(n, s));
	}

	/**
	 * 
	 * @param Position
	 *            of the variable in the list you want mark as solution reached
	 */
	public void SetReach(int i) {
		vector.get(i).SolutionReach();
	}

	/**
	 * 
	 * @param Position
	 *            of the variable in the list
	 * @return True if the solution is reached false if not
	 */
	public boolean IsReach(int i) {
		return vector.get(i).IsSolutionReach();
	}

	/**
	 * 
	 * @param Position
	 *            of the variable in the list that you want to mark as solution
	 *            not reached
	 */
	public void SetSolutionNotReach(int i) {
		vector.get(i).SolutionNotReach();
	}

	/**
	 * 
	 * @return A EvaluateVector to introduce in MathEclipse like this: X=4;B=2
	 */
	public String EvaluateVector2ME() {
		String aux = new String("");
		Iterator<nodo> it = vector.iterator();
		while (it.hasNext()) {
			nodo n = it.next();
			aux += n.GetCadena() + "=" + n.GetStringValue();
			if (it.hasNext()) {
				aux += ";";
			}
		}
		return aux;
	}

	/**
	 * 
	 * @param X
	 * @return A EvaluateVector to introduce in MathEclipse like this: X=4;B=2
	 *         from the values of the array
	 */
	public String EvaluateVector2ME(RealVector X) {
		String aux = new String("");
		Iterator<nodo> it = vector.iterator();
		int i = 0;
		while (it.hasNext()) {
			nodo n = it.next();
			aux += n.GetCadena() + "=" + X.getEntry(i);

			if (it.hasNext()) {
				aux += ";";
			}
			i++;
		}
		return aux;
	}

	/**
	 * Before using this method the values must have been introduce in
	 * matheclipse
	 * 
	 * @return a Vector evaluated
	 */
	public ArrayRealVector FVector2LU() {
		ArrayRealVector aux = new ArrayRealVector(vector.size());
		Iterator<nodo> it = vector.iterator();
		int i = 0;
		while (it.hasNext()) {
			aux.setEntry(i, DiffAndEvaluator.Evaluate(it.next().GetCadena()));
			i++;
		}

		return aux;
	}

	public double[] FVector2SumaVectores(double[] N) {
		double[] aux = new double[N.length - 1];// We want a zero in the zero
												// row
		for (int i = 1; i < N.length; i++) {
			aux[i - 1] = N[i];
		}
		return aux;
	}

	/**
	 * 
	 * @return a double[] witch first value is ignored i mean a vector from 1 to
	 *         n+1
	 */
	public double[] Vector2Dogleg() {
		double[] x = new double[this.vector.size() + 1];
		int i = 1;
		for (nodo n : this.vector) {
			x[i] = n.GetValue();
			i++;
		}
		return x;
	}

	/**
	 * 
	 * @param vector1
	 * @param vector2
	 * @return A vector which is vector1+vector2
	 */
	public static vector SumVector(vector vector1, vector vector2) {
		vector aux = new vector();
		Iterator<nodo> it1 = vector1.vector.iterator();
		Iterator<nodo> it2 = vector2.vector.iterator();
		while (it1.hasNext()) {
			nodo n1 = it1.next();
			nodo n2 = it2.next();
			aux.addnodo(n1.GetValue() + n2.GetValue(), n1.GetCadena());
		}
		return aux;
	}

	/**
	 * Updates the values of the variables
	 */
	public void Refresh2(double[] Xk0) {
		Iterator<nodo> it = this.vector.iterator();
		for (int i = 0; i < Xk0.length; i++) {
			it.next().SetValue(Xk0[i]);
		}
	}

	/**
	 * 
	 * @param in
	 * @return true if the input string is in the vector
	 */
	public boolean CheckString(String in) {
		boolean aux = false;
		Iterator<nodo> it = this.vector.iterator();
		while ((it.hasNext()) & (!aux)) {
			if (it.next().GetCadena().equals(in))
				aux = true;
		}

		return aux;
	}

	/**
	 * 
	 * @param Xk0
	 * @return True if all the variables have reach their final value
	 */
	public boolean CheckFinish(RealVector Xk0) {
		Iterator<nodo> it1 = this.vector.iterator();
		nodo aux1;
		double aux2;
		int n = 0;
		int i = 0;
		while (it1.hasNext()) {
			aux1 = it1.next();
			aux2 = Xk0.getEntry(n);
			if (!aux1.IsSolutionReach()) {
				if (Math.abs((aux1.GetValue() - aux2)) <= (Math.abs(aux1
						.GetValue()) * Config.Precision)) {
					aux1.SolutionReach();
					i++;
				}
			} else
				i++;
			n++;
		}
		if (i == this.vector.size())
			return true;

		return false;

	}

	/**
	 * 
	 * @return An ArrayRealVector with all the values of the vector
	 */
	public ArrayRealVector vector2Realvector() {
		Iterator<nodo> it = this.vector.iterator();
		ArrayRealVector aux = new ArrayRealVector(this.vector.size());
		int i = 0;
		while (it.hasNext()) {
			aux.setEntry(i, it.next().GetValue());
			i++;
		}
		return aux;
	}

	public int getSize() {
		return this.vector.size();
	}

	public String toString() {
		String salida = new String("");
		for (nodo n : this.vector) {
			salida += n.GetCadena() + " ";
		}
		return salida;
	}

	/**
	 * Removes all the elements from the vector
	 */
	public void clear() {
		this.vector.clear();
	}

}
