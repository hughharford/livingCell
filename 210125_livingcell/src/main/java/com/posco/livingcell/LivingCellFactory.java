package com.posco.livingcell;

import com.posco.livingcell.interfaces.LCRangedTradingForCell;

public class LivingCellFactory {
	
	public LCRangedTradingForCell getCell(String cellName, String otherString, TraderProviderFactory traderProvider, ConfirmStatusFactory statusProvider) {
			return new LivingCell(cellName, otherString, traderProvider, statusProvider);
	}

	public LCRangedTradingForCell getCell(String cellName) {  
	        return new LivingCell(cellName);
	}
	
	
}
