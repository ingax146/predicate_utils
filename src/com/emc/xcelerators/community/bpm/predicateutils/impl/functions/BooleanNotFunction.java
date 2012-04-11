package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import com.emc.xcelerators.community.bpm.predicateutils.impl.UnaryFunction;

/**
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class BooleanNotFunction implements UnaryFunction<Boolean> {

	/**
	 * @return true if input is false, otherwise false.
	 */
	public boolean apply(final Boolean element) {
		if (element == null) {
			return false;
		}
		return !element.booleanValue();
	}
}
