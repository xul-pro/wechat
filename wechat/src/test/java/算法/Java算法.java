package 算法;
import org.junit.Test;

public class Java算法 {
	
	public static void main(String[] args) {
		//一个仓库  11.8m*4.6m*2.3m 这是仓库的体积，需要往仓库里面放邮政的若干箱子（箱子类型一定，有三种）计算如何摆放箱子才能做到最大空间利用率？
		//箱子1:530mm*290mm*370mm
		//箱子2:530mm*230mm*290mm
		//箱子3:430mm*210mm*270mm
		double v = 124.844;
		
		double v1 = 0.056869; //2195
		double v2 = 0.035351; //3531
		double v3 = 0.024381; //5120
		
		for (int i = 0; i <= 2195; i++) {
			for (int j = 0; j <= 3531; j++) {
				for (int j2 = 0; j2 <= 5120; j2++) {
					if(v == v1 * i +v2 * j + v3 * j2)
					System.out.println("x="+i+",y="+j+",z="+j2);
				}
			}
		}
	}
	
	@Test
	public void testCal() {
//		System.out.println(11.8*4.6*2.3);
//		System.out.println(0.530*0.290*0.370);
//		System.out.println(0.530*0.230*0.29);
//		System.out.println(0.430*0.210*0.270);
		System.out.println(2*0.056869+342*0.035351+4620*0.024381);
	}
}











