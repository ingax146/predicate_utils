package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;

/**
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class BooleanAndFunction implements BinaryFunction<Boolean> {

	/**
	 * @return true if both inputs are true, false otherwise. If one
	 * rhs,lhs is null, then false.
	 */
	public boolean apply(final Boolean rhs, final Boolean lhs) {
		if (rhs == null || lhs == null) {
			return false;
		}
		return rhs.booleanValue() && lhs.booleanValue();
	}
}
