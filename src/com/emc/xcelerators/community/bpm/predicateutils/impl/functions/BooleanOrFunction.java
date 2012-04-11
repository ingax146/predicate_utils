package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;

/**
 * BooleanOrFunction captures the functionality of applying a
 * || operator between two values.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class BooleanOrFunction implements BinaryFunction<Boolean> {

	/**
	 * @return true if one or both of rhs, lhs is true. False if both rhs and lhs are null.
	 */
	public boolean apply(final Boolean rhs, final Boolean lhs) {
		if (rhs == null) {
			if (lhs == null) {
				return false;
			} 
			return lhs.booleanValue();
		}
		return rhs.booleanValue() || lhs.booleanValue();
	}
}
