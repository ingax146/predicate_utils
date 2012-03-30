package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import com.emc.xcelerators.community.bpm.predicateutils.impl.UnaryFunction;

public class BooleanNotFunction implements UnaryFunction<Boolean> {

	@Override
	public boolean apply(final Boolean element) {
		if (element == null) {
			return false;
		} else {
			return !element.booleanValue();
		}
	}

}
