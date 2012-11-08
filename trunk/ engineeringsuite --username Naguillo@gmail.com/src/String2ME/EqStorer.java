package String2ME;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class to store the function and its partial derivatives
 * 
 * @author Pablo Salinas Cortes
 * 
 */
public class EqStorer {

	public List<DerivEquation> aux = new ArrayList<DerivEquation>();

	private String _equation;

	/**
	 * Makes every partial differentiation of a function
	 * 
	 * @param cadena
	 * @param variable
	 */
	public EqStorer(String cadena, VList var) {
		_equation = cadena;

		for (int i = 0; i < var.getSize(); i++) {
			// aux.add(new
			// DerivEquation(DiffAndEvaluator.diff(cadena,var.getVar(i)),var.getVar(i)));
			aux.add(new DerivEquation(var.getVar(i)));
		}
	}

	/**
	 * Returns the equation
	 * 
	 * @return String
	 */
	public String getEquation() {
		return _equation;
	}

	/**
	 * 
	 * @param variable
	 * @return dFuntion/dvariable
	 */
	public String getDeff(String variable) {
		Iterator<DerivEquation> it = this.aux.iterator();
		DerivEquation DE;
		while (it.hasNext()) {
			DE = it.next();
			if (DE.GetVar().equals(variable)) {
				return DE.GetDeriv();
			}
		}
		return "0";
	}

	public void purgeDev() {
		aux.clear();
	}

}