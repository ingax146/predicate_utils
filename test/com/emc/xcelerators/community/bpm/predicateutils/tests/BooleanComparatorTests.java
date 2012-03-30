package com.emc.xcelerators.community.bpm.predicateutils.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.emc.xcelerators.community.bpm.predicateutils.impl.BinaryFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.UnaryFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.BooleanAndFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.BooleanNotFunction;
import com.emc.xcelerators.community.bpm.predicateutils.impl.functions.BooleanOrFunction;


public class BooleanComparatorTests {
	
	@Test
	public void test0() {
		BinaryFunction<Boolean> cmp = new BooleanOrFunction();
		assertEquals(true, cmp.apply(Boolean.TRUE, Boolean.FALSE));
		assertEquals(true, cmp.apply(Boolean.TRUE, Boolean.TRUE));
		assertEquals(true, cmp.apply(Boolean.FALSE, Boolean.TRUE));
		assertEquals(false, cmp.apply(Boolean.FALSE, Boolean.FALSE));
	}
	
	@Test
	public void test1() {
		BinaryFunction<Boolean> cmp = new BooleanAndFunction();
		assertEquals(false, cmp.apply(Boolean.TRUE, Boolean.FALSE));
		assertEquals(true, cmp.apply(Boolean.TRUE, Boolean.TRUE));
		assertEquals(false, cmp.apply(Boolean.FALSE, Boolean.TRUE));
		assertEquals(false, cmp.apply(Boolean.FALSE, Boolean.FALSE));
	}
	
	@Test
	public void test2() {
		UnaryFunction<Boolean> cmp = new BooleanNotFunction();
		assertEquals(false, cmp.apply(Boolean.TRUE));
		assertEquals(true, cmp.apply(Boolean.FALSE));
	}
}
