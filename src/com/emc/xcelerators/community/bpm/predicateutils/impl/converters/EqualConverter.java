package com.emc.xcelerators.community.bpm.predicateutils.impl.converters;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BooleanConverter;

/**
 * Converts interger input to true if the integer represents an equal comparison
 * value. See Comparator.compareTo() and Comparable<T> interface in java reference
 * for more information.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class EqualConverter implements BooleanConverter {

	/**
	 * @param result 
	 * @return true iff the integer is 0.
	 */
	public boolean convert(int result) {
		return result == 0;
	}
}
