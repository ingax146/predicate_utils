package com.emc.xcelerators.community.bpm.predicateutils.impl;

/**
 * BooleanConverter is an interface describing a method used to
 * convert integer values to booleans.
 *
 * Subclasses of BooleanConverter is used in the ComparatorFunction
 * implementation.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public interface BooleanConverter {

	/**
	 *
	 * @param result - result from a Comparator.compareTo() call.
	 * @return a Boolean describing the converted value.
	 */
	boolean convert(int result);
}
