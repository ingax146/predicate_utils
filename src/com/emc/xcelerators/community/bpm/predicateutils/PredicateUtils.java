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
	Boolean[] not(final Boolean[] values);
	Boolean[] and(final Boolean[] rhs, final Boolean[] lhs);
	Boolean[] or(final Boolean[] rhs, final Boolean[] lhs);
	
	//Number functions
	Boolean[] lessThan(final Double[] rhs, final Double[] lhs);
	Boolean[] lessThanEqual(final Double[] rhs, final Double[] lhs);
	Boolean[] greaterThan(final Double[] rhs, final Double[] lhs);
	Boolean[] greaterThanEqual(final Double[] rhs, final Double[] lhs);
	Boolean[] equals(final Double[] rhs, final Double[] lhs);

	//inrange.. 
	
	//String functions
	Boolean[] equals(final String[] rhs, final String[] lhs);
	Boolean[] equalsIgnoreCase(final String[] rhs, final String[] lhs);
	
	//Date functions
	Boolean[] equals(final Date[] rhs, final Date[] lhs);
	Boolean[] before(final Date[] rhs, final Date[] lhs);
	Boolean[] after(final Date[] rhs, final Date[] lhs);
}
