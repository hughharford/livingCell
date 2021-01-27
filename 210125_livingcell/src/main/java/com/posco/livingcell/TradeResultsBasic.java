package com.posco.livingcell;

import java.util.Random;

import com.posco.livingcell.interfaces.TradeResultsRangedForCell;

public class TradeResultsBasic implements TradeResultsRangedForCell {

    private double lowerRange;
    private double upperRange;
    private double singleTradeRatio;
    
	@Override
	public double provideResult() {
	    if (lowerRange == 0 || upperRange == 0) {
            // Later: something that uses: ec.util.MersenneTwisterFast
	        Random randomno = new Random(); 
	        singleTradeRatio = (randomno.nextDouble() + 0.55); // for immediate ease, use the notoriously bad java.util.Random
	        
	    } else {
	        singleTradeRatio = (lowerRange + upperRange)/2; // static for now, 
	    }
		return singleTradeRatio;
	}

	@Override
	public void initiateTradeIteration() {
		// Will run trade iteration to generate results

	}

    @Override
    public void setRange(double lower, double upper) {
        lowerRange = lower;
        upperRange = upper;
        
    }

}
