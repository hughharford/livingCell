package com.posco.runenvironment;

import java.util.Iterator;

import com.posco.datastructures.DataDeque;
import com.posco.datastructures.DataStore;
import com.posco.livingcell.ConfirmStatusFactory;
import com.posco.livingcell.LivingCell;
import com.posco.livingcell.LivingCellFactory;
import com.posco.livingcell.TraderProviderFactory;
import com.posco.livingcell.VisualiserFactory;
import com.posco.livingcell.interfaces.LCRangedTradingForCell;
import com.posco.livingcell.interfaces.VisualiserForCell;

public class RunEnvironment<Item> implements SpecForEnvironment, Iterable<Item> {

    public int countCells = 10;
    private String traderType = "Ranged";
    private DataStore<LCRangedTradingForCell> lcDeque;
    private double lowerRange = 1.2;
    private double upperRange = 1.7; 
    
    private TraderProviderFactory traderFactory;
    private ConfirmStatusFactory statusFactory;
    private LivingCellFactory cellFactory;
    private DataStoreFactory dStoreFactory;
   

    // constructor taking dependency injections:
    public RunEnvironment(LivingCellFactory lcMaker, TraderProviderFactory traderMachine, ConfirmStatusFactory confirmStatusMachine) {
        traderFactory = traderMachine;
        statusFactory = confirmStatusMachine;
        cellFactory = lcMaker;
        lcDeque = createLivingCellPopulation();
    }
 
    @Override
    public DataStore<LCRangedTradingForCell> createLivingCellPopulation() {
        
        // create the data store
        dStoreFactory = new DataStoreFactory();
        lcDeque = dStoreFactory.getDataStore(); 

        // sets up a population
        for (int cellNo = 0; cellNo < countCells; cellNo++) {
            LCRangedTradingForCell tempCell = cellFactory.getCell(
                    "newCell", traderType, traderFactory, statusFactory);
            
            tempCell.setTraderRange(lowerRange, upperRange);
            lcDeque.addFirst(tempCell);
        } 
        return lcDeque;
    }

    @Override
    public void runEnvironmentIterations(int noIterations) {
        for (int cellNo = 0; cellNo < countCells; cellNo++) {
            lcDeque.getIndexed(cellNo).runCellOperations(noIterations);
        }        
    }

    @Override
    public void visualiseEnvironment() {
        String graphic = "Graphics One";
        VisualiserFactory visualMachine = new VisualiserFactory();
        VisualiserForCell cellOutput = visualMachine.getVisualiser(graphic);
        for (int cellNo = 0; cellNo < countCells; cellNo++) {
            // cellOutput.printBasicCellData(lcDeque.getIndexed(cellNo));
        }
        cellOutput.printBasicCellData(lcDeque.getIndexed(1));    
        cellOutput.visualiseCell(lcDeque.getIndexed(1));    
    }
    
    public static void main(String[] args) {
        String[] argsIn = {""};
        EnvironmentFactory reMachine = new EnvironmentFactory();
        SpecForEnvironment rE = reMachine.getEnvironment(argsIn);
        rE.createLivingCellPopulation();
        rE.runEnvironmentIterations(25);
        rE.visualiseEnvironment();
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return null;
    }


}

class EnvironmentFactory {
    public SpecForEnvironment getEnvironment(String [] args) {
            LivingCellFactory lcMakerProto = new LivingCellFactory();
            return new RunEnvironment<LCRangedTradingForCell>(lcMakerProto, new TraderProviderFactory(), new ConfirmStatusFactory());
    }
}

class DataStoreFactory {
    public DataStore<LCRangedTradingForCell> getDataStore() {
        return new DataDeque<>();
    }
}
