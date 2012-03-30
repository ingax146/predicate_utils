package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;

public class BooleanOrFunction implements BinaryFunction<Boolean> {

	@Override
	public boolean apply(final Boolean rhs, final Boolean lhs) {
		if (rhs == null) {
			if (lhs == null) {
				return false;
			} else {
				return lhs.booleanValue();
			}
		} else {
			return rhs.booleanValue() || lhs.booleanValue();
		}
	}

}
