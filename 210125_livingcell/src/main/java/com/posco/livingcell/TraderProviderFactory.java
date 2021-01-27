package com.posco.livingcell;

import com.posco.livingcell.interfaces.TradeResultsRangedForCell;

public class TraderProviderFactory {
	public TradeResultsRangedForCell getTrader(String traderType) {
		
	    if (traderType.contentEquals("Basic")) { 
		    return new TradeResultsBasic(); 
        } else if (traderType.contentEquals("Ranged")) {
            return new TradeResultsRanged();
        }
        return null;
	}
	
}
