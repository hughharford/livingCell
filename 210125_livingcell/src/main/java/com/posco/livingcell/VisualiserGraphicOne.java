package com.posco.livingcell;

import com.posco.livingcell.interfaces.LivingCellForCell;
import com.posco.livingcell.interfaces.VisualiserForCell;

public class VisualiserGraphicOne implements VisualiserForCell {

    public VisualiserGraphicOne(String graphicsInput) {
        System.out.println("EMPTY METHOD NOW.... Printing: " + graphicsInput);
    }


    
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
        System.out.println(" Tax derived:       " + cell.getTotalTaxDerived());

    }

    @Override
    public void visualiseCell(LivingCellForCell cell) {
        // To be completed
        // A more fully formed visualisation
        int timeInThousandths = 750;
        try {
        	System.out.println("THIS USED TO DO SOMETHING< BUT NOT ANY MORE");
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }

    
}
