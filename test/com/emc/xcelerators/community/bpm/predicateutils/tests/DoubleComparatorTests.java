package com.emc.xcelerators.community.bpm.predicateutils.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.GreaterThanConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.GreaterThanEqualConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.LessThanConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.LessThanEqualConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.CompareFunction;


/**
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class DoubleComparatorTests {

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test0() {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new LessThanConverter());
		assertEquals(true, cmp.apply(new Double(0.0), new Double(1.0)));
		assertEquals(false, cmp.apply(new Double(1.0), new Double(0.0)));
		assertEquals(true, cmp.apply(new Double(-1.0), new Double(0.0)));
		assertEquals(true, cmp.apply(new Double(-0.0), new Double(1.0)));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test1() {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new LessThanEqualConverter());
		assertEquals(true, cmp.apply(new Double(0.0), new Double(1.0)));
		assertEquals(false, cmp.apply(new Double(1.0), new Double(0.0)));
		assertEquals(true, cmp.apply(new Double(-1.0), new Double(0.0)));
		assertEquals(true, cmp.apply(new Double(-0.0), new Double(1.0)));
		assertEquals(true, cmp.apply(new Double(0.0), new Double(0.0)));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test2() {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new GreaterThanConverter());
		assertEquals(false, cmp.apply(new Double(0.0), new Double(1.0)));
		assertEquals(true, cmp.apply(new Double(1.0), new Double(0.0)));
		assertEquals(false, cmp.apply(new Double(-1.0), new Double(0.0)));
		assertEquals(false, cmp.apply(new Double(-0.0), new Double(1.0)));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test3() {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new GreaterThanEqualConverter());
		assertEquals(false, cmp.apply(new Double(0.0), new Double(1.0)));
		assertEquals(true, cmp.apply(new Double(1.0), new Double(0.0)));
		assertEquals(false, cmp.apply(new Double(-1.0), new Double(0.0)));
		assertEquals(false, cmp.apply(new Double(-0.0), new Double(1.0)));
		assertEquals(true, cmp.apply(new Double(0.0), new Double(0.0)));
	}
}
