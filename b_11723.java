package baekjoon_BruteForceSearch0;

import java.util.Scanner;

public class b_11723 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		int bitSet = 0;
		StringBuilder ans = new StringBuilder();
		
		for (int i = 0; i < t; i++) {			
			String input = sc.next();
			
			if(input.equals("add")) {
				int x = sc.nextInt();
				bitSet = bitSet|(1 << x);
			} else if(input.equals("check")) {
				int x= sc.nextInt();
				int result = bitSet & (1 << x);
				if(result != 0) {
					ans.append(1);
					ans.append("\n");
				} else {
					ans.append(0);
					ans.append("\n");
				}
			} else if(input.equals("remove")) {
				int x = sc.nextInt();
				bitSet = bitSet & ~(1<< x);
			} else if(input.equals("toggle")) {
				int x = sc.nextInt();
				bitSet = bitSet ^ (1 << x);
			} else if(input.equals("all")) {
				bitSet = (1 << 21) - 1;
			} else if(input.equals("empty")){
				bitSet = 0;
			}	

		}
		System.out.println(ans);
	}
}
