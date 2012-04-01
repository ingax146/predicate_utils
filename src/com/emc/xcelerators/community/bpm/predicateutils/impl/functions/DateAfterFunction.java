package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import java.util.Date;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;

/**
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class DateAfterFunction implements BinaryFunction<Date>{

	/**
	 * @return true iff date rhs is after lhs
	 */
	@Override
	public boolean apply(final Date rhs, final Date lhs) {
		if (rhs == null) {
			throw new NullPointerException();
		} 
		return rhs.after(lhs);
	}
}
