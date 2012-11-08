package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Methods to work with the substances database
 * 
 * @author Pablo Salinas
 */
public class MaterialMethods {
	/**
	 * Name of the file
	 */
	public static final String ThermodynamicalFile = Config.AbsolutePath
			+ "ThermodynamicalProperties.txt";

	private Character cube = (char) 127;

	protected LinkedList<MaterialList> Materials;

	public MaterialMethods() {
		Materials = new LinkedList<MaterialList>();
		getTree();
		Collections.sort(this.Materials);
	}

	/**
	 * @deprecated
	 * @param Material
	 * @param Property
	 * @param formula
	 * @param variable
	 * @param Note
	 */
	protected void SaveMaterial(String Material, String Property,
			String formula, String variable, String Note) {
		try {
			String text = this.getString();
			text += "Material: " + Material + ";" + Config.JumpLine;
			text += "Property: " + Property + ";" + Config.JumpLine;
			text += "Formula: " + formula + ";" + Config.JumpLine;
			text += "Variable: " + variable + ";" + Config.JumpLine;
			text += "Note:" + Note + Config.JumpLine + cube;
			FileWriter w;
			w = new FileWriter(ThermodynamicalFile);
			BufferedWriter o = new BufferedWriter(w);
			PrintWriter p = new PrintWriter(o);
			p.append(text);
			text = "";
			p.close();
			o.close();
			w.close();
		} catch (IOException e) {
			SolverGUI.PopUpError(Translation.Language.get(350));
		}

	}

	/**
	 * Adds the input information to the Material List. This only saves the
	 * information in Ram. Not to the file.
	 * 
	 * @param Material
	 * @param Property
	 * @param formula
	 * @param variable
	 * @param Note
	 */
	public void saveTreeAndMaterial(String Material, String Property,
			String formula, String variable, String Note) {
		// Add the material to the List
		this.AddMaterial(Material, new MaterialStore(Property, formula,
				variable, Note));
		// Save
		this.saveTree();

	}

	/**
	 * Saves the Material List to the file
	 */
	public void saveTree() {
		try {
			// Order the list
			Collections.sort(this.Materials);
			// save the List in the file
			FileWriter w;
			w = new FileWriter(ThermodynamicalFile);
			BufferedWriter o = new BufferedWriter(w);
			PrintWriter p = new PrintWriter(o);
			for (MaterialList m : this.Materials)
				for (MaterialStore MS : m.getPropertyList()) {
					p.println("Material: " + m.getMaterial() + ";");
					p.println("Property: " + MS.getProperty() + ";");
					p.println("Formula: " + MS.getFormula() + ";");
					p.println("Variable: " + MS.getVariables() + ";");
					p.println("Note:" + MS.getNote());
					p.println(cube);
				}

			p.close();
			o.close();
			w.close();
		} catch (IOException e) {
			SolverGUI.PopUpError(Translation.Language.get(350));
		}
	}

	/**
	 * Returns the content of the file ThermodynamicalFile as a String
	 * 
	 * @return
	 */
	private String getString() {
		try {
			FileReader r = new FileReader(ThermodynamicalFile);
			BufferedReader b = new BufferedReader(r);
			String s = null;
			String text = new String();
			do {
				s = b.readLine();
				if (s != null)
					text += s + Config.JumpLine;
			} while (s != null);
			b.close();
			r.close();
			return text;
		} catch (IOException e) {
			SolverGUI.PopUpError(Translation.Language.get(350));
			return "";
		}
	}

	/**
	 * Reads the file and introduce the information.
	 */
	protected void getTree() {
		try {
			String text = this.getString();
			String[] tree = text.split(Character.toString(cube));
			text = null;
			// Every subString has a material with all the necessary information
			String Material = "";
			String Property = "";
			String Formula = "";
			String Variables = "";
			String Nota = "";
			MaterialStore Ms;
			int start;
			int end;
			int count;
			for (String s : tree) {
				count = 0;
				if (s.length() > 40) {// Material:+Property:+Variable:+Formula:+Note:
										// = 41 characters
					while (count < 5) {
						if (count < 4) {
							start = s.indexOf(":") + 2;
							end = s.indexOf(";");
							switch (count) {
							case 0:
								Material = s.substring(start, end);
								break;
							case 1:
								Property = s.substring(start, end);
								break;
							case 2:
								Formula = s.substring(start, end);
								break;
							case 3:
								Variables = s.substring(start, end);
								break;
							}
							s = s.substring(end + 1);

						} else {// read note
							start = s.indexOf(":") + 1;
							Nota = s.substring(start, s.length() - 1);

						}
						count++;
					}
					// Now i have the information and is time to add it to the
					// list
					Ms = new MaterialStore(Property, Formula, Variables, Nota);
					this.AddMaterial(Material, Ms);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			SolverGUI.PopUpError(Translation.Language.get(351));
		}
	}

	/**
	 * If the Material is already in the list then the property will be added.
	 * If not the new material with the property will be added to the list
	 * 
	 * @param Material
	 * @param store
	 */
	private void AddMaterial(String Material, MaterialStore store) {
		boolean found = false;
		for (MaterialList m : this.Materials) {
			if (m.getMaterial().equalsIgnoreCase(Material)) {
				m.addProperty(store);
				found = true;
				break;
			}
		}
		if (!found) {
			LinkedList<MaterialStore> aux = new LinkedList<MaterialStore>();
			aux.add(store);
			this.Materials.add(new MaterialList(Material, aux));
		}
	}

	/**
	 * @return A list with the variables
	 */
	public LinkedList<String> getMaterials() {
		LinkedList<String> aux = new LinkedList<String>();
		for (MaterialList m : this.Materials)
			aux.add(m.getMaterial());

		return aux;
	}

	/**
	 * @return A list with the variables
	 */
	public LinkedList<String> getProperties(String material) {
		for (MaterialList m : this.Materials)
			if (m.getMaterial().equalsIgnoreCase(material))
				return m.getProperties();

		return null;

	}

	/**
	 * 
	 * @param material
	 * @return A List with all the properties of the material
	 */
	public LinkedList<MaterialStore> getMaterial(String material) {
		for (MaterialList m : this.Materials)
			if (m.getMaterial().equalsIgnoreCase(material))
				return m.getPropertyList();
		return null;
	}

	/**
	 * Erase the content of the List
	 */
	public void clear() {
		this.Materials.clear();
	}

}