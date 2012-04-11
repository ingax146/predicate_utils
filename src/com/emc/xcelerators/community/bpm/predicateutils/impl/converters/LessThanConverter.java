package com.emc.xcelerators.community.bpm.predicateutils.impl.converters;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BooleanConverter;

/**
 * LessThanConverter converts compareTo() return values to
 * a boolean value.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class LessThanConverter implements BooleanConverter {

	/**
	 * @param result 
	 * @return true if integer is less than 0.
	 */
	public boolean convert(int result) {
		return result < 0;
	}

}
