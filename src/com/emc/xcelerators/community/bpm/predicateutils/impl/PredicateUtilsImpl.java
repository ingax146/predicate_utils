package com.emc.xcelerators.community.bpm.predicateutils.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.documentum.fc.client.DfSingleDocbaseModule;
import com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.EqualConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.GreaterThanConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.GreaterThanEqualConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.LessThanConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.LessThanEqualConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.BooleanAndFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.BooleanNotFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.BooleanOrFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.CompareFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.CompareIgnoreCaseFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.DateAfterFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.DateBeforeFunction;

public class PredicateUtilsImpl extends DfSingleDocbaseModule implements PredicateUtils {

    public String getVersion() {
    	return "1.0";
    }

    public String getVendorString() {
    	return "";
    }
    
	private <T> Boolean[] binaryFunction(BinaryFunction<T> function, final T[] rhs, final T[] lhs) {
		if (rhs == null || lhs == null) {
			throw new RuntimeException("One or both input arrays are null!");
		}
		if (rhs.length != lhs.length) {
			throw new RuntimeException("Input arrays does not have the same number of elements, do not know how to process them.");
		}
		
		List<Boolean> result = new ArrayList<Boolean>(rhs.length);
		for(int ix = 0; ix < rhs.length; ++ix) {
			boolean res = function.apply(rhs[ix], lhs[ix]);
			result.add(new Boolean(res));
		}
		return listToArray(result);
	}

	private <T> Boolean[] unaryFunction(UnaryFunction<T> function, final T[] values) {
		if (values == null) {
			throw new RuntimeException("Input array is null!");
		}
		List<Boolean> result = new ArrayList<Boolean>(values.length);
		for(int ix = 0; ix < values.length; ++ix) {
			boolean res = function.apply(values[ix]);
			result.add(new Boolean(res));
		}
		return listToArray(result);
	}
	
	private Boolean[] listToArray(List<Boolean> result) {
		return result.toArray(new Boolean[result.size()]);
	}
    
	@Override
	public Boolean[] equals(final String[] rhs, final String[] lhs) {
		BinaryFunction<String> fn = new CompareFunction<String>(new EqualConverter());
		return binaryFunction(fn, rhs, lhs);
	}
	
	@Override
	public Boolean[] equalsIgnoreCase(final String[] rhs, final String[] lhs) {
		BinaryFunction<String> cmp = new CompareIgnoreCaseFunction(new EqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] after(Date[] rhs, Date[] lhs) {
		BinaryFunction<Date> cmp = new DateAfterFunction();
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] and(Boolean[] rhs, Boolean[] lhs) {
		BinaryFunction<Boolean> cmp = new BooleanAndFunction();
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] before(Date[] rhs, Date[] lhs) {
		BinaryFunction<Date> cmp = new DateBeforeFunction();
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] equals(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new EqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] equals(Date[] rhs, Date[] lhs) {
		BinaryFunction<Date> cmp = new CompareFunction<Date>(new EqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] greaterThan(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new GreaterThanConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] greaterThanEqual(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new GreaterThanEqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] lessThan(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new LessThanEqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] lessThanEqual(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new LessThanConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	@Override
	public Boolean[] not(Boolean[] values) {
		UnaryFunction<Boolean> cmp = new BooleanNotFunction();
		return unaryFunction(cmp, values);
	}

	@Override
	public Boolean[] or(Boolean[] rhs, Boolean[] lhs) {
		BinaryFunction<Boolean> cmp = new BooleanOrFunction();
		return binaryFunction(cmp, rhs, lhs);
	}
}
