package com.posco.livingcell.interfaces;

import com.posco.datastructures.DataStore;

public interface VisualiserL2 extends VisualiserForCell {
	
	void visualiseCell(LivingCellForCell cell);
	void outputGraphics(DataStore<LCRangedTradingForCell> lcDeque);
	void reset();
}
