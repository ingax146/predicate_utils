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

/**
 *
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class PredicateUtilsImpl extends DfSingleDocbaseModule implements PredicateUtils {

	/**
	 * This function is implemented to avoid warnings during DAR installation.
	 * @return - xCelerator version number as a string.
	 */
    public String getVersion() {
    	return "1.0";
    }

    /**
     * This function is implemented to avoid warnings during DAR installation.
     * @return - String representing the Vendor.
     */
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
    
	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#equals(java.lang.String[], java.lang.String[])
	 */
	@Override
	public Boolean[] equals(final String[] rhs, final String[] lhs) {
		BinaryFunction<String> fn = new CompareFunction<String>(new EqualConverter());
		return binaryFunction(fn, rhs, lhs);
	}
	
	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#equalsIgnoreCase(java.lang.String[], java.lang.String[])
	 */
	@Override
	public Boolean[] equalsIgnoreCase(final String[] rhs, final String[] lhs) {
		BinaryFunction<String> cmp = new CompareIgnoreCaseFunction(new EqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#after(java.util.Date[], java.util.Date[])
	 */
	@Override
	public Boolean[] after(Date[] rhs, Date[] lhs) {
		BinaryFunction<Date> cmp = new DateAfterFunction();
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#and(java.lang.Boolean[], java.lang.Boolean[])
	 */
	@Override
	public Boolean[] and(Boolean[] rhs, Boolean[] lhs) {
		BinaryFunction<Boolean> cmp = new BooleanAndFunction();
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#before(java.util.Date[], java.util.Date[])
	 */
	@Override
	public Boolean[] before(Date[] rhs, Date[] lhs) {
		BinaryFunction<Date> cmp = new DateBeforeFunction();
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#equals(java.lang.Double[], java.lang.Double[])
	 */
	@Override
	public Boolean[] equals(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new EqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#equals(java.util.Date[], java.util.Date[])
	 */
	@Override
	public Boolean[] equals(Date[] rhs, Date[] lhs) {
		BinaryFunction<Date> cmp = new CompareFunction<Date>(new EqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#greaterThan(java.lang.Double[], java.lang.Double[])
	 */
	@Override
	public Boolean[] greaterThan(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new GreaterThanConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#greaterThanEqual(java.lang.Double[], java.lang.Double[])
	 */
	@Override
	public Boolean[] greaterThanEqual(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new GreaterThanEqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#lessThan(java.lang.Double[], java.lang.Double[])
	 */
	@Override
	public Boolean[] lessThan(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new LessThanEqualConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#lessThanEqual(java.lang.Double[], java.lang.Double[])
	 */
	@Override
	public Boolean[] lessThanEqual(Double[] rhs, Double[] lhs) {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new LessThanConverter());
		return binaryFunction(cmp, rhs, lhs);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#not(java.lang.Boolean[])
	 */
	@Override
	public Boolean[] not(Boolean[] values) {
		UnaryFunction<Boolean> cmp = new BooleanNotFunction();
		return unaryFunction(cmp, values);
	}

	/**
	 * @see com.emc.xcelerators.community.bpm.predicateutils.PredicateUtils#or(java.lang.Boolean[], java.lang.Boolean[])
	 */
	@Override
	public Boolean[] or(Boolean[] rhs, Boolean[] lhs) {
		BinaryFunction<Boolean> cmp = new BooleanOrFunction();
		return binaryFunction(cmp, rhs, lhs);
	}
}
