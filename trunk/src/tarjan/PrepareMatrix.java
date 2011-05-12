package tarjan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import evaluation.DiffAndEvaluator;

import String2ME.CheckString;
import String2ME.DerivEquation;
import String2ME.EqStorer;
import String2ME.VString;

/**
 * This class is to subdivide the equation system in various equations system.
 * 
 * @author pablo salinas
 * 
 */
public class PrepareMatrix {

	/**
	 * The variables(columns) are positive int; The functions(rows) are negative
	 * int;
	 */
	private AdjacencyList _relations;
	private LinkedList<NodoStorer> _Nodes = new LinkedList<NodoStorer>();
	private ArrayList<ArrayList<Node>> SCC;
	/* The nodes must be created first, so i will create two list of nodes */
	/** Variable nodes list */
	private LinkedList<Node> VarNodes = new LinkedList<Node>();
	/** Functions node list */
	private LinkedList<Node> FuncNodes = new LinkedList<Node>();

	public PrepareMatrix() {
		// Create the nodes
		for (int i = 1; i < CheckString.Var.getSize() + 1; i++) {
			VarNodes.add(new Node(i));
			FuncNodes.add(new Node(-i));
		}
	}

	/**
	 * At first i save the initial positions of the variables in the list, and
	 * then i call compareTo, because i want to know the count of the variables
	 * to call the tarjan method properly
	 */
	public void PreNewton() {

		createAdjacencyList();
		// now i will call Tarjan with the AdjacencyList
		// and with the variable with the lowest appearance count
		Collections.sort(this._Nodes);
		int k = Integer.MAX_VALUE;
		Tarjan T;
		ListMatrix Relations;
		LinkedList<PotentialRelationMatrix> PRM = new LinkedList<PotentialRelationMatrix>();
		while (this._Nodes.size() > 0) {

			int i = 0;
			for (NodoStorer N : this._Nodes) {// Now try with the variables with
												// lowest appearance
				if (i == 0) {
					k = N.getCount();
					i++;
				}

				if (N.getCount() <= k) {
					T = new Tarjan();
					this._relations.RestartNodes();
					restartNodes();
					// Call Tarjan

					SCC = T.tarjan(/* this._Nodes.get(k-1).getNode() */N
							.getNode(), this._relations);
					Relations = RelationMatrix(SCC);
					// System.out.println(Relations);
					// if(Relations.checkDiagonal())//Store the value
					PRM.add(new PotentialRelationMatrix(Relations, SCC));
				}
				// k--;
				// k = N.getCount();
				// i++;
			}

			Collections.sort(PRM);
			Relations = RelationMatrix(PRM.getFirst().SCC);

			/*
			 * for(PotentialRelationMatrix AAN:PRM){
			 * System.out.println("Numero: "+AAN.ValuesDownDiagonal);
			 * for(ArrayList<Node> AN:AAN.SCC){ for(Node N:AN){
			 * System.out.print(" "+N.name); } System.out.println(); } }
			 */
			PRM.clear();
			updateTerms(SCC);
			RelationMatrix2Newton(Relations, SCC);

		}

	}

	/**
	 * After one tarjan iteration, this._Nodes must be updated, erasing the
	 * nodes that were used to create the Boolean Matrix
	 * 
	 * @param SCC
	 */
	private void updateTerms(ArrayList<ArrayList<Node>> SCC) {
		int aux;
		Iterator<NodoStorer> it;
		for (ArrayList<Node> Lista : SCC) {
			for (Node n : Lista) {
				aux = n.getName();
				if (aux > 0) {// Its a column and then a variable
					it = this._Nodes.listIterator();
					// Search in the list that variable, if founded, then
					// removes it
					while (it.hasNext()) {
						if (it.next().getNode().getName() == aux)
							it.remove();
					}
				}
			}
		}
	}

	/**
	 * @return The variable with less appearance count in
	 *         CheckString.Var.Variables
	 * @deprecated
	 */
	@SuppressWarnings("unused")
	private int getLowCountVariable() {
		Iterator<VString> it = CheckString.Var.Variables.listIterator();
		int n = Integer.MAX_VALUE;
		int i = 0;
		int varPosition = 0;
		VString aux;
		while (it.hasNext() & n != 1) {
			aux = it.next();
			if (aux.getCount() < n) {
				n = aux.getCount();
				varPosition = i;
			}
			i++;
		}
		return varPosition;
	}

	/**
	 * 
	 * @param SCC
	 * @return A Matrix with the relations between variables and functions; For
	 *         example the equations x = 2 ; x + y =4 would be this way: {{1 ,
	 *         0};{1 , 1}}
	 */
	private ListMatrix RelationMatrix(ArrayList<ArrayList<Node>> SCC) {

		// for(ArrayList<Node> An :SCC)
		// for(Node n :An)
		// System.out.println("Nodo: "+n.getName());

		LinkedList<String> var = new LinkedList<String>();
		LinkedList<Integer> func = new LinkedList<Integer>();
		int variable;
		/*
		 * This splits the SCC in functions(negatives values) and variables(the
		 * positives ones)
		 */
		for (int i = 0; i < SCC.size(); i++) {
			for (int j = 0; j < SCC.get(i).size(); j++) {
				variable = SCC.get(i).get(j).getName();
				if (variable > 0)
					var.add(CheckString.Var.getVar(variable - 1));// previously
																	// i added 1
				else {
					// if(variable != 0)
					func.add(Math.abs(variable) - 1);// previously i added 1
				}

			}
		}

		ListMatrix result = new ListMatrix(var.size());

		Iterator<Integer> it = func.listIterator();
		EqStorer function;
		int row = 0;
		while (it.hasNext()) {
			int position = it.next();
			function = CheckString.Functions.get(position);

			Iterator<String> it2 = var.listIterator();
			String nombre;
			int col = 0;
			while (it2.hasNext()) {
				nombre = it2.next();
				for (int j = 0; j < function.aux.size(); j++)
					if (function.aux.get(j).GetVar().equalsIgnoreCase(nombre))
						result.setValue(row, col, (byte) 1);

				col++;
			}

			row++;
		}

		return result;
	}

	/**
	 * 
	 * @param Lista
	 * @param name
	 * @return the node of the list that have the same name of the integer
	 *         introduced
	 */
	private Node NodeOfTheList(LinkedList<Node> Lista, int name) {

		Iterator<Node> it = Lista.listIterator();
		Node aux;
		while (it.hasNext()) {
			aux = it.next();
			if (name == aux.getName())
				return aux;
		}
		return new Node(0);

	}

	/**
	 * 
	 * @param var
	 * @return The position of that variable in CheckString.Var.Variables
	 */
	private NodoNameCount getVarPosition(String var) {
		Iterator<VString> it = CheckString.Var.Variables.listIterator();
		int i = 0;
		VString aux;
		while (it.hasNext()) {
			aux = it.next();
			if (aux.getVar().equalsIgnoreCase(var))
				return new NodoNameCount(i, aux.getCount());
			i++;
		}
		return new NodoNameCount(-1, -1);

	}

	/**
	 * Creates an adjacency List of all the variables to use in Tarjan
	 */
	private void createAdjacencyList() {
		this._relations = new AdjacencyList();
		// int fila=-1,col=1;
		int col = -1, fila;
		EqStorer Eqaux;
		Node Naux, nodo;
		Iterator<EqStorer> it2 = CheckString.Functions.iterator();
		NodoNameCount NodoAux;
		while (it2.hasNext()) {
			Eqaux = it2.next();
			Naux = NodeOfTheList(FuncNodes, col);
			if (Naux.name != 0) {
				Iterator<DerivEquation> it3 = Eqaux.aux.listIterator();
				fila = 0;
				while (it3.hasNext()) {
					NodoAux = getVarPosition(it3.next().GetVar());
					nodo = NodeOfTheList(VarNodes, NodoAux.getName() + 1);
					if (nodo.name != 0) {
						// Store the from node
						// First i check if the node is already in the list
						boolean found = false;
						for (int k = 0; k < this._Nodes.size(); k++) {
							if (this._Nodes.get(k).getNode().getName() == nodo
									.getName())
								found = true;
						}
						if (!found)// add node
							this._Nodes.add(new NodoStorer(nodo, NodoAux
									.getCount()));

						_relations.addEdge(Naux, nodo, 1);
						_relations.addEdge(nodo, Naux, 1);
						// System.out.println("Nodo uno que añado: "+Naux.getName()+" -> "+nodo.getName());
						// System.out.println("Nodo dos que añado: "+nodo.getName()+" -> "+Naux.getName());
						fila++;
					}
				}

				col--;
			}
		}
	}

	/**
	 * @return the number of variables that appears the same than the one with
	 *         lowest appearance
	 */
	@SuppressWarnings("unused")
	private int getLowRepeated() {
		Iterator<NodoStorer> itNode = this._Nodes.listIterator();
		int previous = this._Nodes.getFirst().getCount();
		int actual = previous;
		int k = -1;
		while (actual == previous) {
			previous = actual;
			if (itNode.hasNext())
				actual = itNode.next().getCount();
			else {
				actual = 1;
				previous = 0;
			}
			k++;
		}
		return k;
	}

	private void restartNodes() {

		for (NodoStorer n : this._Nodes)
			n.getNode().restart();
	}

	/**
	 * Makes Jacobians matrix from the relation matrix and calls a method for
	 * solving them
	 * 
	 * @param relations
	 */
	private void RelationMatrix2Newton(ListMatrix relations,
			ArrayList<ArrayList<Node>> scc) {
		ArrayList<Byte> aux;
		LinkedList<Integer> Variables = new LinkedList<Integer>();
		int k = 0;
		// At first i check the equations with one variable for solving them
		// boolean found = false;

		/*
		 * while(k < relations.size()){ Variables.clear(); found = false; aux =
		 * relations.getRow(k); k++; if(ListMatrix.numberVariables(aux)==1){ k =
		 * 0; // while(!found){ // if(aux.get(i)!=ListMatrix.cero) // found =
		 * true; // else i++; //System.out.println("Found "+i); // } Variables =
		 * ListMatrix.AnalizeRow(Variables, aux); //Variables.add(new
		 * Integer(i)); relations.refresh(Variables);//SE QUEDAN FILAS SIN
		 * BORRAR!! MakeJacobian(Variables , scc); } }
		 */
		// System.out.println("Purgada");
		// System.out.println(relations);

		// Now i analyze the equations

		while (relations.size() > 0) {
			Variables.clear();
			k = 0;

			aux = relations.getRow(0);
			Variables = ListMatrix.AnalizeRow(Variables, aux);

			// At first i check if we have a equation with one variable
			if (ListMatrix.numberVariables(aux) == 1) {
				MakeJacobian(Variables, scc);
				relations.refresh(Variables);
			} else {
				while (ListMatrix.numberVariables(aux) != k + 1) {
					k++;
					aux = relations.OperateRow(aux, relations.getRow(k));
					Variables = ListMatrix.AnalizeRow(Variables, aux);
				}

				MakeJacobian(Variables, scc);
				relations.refresh(Variables);
			}
		}

	}

	// We need a Vector of functions, a vector of variables and a analitic
	// Jacobian.
	/**
	 * 
	 * Makes two lists one with the functions and one with the variables. And
	 * then it calls to the solvers methods.
	 * 
	 * @param Variables
	 * @param scc
	 */
	private void MakeJacobian(LinkedList<Integer> Variables,
			ArrayList<ArrayList<Node>> scc) {
		Collections.sort(Variables);
		Iterator<Integer> it = Variables.listIterator();
		Iterator<ArrayList<Node>> nodo = scc.listIterator();
		Iterator<Node> n;
		LinkedList<Integer> Functions = new LinkedList<Integer>();
		LinkedList<Integer> Vars = new LinkedList<Integer>();
		int i = 0, size = Variables.size(), aux, j = 0;

		int itvar = it.next();
		while (nodo.hasNext()) {
			n = nodo.next().listIterator();
			while (n.hasNext()) {
				aux = n.next().name;

				if (aux < 0 & i < size) {
					Functions.add(Math.abs(aux) - 1);// Add function position of
														// the
														// CheckString.Functions
					n.remove();
					i++;
				} else {
					if (j == itvar) {
						if (it.hasNext())
							itvar = it.next();
						Vars.add(aux - 1);
						n.remove();
					}

					j++;
				}
			}
		}
		// Now i have two lists with the numbers of the functions and the
		// variables

		/*-----------------------------------------SOLVER CALL-----------------------*/
		solver.LaunchOperations LO = new solver.LaunchOperations(Functions,
				Vars);
		solver.OperationCounter OC = new solver.OperationCounter();
		Thread N = new Thread(OC, "Clock");
		Thread m = new Thread(LO, "Operations");
		N.start();
		m.start();
		while (m.isAlive())
			if (!N.isAlive())
				m.interrupt();

	}

	/**
	 * Erase from the CheckString.Var the variables stored in
	 * CheckString.OneEquationVar. Erase the solved variables from the
	 * checkString.Functions. Solves the equations that now have one variable.
	 */

	public static void PreTarjan() {

		Iterator<VString> it;
		boolean found = false;
		VString auxV;

		/*--Search equations with one variable, for solving them--*/
		int pos = 0;

		while (pos != -1) {
			found = false;

			pos = searchOneVariableFunction();

			if (pos != -1) {

				/*--------------------------------ONE VARIABLE SOLVER CALL-----------------------*/

				solver.LaunchOperations LO = new solver.LaunchOperations(
						CheckString.Functions.get(pos).getEquation(),
						CheckString.Functions.get(pos).aux.get(0).GetVar());
				solver.OperationCounter OC = new solver.OperationCounter();
				Thread n = new Thread(OC, "Clock");
				Thread m = new Thread(LO, "Operations");
				n.start();
				m.start();
				while (m.isAlive())
					if (!n.isAlive())
						m.interrupt();

				// Change the function from Var to OneEquationVar
				it = CheckString.Var.Variables.listIterator();
				while (it.hasNext() & !found) {
					auxV = it.next();
					if (auxV.getVar().equalsIgnoreCase(
							CheckString.Functions.get(pos).aux.get(0).GetVar())) {
						CheckString.OneEquationVar.add(auxV);
DiffAndEvaluator.Evaluate(auxV.getVar());					
						it.remove();
						found = true;
					}
				}
				updateFunctions(CheckString.Functions.get(pos).aux.get(0)
						.GetVar());
				// Store the function
				CheckString.FunctionsSolved.add(CheckString.Functions.get(pos));
				// Remove the function from functions
				CheckString.Functions.remove(pos);

			}
		}

	}

	/**
	 * 
	 * @return -1 means no function found
	 */
	public static int searchOneVariableFunction() {
		int k = 0;
		for (EqStorer eq : CheckString.Functions) {
			if (eq.aux.size() == 1)
				return k;
			k++;
		}

		return -1;
	}

	/**
	 * Erase from the Functions List the variables that belongs to one variable
	 * equations
	 */
	public static void cleanFunction() {
		/*------Erase from the Functions List the variables that belongs to one variable equations--*/
		Iterator<DerivEquation> it2;
		DerivEquation Dev;
		for (EqStorer Eq : CheckString.Functions) {
			it2 = Eq.aux.listIterator();
			while (it2.hasNext()) {
				Dev = it2.next();
				for (VString S : CheckString.OneEquationVar)
					if (Dev.GetVar().equalsIgnoreCase(S.getVar()))
						it2.remove();
			}
		}
	}

	/**
	 * Erase from the Var List the variables that belongs to one variable
	 * equations
	 */
	public static void cleanVar() {
		Iterator<VString> it;
		boolean found = false;
		VString auxV;
		for (VString S : CheckString.OneEquationVar) {
			it = CheckString.Var.Variables.listIterator();
			found = false;
			while (it.hasNext() & !found) {
				auxV = it.next();
				if (auxV.getVar().equalsIgnoreCase(S.getVar())) {
					S.setCount(auxV.getCount() + 1);
					found = true;
					it.remove();
				}
			}
		}
	}

	/**
	 * Removes the variable from the equations of Functions
	 * 
	 * @param aux
	 */
	public static void updateFunctions(String aux) {
		Iterator<DerivEquation> it;
		for (EqStorer eq : CheckString.Functions) {
			it = eq.aux.listIterator();
			while (it.hasNext())
				if (it.next().GetVar().equalsIgnoreCase(aux))
					it.remove();
		}

	}

}