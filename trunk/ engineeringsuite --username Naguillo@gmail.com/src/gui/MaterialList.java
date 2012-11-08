package gui;

import java.util.LinkedList;

class MaterialList implements Comparable<MaterialList> {
	private String _Material;
	private LinkedList<MaterialStore> _Lista;

	protected MaterialList() {
		this._Material = new String();
		this._Lista = new LinkedList<MaterialStore>();
	}

	protected MaterialList(String name, LinkedList<MaterialStore> List) {
		this._Material = name;
		this._Lista = List;
	}

	protected void setMaterial(String name) {
		this._Material = name;
	}

	protected String getMaterial() {
		return this._Material;
	}

	/**
	 * 
	 * @return A MaterialStore List of the material
	 */
	protected LinkedList<MaterialStore> getPropertyList() {
		return this._Lista;
	}

	/**
	 * 
	 * @return A linkedList with the names of all the properties
	 */
	protected LinkedList<String> getProperties() {
		LinkedList<String> Lista = new LinkedList<String>();
		for (MaterialStore m : this._Lista)
			Lista.add(m.getProperty());
		return Lista;
	}

	protected void addProperty(MaterialStore Store) {
		this._Lista.add(Store);
	}

	public int compareTo(MaterialList input) {
		return this._Material.charAt(0) - input._Material.charAt(0);
	}

}