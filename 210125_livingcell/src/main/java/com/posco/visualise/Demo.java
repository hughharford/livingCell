package com.posco.visualise;

import com.posco.visualise.ImageEditor;
import com.posco.visualise.Circle;
import com.posco.visualise.CompoundShape;
import com.posco.visualise.Dot;
import com.posco.visualise.Rectangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Demo {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();
        
        final CompoundShape ourShapes = new CompoundShape();

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
        
        // refresh
        
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
