package other;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.posco.livingcell.LivingCell;
import com.posco.livingcell.interfaces.LivingCellForCell;
import mockLCMethods.MockConfirmStatusFactory;
import mockLCMethods.MockTraderProviderFactory;

class LivingCellMethodsCalltest {
    @BeforeClass 
    void testLivingCell() {
        //fail("Not yet implemented");
    }

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
    void testCellBasics() {
        LivingCellForCell lcUnderTest = new LivingCell("testCell", "Basic", new MockTraderProviderFactory(), new MockConfirmStatusFactory());
        //fail("Not yet implemented");
        lcUnderTest.runCellOperations(1);
        assertTrue("Mocked method 'MockConfirmStatus' not in use", lcUnderTest.getCellWall() == 19.0);
        assertFalse("Forcibly killed off cell is not dead", lcUnderTest.getCellAlive());
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
