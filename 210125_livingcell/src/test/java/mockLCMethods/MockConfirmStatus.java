package mockLCMethods;

import com.posco.livingcell.interfaces.StatusForCell;

public class MockConfirmStatus implements StatusForCell {
// and / or should it extend ConfirmStatusBasic ??
    
	private boolean cloneReady = false;
	
	@Override
	public boolean checkCellLives(double cellWallSize) {
		if(MINWALL > cellWallSize) { return false; }
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
	    // return 19; // i.e. dead what ever
	}

	@Override
	public double calcTaxThisIteration(double cellWallLength) {
		// TODO Auto-generated method stub
		return 0;
	}
		
}
