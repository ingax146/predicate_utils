package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.BooleanConverter;

/**
 * Function used to compare inputs with the Comparable<T>.compareTo() interface.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 * @param <T> - Input type, needs to extend the Comparable<T> interface.
 */
public class CompareFunction<T extends Comparable<T>> implements BinaryFunction<T> {
	protected BooleanConverter converter = null;

	/**
	 *
	 * @param aConverter - Converter describing how the compareTo result should be interpreted.
	 */
	public CompareFunction(BooleanConverter aConverter) {
		converter = aConverter;
	}
	
	/**
	 * @return true if both params are null, or the value of interpreting the
	 * result of the comparison.
	 */
	@Override
	public boolean apply(final T rhs, final T lhs) {
		if (rhs == null) {
			return rhs == lhs;
		}
		return converter.convert(rhs.compareTo(lhs));
	}
}
