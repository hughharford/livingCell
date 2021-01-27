package com.posco.livingcell.interfaces;

public interface StatusForCell {
	// interface to define how health is checked for Living Cells
	// includes cell status - alive/dead
	
	int CLONEMINSIZE = 200;
	int MINWALL = 25;
	double TAX_PERCENTAGE = 0.05;
	
	
	boolean checkCellLives(double cellWallLength);
	boolean cloneReady(double cellWallLength);
	double lengthCellWall(double previousWallLength, double tradeResults);
	double calcTaxThisIteration(double cellWallLength);
	
}
