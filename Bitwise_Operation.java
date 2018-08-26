package baekjoon_BruteForceSearch0;

public class Bitwise_Operation {
	// 비트 연산에는 shift left(<<)와 shift right(>>)가 있다.
	// A>>B(A를 오른쪽으로 B비트만틈 민다.)

	public static void main(String[] args) {
		System.out.println(1 >> 0);
		System.out.println(1 >> 1); // 0(2)
		System.out.println(10 >> 1); // 101(2)
		System.out.println(10 >> 2); // 10(2)
		System.out.println(10 >> 3); // 1(2)
		System.out.println(30 >> 1); // 1111(2)
		System.out.println(1024 >> 10); // 1(2)

	}

}
