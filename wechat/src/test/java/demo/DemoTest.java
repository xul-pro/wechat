package demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;


/**
 * 普通基础工具类演示
 * 
 * @author AzZ、xul
 * @Data 2017-9-21
 */
public class DemoTest {
	
	@Test
	public void demoOne() {
		UUID randomUUID = UUID.randomUUID();
		System.out.println(randomUUID.toString());
		Object o = new Object();
		String s = new String();
		Integer i = new Integer(1);
	}
	
	@Test
	public void demoTwo() {
		long start1 = System.currentTimeMillis();
		List<String> arr1 = new LinkedList<>();
		arr1.add("我");
		arr1.add("是");
		arr1.add("中");
		arr1.add("国");
		arr1.add("人");
		arr1.add("民");
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.print(arr1.get(i));
		}
		long end1 = System.currentTimeMillis();
		System.err.println("LinkedList耗时：" + (end1 - start1));
		
		System.out.println("***********************************");
		
		long start2 = System.currentTimeMillis();
		List<String> arr2 = new ArrayList<>();
		arr2.add("我");
		arr2.add("是");
		arr2.add("中");
		arr2.add("国");
		arr2.add("人");
		arr2.add("民");
		for (int i = 0; i < arr2.size(); i++) {
			System.out.print(arr2.get(i));
		}
		long end2 = System.currentTimeMillis();
		System.err.println("ArrayList耗时：" + (end2 - start2));
	}
}
