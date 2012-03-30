package com.emc.xcelerators.community.bpm.predicateutils.impl;

public interface BinaryFunction<T> {
	boolean apply(final T rhs, final T lhs);
}
