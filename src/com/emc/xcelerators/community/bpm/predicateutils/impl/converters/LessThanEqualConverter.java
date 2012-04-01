package com.emc.xcelerators.community.bpm.predicateutils.impl.converters;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BooleanConverter;

/**
 * LessThanEqualConverter converts compareTo() return values to
 * a boolean value.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class LessThanEqualConverter implements BooleanConverter {

	/**
	 * @return true if integer is less or equal to 0.
	 */
	@Override
	public boolean convert(int result) {
		return result <= 0;
	}

}
