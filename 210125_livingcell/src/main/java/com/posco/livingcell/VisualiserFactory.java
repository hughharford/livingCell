package com.posco.livingcell;

import com.posco.livingcell.interfaces.VisualiserForCell;

public class VisualiserFactory {

	public VisualiserForCell getVisualiser() {
		return new VisualiserBasic();
	}

	public VisualiserForCell getVisualiser(String graphics) {
	    return new VisualiserGraphicOne(graphics);
	}
	
}
