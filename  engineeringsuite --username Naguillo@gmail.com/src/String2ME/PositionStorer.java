package String2ME;

/**
 * Store to make the change of the formula of a substance call and to the call
 * 
 * @author Pablo Salinas
 * 
 */
public class PositionStorer {
	/**
	 * The original formula
	 */
	private String _original;
	/**
	 * The thing to write instead
	 */
	private String _Substitutor;

	public PositionStorer(String original, String formula) {
		this._original = original;
		this._Substitutor = formula;
	}

	public String getOriginal() {
		return this._original;
	}

	public String getSubstitutor() {
		return this._Substitutor;
	}

}
