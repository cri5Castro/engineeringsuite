package gui;

/**
 * Class that store two string. Used to store a formula in a String and a note
 * about that formula; For example the units of the formula;
 * 
 * @author Pablo Salinas
 * 
 */
class MaterialStore {
	private String _Property;
	private String _Formula;
	private String _Note;
	private String _Variables;

	public MaterialStore(String Property, String formula, String Variables,
			String note) {
		this._Formula = formula;
		this._Note = note;
		this._Variables = Variables;
		this._Property = Property;
	}

	public MaterialStore(String Property, String formula) {
		this._Formula = formula;
		this._Note = "";
		this._Variables = "";
		this._Variables = Property;
	}

	protected String getFormula() {
		return this._Formula;
	}

	protected String getNote() {
		return this._Note;
	}

	protected String getVariables() {
		return this._Variables;
	}

	protected String getProperty() {
		return this._Property;
	}

	protected void setFormula(String formula) {
		this._Formula = formula;
	}

	protected void setNote(String Note) {
		this._Note = Note;
	}

	protected void setVariables(String Variables) {
		this._Variables = Variables;
	}

	protected void setProperty(String Property) {
		this._Property = Property;
	}
}