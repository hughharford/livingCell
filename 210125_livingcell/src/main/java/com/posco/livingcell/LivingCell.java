package com.posco.livingcell;

import com.posco.livingcell.interfaces.LCRangedTradingForCell;
import com.posco.livingcell.interfaces.StatusForCell;
import com.posco.livingcell.interfaces.TradeResultsRangedForCell;
import com.posco.livingcell.interfaces.VisualiserForCell;


public class LivingCell implements LCRangedTradingForCell {
	// Living cell creation and operation (via iterations)

	private String cellName;	
	private double cellWall;
	private double totalTaxDerived;
	private int doneIterations;
	private boolean cloneReady;	
	private boolean cellAlive;	

	private TradeResultsRangedForCell tradeNumbers;
	private StatusForCell cellState;
		
	public LivingCell() {   // constructor: default set up 
	    cellName = "no name";
	    
	    livingCellSetup();
		
	}	
		
	public LivingCell(String nameForCell) {   // constructor: named cell
	    cellName = nameForCell;
	    cellWall = CELLSTARTDEFAULT;
	    cloneReady = false;
	    
	    livingCellSetup();
	}	
	
	// constructor: with DI, can be used for testing
	public LivingCell(String nameForCell, String traderType, TraderProviderFactory traderMachine, ConfirmStatusFactory statusMachine) {   
	    cellName = nameForCell;
	    cellWall = CELLSTARTDEFAULT;
	    cloneReady = false;

	    tradeNumbers = traderMachine.getTrader(traderType);
	    cellState = statusMachine.getStateChecker();
	}
	
	private void livingCellSetup() {  // setup method to avoid duplication, but no good for Dependency Injection

		// to allow this - as a separated out method, to be mocked
		TraderProviderFactory traderMachine = new TraderProviderFactory();
		tradeNumbers = traderMachine.getTrader("Basic");
		
		
		// to allow this - as a separated out method, to be mocked
		ConfirmStatusFactory statusMachine = new ConfirmStatusFactory();
		cellState = statusMachine.getStateChecker();
	}

	
    @Override
    public void setTraderRange(double lower, double higher) {
        tradeNumbers.setRange(lower, higher);
        
    }
	
	@Override
	public String getCellName() { return cellName; }
	
	@Override
	public double getCellWall() { return cellWall; }
	
	@Override
	public boolean getCloneReady() { return cloneReady; }
	
	@Override
	public boolean getCellAlive() { return cellAlive; }
	
	@Override
	public int getDoneIterations() { return doneIterations; }
	
	@Override
	public double getTotalTaxDerived() { return totalTaxDerived; } 

	@Override
	public void runCellOperations(int noIterations) {
	    
        for(int i=0; i<noIterations; i++){
        	cellWall = cellState.lengthCellWall(cellWall, tradeNumbers.provideResult());
        }
        doneIterations = doneIterations + noIterations;
		cloneReady = cellState.cloneReady(cellWall);
		cellAlive = cellState.checkCellLives(cellWall);
		totalTaxDerived = totalTaxDerived + cellState.calcTaxThisIteration(cellWall);
		
	}

	public static void main(String[] args) {
		String traderType = "Ranged";
		LivingCellFactory cellMachine = new LivingCellFactory();
		
		LCRangedTradingForCell lcOne = 	cellMachine.getCell("Our new cell");
        
		LCRangedTradingForCell lcTwo = new LivingCell("newCell", traderType, new TraderProviderFactory(), new ConfirmStatusFactory());

		lcTwo.setTraderRange(1.2, 1.3);
		lcTwo.runCellOperations(50);
		
		VisualiserFactory visualMachine = new VisualiserFactory();
		VisualiserForCell cellOutput = visualMachine.getVisualiser("show");
		cellOutput.printBasicCellData(lcTwo);


		
	}

}
