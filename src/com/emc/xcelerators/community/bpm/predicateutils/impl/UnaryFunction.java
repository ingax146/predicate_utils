package com.emc.xcelerators.community.bpm.predicateutils.impl;

/**
 * Interface describing unary functions.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 * @param <T> - Type parameter describing the input values to the unary function.
 */
public interface UnaryFunction<T> {
	/**
	 *
	 * @param element - argument
	 * @return a boolean value depending on the implementation of this interface.
	 */
	boolean apply(final T element);
}
