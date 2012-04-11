package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.BooleanConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.EqualConverter;

/**
 * Function used to compare string values without the respect of
 * case sensitivity.
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class CompareIgnoreCaseFunction implements BinaryFunction<String> {
	private BooleanConverter converter = null;
	
	/**
	 * CompareIgnoreCase uses the String.compareToIgnoreCase() function
	 * which in turns return an integer, therefore the CompareIgnoreCaseFunction
	 * requires a compareToBoolean converter. This converter is given to 
	 * the constructor.
	 *
	 * @param aConverter
	 */
	public CompareIgnoreCaseFunction(EqualConverter aConverter) {
		converter = aConverter;
	}

	/**
	 * @return true if both input strings are null, or if both input strings
	 * are equal without respect for case sensitivity.
	 */
	public boolean apply(final String rhs, final String lhs) {
		if (rhs == null) {
			return lhs == null;
		} 
		return converter.convert(rhs.compareToIgnoreCase(lhs));
	}
}
