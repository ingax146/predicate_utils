package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.BooleanConverter;

public class CompareFunction<T extends Comparable<T>> implements BinaryFunction<T> {
	protected BooleanConverter converter = null;

	public CompareFunction(BooleanConverter aConverter) {
		converter = aConverter;
	}
	
	@Override
	public boolean apply(final T rhs, final T lhs) {
		if (rhs == null) {
			return rhs == lhs;
		}
		return converter.convert(rhs.compareTo(lhs));
	}
}
