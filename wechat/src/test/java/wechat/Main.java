package wechat;

import org.junit.Test;

public class Main {
	
	public static void main(String[] args) {
//		String [] a = new String[10];
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
//		int [] b = new int[10];
//		for (int i = 0; i < b.length; i++) {
//			System.out.println(b[i]);
//		}
//		System.out.println(a.length+b.length);
		A a1 = new A();
		A a2 = new A();
		System.out.println(a1.hashCode() );
		System.out.println(a2.hashCode() );
		System.out.println("请问是true还是false:"+a1.equals(a2));
	}
	
	@Test
	public void testFor() {
		one:for (int i = 0; i < 5; i++) {
			two:for (int j = 0; j < 5; j++) {
				if(j==2) {
					System.out.println(j);
					break one;
				}
				if(j == 3) {
					System.out.println(j);
					break two;
				}
			}
		}
	}
	
	@Test
	public void sowp() {
		int a =2;
		int b =10;
		a = a<<b;
		b=b<<a;
		System.out.println("a="+a+",b="+b);
	}
	
}


class A {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

