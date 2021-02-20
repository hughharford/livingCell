package com.posco.livingcell;

import java.awt.Color;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.posco.livingcell.interfaces.LivingCellForCell;
import com.posco.livingcell.interfaces.VisualiserForCell;
import com.posco.visualise.Circle;
import com.posco.visualise.CompoundShape;
import com.posco.visualise.Dot;
import com.posco.visualise.ImageEditor;
import com.posco.visualise.Rectangle;

public class VisualiserBasic implements VisualiserForCell {

	@Override
	public void printBasicCellData(LivingCellForCell cell) {
		
		System.out.println("Visualising cell: \n Cell:              " + cell.getCellName());
		if(cell.getCellAlive()) { 
			System.out.print(" Cell is:           ALIVE!\n"); 
		} else { 
			System.out.print(" Cell is:           _____________ DEAD...\n"); 
		}
		System.out.format(" Cell size:         %.2f%n", cell.getCellWall());
		System.out.println(" Clone ready:       " + cell.getCloneReady());
		System.out.println(" Iterations done:   " + cell.getDoneIterations());

	}
			
}
