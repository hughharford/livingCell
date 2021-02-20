package com.posco.livingcell;

import java.awt.Color;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.posco.datastructures.DataStore;
import com.posco.livingcell.interfaces.LCRangedTradingForCell;
import com.posco.livingcell.interfaces.LivingCellForCell;
import com.posco.livingcell.interfaces.VisualiserForCell;
import com.posco.livingcell.interfaces.VisualiserL2;
import com.posco.visualise.Circle;
import com.posco.visualise.CompoundShape;
import com.posco.visualise.Dot;
import com.posco.visualise.ImageEditor;
import com.posco.visualise.Rectangle;

public class VisualiserGraphicOne 
			extends VisualiserBasic 
			implements VisualiserL2 {
	
	final ImageEditor editor;
	final CompoundShape ourShapes;
	int R = 30;
	int G = 30;
	int B = 30;
	int colourIncr = 150;

    public VisualiserGraphicOne(String graphicsInput) {
        System.out.println("VisualiserGraphicOne >>>> output named: " + graphicsInput);
        
        editor = new ImageEditor();
        ourShapes = new CompoundShape();
    
    }

    @Override
    public void visualiseCell(LivingCellForCell cell) {

    	Color nextColour = new Color(R+colourIncr, G+colourIncr, B+colourIncr);
    	ourShapes.add(new Circle(
    			10, 10, 
    			(int) cell.getCellWall() / cell.getDoneIterations(), 
    			nextColour));
        editor.loadShapes(ourShapes);

    }
    
    public void reset() {
    	ourShapes.clear();
        editor.loadShapes(ourShapes);
        editor.updateCanvas();

    }
    
    public void outputGraphics(DataStore<LCRangedTradingForCell> lcDeque) {

        // initialise shapes
        ourShapes.add(new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                    new Circle(110, 110, 50, Color.RED),
                    new Dot(160, 160, Color.RED)
                ),
                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
        // load shapes
        editor.loadShapes(ourShapes);
        
        singleDelayedTask(ourShapes, editor, 25, 35);

        
        editor.updateCanvas();
    }
    
    public static void singleDelayedTask(CompoundShape ourShapes, ImageEditor editor, int moveX, int moveY) {
        TimerTask task = new TimerTask() {
            public void run() {
            	
                ourShapes.move(moveX, moveY);
                editor.updateCanvas();
            	
                System.out.println("Task performed on: " + new Date() + " n " +
                  "Thread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer("Timer");
        
        long delay = 1000L;
        timer.schedule(task, delay);
    }

    
}
