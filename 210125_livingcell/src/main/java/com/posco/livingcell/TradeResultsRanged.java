package com.posco.livingcell;

import java.util.Random;

import com.posco.livingcell.interfaces.TradeResultsRangedForCell;

public class TradeResultsRanged implements TradeResultsRangedForCell {

    private double lowerRange;
    private double upperRange;
    private double singleTradeRatio;
    
    @Override
    public double provideResult() {
        if (lowerRange == 0 || upperRange == 0) {
            throw new IllegalArgumentException("lowerRange and upperRange still at 0, please use LivingCell.setTraderRange(double, double).");
        
        } else {
            
            Random randomno = new Random();
            double range = upperRange - lowerRange;
            singleTradeRatio = lowerRange + (randomno.nextDouble() * range); // for now, use bad java.util.Random
            
        }
        // System.out.println("singleTradeRatio = " + singleTradeRatio);
        
        return singleTradeRatio;
    }

	@Override
	public void initiateTradeIteration() {
		// Will run trade iteration to generate results

	}

    @Override
    public void setRange(double lower, double upper) {
        upperRange = upper;
        lowerRange = lower;
    }
    
    

}
