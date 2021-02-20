package com.posco.livingcell;

import com.posco.livingcell.interfaces.VisualiserForCell;
import com.posco.livingcell.interfaces.VisualiserL2;

public class VisualiserFactory {

	public VisualiserForCell getVisualiserBasic() {
		return new VisualiserBasic();
	}

	public VisualiserL2 getVisualiserL2(String graphics) {
	    return new VisualiserGraphicOne(graphics);
	}
	
}
