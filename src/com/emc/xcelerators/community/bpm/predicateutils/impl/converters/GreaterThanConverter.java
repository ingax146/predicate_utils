package com.emc.xcelerators.community.bpm.predicateutils.impl.converters;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BooleanConverter;

/**
 * GreaterThanConverter converts compareTo() return values to
 * a boolean value.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class GreaterThanConverter implements BooleanConverter {

	/**
	 * @return true if the integer value > 0
	 */
	@Override
	public boolean convert(int result) {
		return result > 0;
	}

}
