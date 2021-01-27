package com.posco.runenvironment;

import com.posco.datastructures.DataStore;
import com.posco.livingcell.interfaces.LCRangedTradingForCell;

public interface SpecForEnvironment {

    DataStore<LCRangedTradingForCell> createLivingCellPopulation();
    void runEnvironmentIterations(int noIterations);
    void visualiseEnvironment();
    
    
}
