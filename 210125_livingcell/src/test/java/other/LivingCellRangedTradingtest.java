package other;

import static org.junit.Assert.*;

import org.junit.Test;

import com.posco.livingcell.LivingCell;
import com.posco.livingcell.TraderProviderFactory;
import com.posco.livingcell.interfaces.LCRangedTradingForCell;
import com.posco.livingcell.interfaces.LivingCellForCell;
import mockLCMethods.MockConfirmStatusFactory;

class LivingCellRangedTradingtest {

    @Test
    void testLivingCellString() {
        //fail("Not yet implemented");
    }

    @Test
    void testGetCellName() {
        //fail("Not yet implemented");
    }

    @Test
    void testGetCellWall() {
        //fail("Not yet implemented");
    }

    @Test
    void testGetCloneReady() {
        //fail("Not yet implemented");
    }

    @Test
    void testRangedTrading() {
        // trading should be ranged when using the standard TraderProviderFactory
        String traderType = "Ranged";
        LCRangedTradingForCell lcUnderTest = new LivingCell("testCell", traderType, new TraderProviderFactory(), new MockConfirmStatusFactory());
        
        // set iterations to 50, results will be clear:
        int iterationsNeeded = 25;
        
        // set range to 1.2 to 1.2
        lcUnderTest.setTraderRange(1.2, 1.4);
        lcUnderTest.runCellOperations(iterationsNeeded);
        
        // cell will be a) alive, and b) cloneReady = true
        assertTrue("Cell should be alive after +ve "
        		+ "ranged input with iterations = " + iterationsNeeded,
        		lcUnderTest.getCellAlive());

        // set range to 0.6 to 0.7
        lcUnderTest.setTraderRange(0.6, 0.7);
        lcUnderTest.runCellOperations(iterationsNeeded);
        
        // cell will be a) dead
        assertFalse("Cell is not dead when expected to be",
        		lcUnderTest.getCellAlive());

        
    }

    @Test
    void testGetDoneIterations() {
        //fail("Not yet implemented");
    }

    @Test
    void testRunCellOperations() {
        //fail("Not yet implemented");
    }

    @Test
    void testMain() {
        //fail("Not yet implemented");
    }

}
