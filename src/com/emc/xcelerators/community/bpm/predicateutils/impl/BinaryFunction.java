package com.emc.xcelerators.community.bpm.predicateutils.impl;

/**
 * Interface describing a binary function. The binary function takes one
 * type parameter to describe the input arguments.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 * @param <T> Type used as argument to apply.
 */
public interface BinaryFunction<T> {
	/**
	 * Method that is invoked to apply this function to the input values given as arguments.
	 *
	 * @param rhs - right hand side
	 * @param lhs - left hand side
	 *
	 * @return result of the function as a boolean. Depends on the function implementation.
	 */
	boolean apply(final T rhs, final T lhs);
}
