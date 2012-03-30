package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import java.util.Date;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;

public class DateBeforeFunction implements BinaryFunction<Date> {

	@Override
	public boolean apply(final Date rhs, final Date lhs) {
		if (rhs == null) {
			throw new NullPointerException();
		} else {
			return rhs.before(lhs);
		}
	}

}
