package com.emc.xcelerators.community.bpm.predicateutils;

import java.util.Date;

import com.documentum.fc.client.IDfModule;

/**
 * This module can be used to check if a string is equal or not, 
 * there are both case sensitive and non case sensitive comparisons.
 * 
 * Basically there should be a data mapper function for doing this 
 * operation, but since the support for extending the data mapper 
 * functions is not published this BOF module was created. 
 * 
 * A check in the StringUtils xCelerator shown no traces of an equal
 * method. So that made it appropriate to create this BOF module.
 * 
 * 
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public interface PredicateUtils extends IDfModule {
	//Boolean functions
	/**
	 *
	 * @param values
	 * @return An array with Booleans representing the value of negating each input value.
	 */
	Boolean[] not(final Boolean[] values);
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return An array with Booleans representing the result of "rhs AND lhs" for each given input element.
	 */
	Boolean[] and(final Boolean[] rhs, final Boolean[] lhs);
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return An array with Booleans representing the result of "rhs OR lhs" for each given input element.
	 */
	Boolean[] or(final Boolean[] rhs, final Boolean[] lhs);
	
	//Number functions

	/**
	 * @param rhs
	 * @param lhs
	 * @return Array with Booleans describing if the rhs value is less than the lhs value, for each element in rhs.
	 * 			See Java SE 6 reference Double.compareTo() method for more information.
	 */
	Boolean[] lessThan(final Double[] rhs, final Double[] lhs);
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return True if both dates are equal. See Java SE 6 reference Double.compareTo() method for more information.
	 */
	Boolean[] lessThanEqual(final Double[] rhs, final Double[] lhs);
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return True if both dates are equal. See Java SE 6 reference Double.compareTo() method for more information.
	 */
	Boolean[] greaterThan(final Double[] rhs, final Double[] lhs);
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return True if both dates are equal. See Java SE 6 reference Double.compareTo() method for more information.
	 */
	Boolean[] greaterThanEqual(final Double[] rhs, final Double[] lhs);
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return True if both dates are equal. See Java SE 6 reference Double.compareTo() method for more information.
	 */
	Boolean[] equals(final Double[] rhs, final Double[] lhs);
	
	//String functions
	/**
	 * @param rhs
	 * @param lhs
	 * @return true iff both input strings are equal, respecting case sensitivity.
	 */
	Boolean[] equals(final String[] rhs, final String[] lhs);
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return true iff both input strings are equal, not respecting case sensitivity.
	 */
	Boolean[] equalsIgnoreCase(final String[] rhs, final String[] lhs);
	
	//Date functions
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return True if both dates are equal. See Java SE 6 reference Date.compareTo() method for more information.
	 */
	Boolean[] equals(final Date[] rhs, final Date[] lhs);
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return True if both dates are equal. See Java SE 6 reference Date.before() method for more information.
	 */
	Boolean[] before(final Date[] rhs, final Date[] lhs);
	/**
	 *
	 * @param rhs
	 * @param lhs
	 * @return True if both dates are equal. See Java SE 6 reference Date.after() method for more information.
	 */
	Boolean[] after(final Date[] rhs, final Date[] lhs);
}
