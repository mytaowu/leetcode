package 队列;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo2 {
	public static void main(String[] args) {
		
		int a[] = {1,2,3,4,5};
		f(a);
		Arrays.stream(a).forEach(System.out::println);
	}


	private static void f(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[0]++;
		}
	}

}
