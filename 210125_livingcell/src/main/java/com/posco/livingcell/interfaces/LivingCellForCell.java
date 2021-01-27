package com.posco.livingcell.interfaces;

public interface LivingCellForCell {
	// defines most basic cell requirements

    // define constants
	public int CELLSTARTDEFAULT = 100;
	
	void runCellOperations(int noIterations);
	String getCellName();
	double getCellWall();
	boolean getCloneReady();
	boolean getCellAlive();
	int getDoneIterations();
	double getTotalTaxDerived();

	
	
}