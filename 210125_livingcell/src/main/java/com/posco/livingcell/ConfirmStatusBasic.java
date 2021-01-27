package com.posco.livingcell;

import com.posco.livingcell.interfaces.StatusForCell;

public class ConfirmStatusBasic implements StatusForCell {

	private boolean cloneReady = false;
	
	@Override
	public boolean checkCellLives(double cellWallLength) {
		if(MINWALL > cellWallLength) { return false; }
		return true;
	}

	@Override
	public boolean cloneReady(double cellWallLength) {
		if(CLONEMINSIZE < cellWallLength) { cloneReady = true; }
		return cloneReady;
	}

	@Override
	public double lengthCellWall(double previousWallLength, double tradeResults) {
		return previousWallLength * tradeResults;
	}

	@Override
	public double calcTaxThisIteration(double cellWallLength) {
		return cellWallLength * TAX_PERCENTAGE;
	}

}
