package mockLCMethods;

import com.posco.livingcell.ConfirmStatusFactory;
import com.posco.livingcell.interfaces.StatusForCell;

public class MockConfirmStatusFactory extends ConfirmStatusFactory {
    
    @Override
    public StatusForCell getStateChecker() {
        return new MockConfirmStatus();
    }
}