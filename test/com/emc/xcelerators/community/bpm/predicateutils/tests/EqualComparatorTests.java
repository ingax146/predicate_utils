package com.emc.xcelerators.community.bpm.predicateutils.tests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.converters.EqualConverter;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.CompareFunction;


/**
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class EqualComparatorTests {

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test0() {
		BinaryFunction<String> cmp = new CompareFunction<String>(new EqualConverter());
		assertEquals(true, cmp.apply("", ""));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test1() {
		BinaryFunction<String> cmp = new CompareFunction<String>(new EqualConverter());
		assertEquals(false, cmp.apply("a", ""));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test1a() {
		BinaryFunction<String> cmp = new CompareFunction<String>(new EqualConverter());
		assertEquals(false, cmp.apply("", "a"));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test1b() {
		BinaryFunction<String> cmp = new CompareFunction<String>(new EqualConverter());
		assertEquals(true, cmp.apply("a", "a"));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test2() {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new EqualConverter());
		assertEquals(true, cmp.apply(new Double(0.0), new Double(0.0)));
	}


	/**
	 * See Java reference on Double.compareTo() for more details why -0.0 < 0.0.
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test3() {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new EqualConverter());
		assertEquals(false, cmp.apply(new Double(-0.0), new Double(0.0)));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test4() {
		BinaryFunction<Double> cmp = new CompareFunction<Double>(new EqualConverter());
		assertEquals(false, cmp.apply(new Double(-1.0), new Double(-1.00000000000001)));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test5() {
		Date now = new Date();
		BinaryFunction<Date> cmp = new CompareFunction<Date>(new EqualConverter());
		assertEquals(true, cmp.apply(now, now));
	}

	/**
	 * @throws InterruptedException 
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test6() throws InterruptedException {
		Date now = new Date();
		Thread.sleep(1);
		Date anotherDate = Calendar.getInstance().getTime();
		BinaryFunction<Date> cmp = new CompareFunction<Date>(new EqualConverter());
		assertEquals(false, cmp.apply(now, anotherDate));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test7() {
		BinaryFunction<Boolean> cmp = new CompareFunction<Boolean>(new EqualConverter());
		assertEquals(true, cmp.apply(new Boolean(true), Boolean.TRUE));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test8() {
		BinaryFunction<Boolean> cmp = new CompareFunction<Boolean>(new EqualConverter());
		assertEquals(false, cmp.apply(new Boolean(false), Boolean.TRUE));
	}

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test9() {
		BinaryFunction<Boolean> cmp = new CompareFunction<Boolean>(new EqualConverter());
		assertEquals(false, cmp.apply(new Boolean(true), Boolean.FALSE));
	}
}
