package com.emc.xcelerators.community.bpm.predicateutils.tests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.DateAfterFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.DateBeforeFunction;


/**
 * @author Ingemar Axelsson <ingemar.axelsson@emc.com>
 *
 */
public class DateComparatorTests {

	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test0() {
		Date before = new Date(3600*1000*24);
		Date after = Calendar.getInstance().getTime();
		BinaryFunction<Date> cmp = new DateAfterFunction();

		assertEquals(false, cmp.apply(before, after));
		assertEquals(true, cmp.apply(after, before));
		assertEquals(false, cmp.apply(before, before));
	}
	
	/**
	 *
	 */
	@SuppressWarnings("boxing")
	@Test
	public void test1() {
		Date before = new Date(3600*1000*24);
		Date after = Calendar.getInstance().getTime();
		BinaryFunction<Date> cmp = new DateBeforeFunction();

		assertEquals(true, cmp.apply(before, after));
		assertEquals(false, cmp.apply(after, before));
		assertEquals(false, cmp.apply(before, before));
	}
}
