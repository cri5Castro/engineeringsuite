package plot;

import java.awt.Frame;

/**
 * This class is from SymjaProject
 */
public class PlotWindow extends AbstractPlotWindow {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlotWindow(Frame parent) {
		super(parent);
	}

	public Plotter createPlot() {
		return Plotter.getPlotter();
	}

	public void addField() {
		addField("y(x) = ");
	}
}