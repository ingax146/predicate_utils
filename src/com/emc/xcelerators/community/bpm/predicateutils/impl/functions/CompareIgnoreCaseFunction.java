package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.BooleanConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.EqualConverter;

public class CompareIgnoreCaseFunction implements BinaryFunction<String> {
	private BooleanConverter converter = null;
	
	public CompareIgnoreCaseFunction(EqualConverter aConverter) {
		converter = aConverter;
	}

	@Override
	public boolean apply(final String rhs, final String lhs) {
		if (rhs == null) {
			return lhs == null;
		} else {
			return converter.convert(rhs.compareToIgnoreCase(lhs));
		}
	}
}
