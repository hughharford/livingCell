package mockLCMethods;

import com.posco.livingcell.TraderProviderFactory;
import com.posco.livingcell.interfaces.TradeResultsRangedForCell;

public class MockTraderProviderFactory extends TraderProviderFactory {
	
    @Override
    public TradeResultsRangedForCell getTrader(String traderType) {
		return new MockTradeResults();
	}
}
