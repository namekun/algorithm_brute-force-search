package baekjoon_BruteForceSearch0;

import java.util.Scanner;

public class b_10973 {
	public static boolean prev_permutation(int[] a) {
		
		
		int n = a.length;
		int i = n - 1;
		while (i > 0 && a[i - 1] <= a[i]) {
			i -= 1;
		}

		// 마지막 순열
		if (i <= 0) {
			return false;
		}

		// a[j] > a[i-1]을 만족하는 가장 큰 j 를 찾는다. 뒤에서부터
		int j = n - 1;
		while (a[j] >= a[i - 1]) {
			j -= 1;
		}
		
		// a[i-1]과 a[j]를 바꾼다.
		int temp = a[i - 1];
		a[i - 1] = a[j];
		a[j] = temp;

		j = n - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i += 1;
			j -= 1;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] x = new int[a];

		for (int i = 0; i < a; i++) {
			x[i] = sc.nextInt();
		}
		
	     if (prev_permutation(x)) {
	            for (int i=0; i< a; i++) {
	                System.out.print(x[i] + " ");
	            }
	            System.out.println();
	        } else {
	            System.out.println("-1");
	        }
	}
}
