package com.hoyatod.数据结构;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Collections {
	
	@Test
	public void maxOrMinByList() {
		List<Integer> arrs = Arrays.asList(45,15,156,596,589,87,12,2,9);
		Integer max = java.util.Collections.max(arrs);
		System.out.println(max);
	}
	
	@Test
	public void testList() {
		List<Integer> asList = Arrays.asList(1,56,98,58,48,2,14,25);
	}
}
