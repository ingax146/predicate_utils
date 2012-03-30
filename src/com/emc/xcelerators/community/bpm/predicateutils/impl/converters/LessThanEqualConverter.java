package com.emc.xcelerators.community.bpm.predicateutils.impl.converters;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BooleanConverter;

public class LessThanEqualConverter implements BooleanConverter {

	@Override
	public Boolean convert(int result) {
		return result <= 0;
	}

}
