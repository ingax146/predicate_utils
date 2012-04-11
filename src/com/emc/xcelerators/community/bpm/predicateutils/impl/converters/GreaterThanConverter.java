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
	 * @param result 
	 * @return true if the integer value > 0
	 */
	public boolean convert(int result) {
		return result > 0;
	}

}
