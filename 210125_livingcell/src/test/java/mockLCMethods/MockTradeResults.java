package mockLCMethods;

import com.posco.livingcell.interfaces.TradeResultsRangedForCell;

public class MockTradeResults implements TradeResultsRangedForCell  {
// TradeResultsRangedForCell
    
    @Override
    public double provideResult() {
        return 0;
    }

    @Override
    public void initiateTradeIteration() {
        // Later... bad practice but still new to dependency injection
    }

    @Override
    public void setRange(double lower, double higher) {
        // TODO Auto-generated method stub
        
    }

}
