package com.emc.xcelerators.community.bpm.predicateutils.impl.functions;

import java.util.Date;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;

/**
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class DateBeforeFunction implements BinaryFunction<Date> {

	/**
	 * @return true iff rhs is before lhs
	 */
	@Override
	public boolean apply(final Date rhs, final Date lhs) {
		if (rhs == null) {
			throw new NullPointerException();
		}
		return rhs.before(lhs);
	}
}
