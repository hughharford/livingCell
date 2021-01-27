package other;

import static org.junit.Assert.assertFalse;
import org.junit.Test;
import com.posco.livingcell.LivingCell;

class LivingCellTest {

    @Test
    void test() {
        LivingCell lc1 = new LivingCell();
        assertFalse(lc1.getCellName().isEmpty());
        
    }

}
