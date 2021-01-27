package com.posco.livingcell;

import com.posco.livingcell.interfaces.StatusForCell;

public class ConfirmStatusFactory {
	public StatusForCell getStateChecker() {
		return new ConfirmStatusBasic();
	}
}
