# 백준 완전탐색 -0


## 비트 연산

* 비트 연산을 사용해서 부분 집합을 표현할 수 있다.
* 연산에는 &(and), |(or). ~(not), ^(xor)
* &은 둘다 true일때만 true
* |은 둘다 False or True 일때만 True
* ^는 두개의 값이 서로 다를 때만 True
* 두 수 A와 B를 비트 연산하는 경우에는 가장 뒤의 자리에서 하나씩 연산을 수행하면 된다.
* not 연산의 경우에는 자료형에 따라 결과가 달라진다.
* A = 83 = 10101100(2)
* ~A = 101011100(2) ( 8비트 자료형인 경우 - char)
* ~A = 11111111 11111111 11111111 10101100(2) (32비트 자료형인 경우)
* 또, unsigned, signed에 따라서 보여지는 값은 다르다.

*Bitwise_operation.java*

```java
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
```

* A << B 는 A X 2^B와 같다.

* A >> B 는 A/2^B와 같다.

* (A + B) / 2 는 (A + B) >> 1로 쓸 수 있다.

* 어떤 수가 홀수 인지 판별하는 if(N%2 == 1)은 if(N&1)로 줄여 쓸 수 있다.

* 즉, 이렇게 볼 수 있다.

  | n    | 1<<n     | dec  |
  | ---- | -------- | ---- |
  | 0    | 00000001 | 1    |
  | 1    | 00000010 | 2    |
  | 2    | 00000100 | 4    |
  | 3    | 00001000 | 8    |
  | 4    | 00010000 | 16   |
  | 5    | 00100000 | 32   |
  | 6    | 01000000 | 64   |
  | 7    | 10000000 | 128  |

* 이해를 돕기 위해 배열로 표현해보자.

  idx[8]={1,2,4,8,16,32,64,128}; 이 된다.

  idx[n]==(1<<n) 이다. 연산자 우선순위에 유의한다.

* 연산자 우선 순위 ( 출처 : [위키피디아](https://ko.wikipedia.org/wiki/C%EC%99%80_C%2B%2B%EC%9D%98_%EC%97%B0%EC%82%B0%EC%9E%90#.EC.97.B0.EC.82.B0.EC.9E.90_.EC.9A.B0.EC.84.A0.EC.88.9C.EC.9C.84))

|       우선순위       |                            연산자                            |                             설명                             |    결합법칙     |
| :------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :-------------: |
|          1           |                             `::`                             |                      범위 확인 (C++만)                       | 왼쪽에서 오른쪽 |
|          2           |                             `++`                             |                          후위 증가                           |                 |
|         `--`         |                          후위 감소                           |                                                              |                 |
|         `()`         |                          함수 호출                           |                                                              |                 |
|         `[]`         |                          배열 첨자                           |                                                              |                 |
|         `.`          |                    참조에 의한 요소 선택                     |                                                              |                 |
|         `->`         |                   포인터를 통해 요소 선택                    |                                                              |                 |
|      `typeid()`      | [런타임 형식 정보](https://ko.wikipedia.org/w/index.php?title=%EB%9F%B0%ED%83%80%EC%9E%84_%ED%98%95%EC%8B%9D_%EC%A0%95%EB%B3%B4&action=edit&redlink=1) (C++만) ([typeid](https://ko.wikipedia.org/w/index.php?title=Typeid&action=edit&redlink=1) 참조) |                                                              |                 |
|     `const_cast`     | 자료형 캐스트 (C++만) ([const cast](https://ko.wikipedia.org/w/index.php?title=Const_cast&action=edit&redlink=1) 참조) |                                                              |                 |
|    `dynamic_cast`    | 자료형 캐스트 (C++만) ([dynamic cast](https://ko.wikipedia.org/w/index.php?title=Dynamic_cast&action=edit&redlink=1) 참조) |                                                              |                 |
|  `reinterpret_cast`  | 자료형 캐스트 (C++만) ([reinterpret cast](https://ko.wikipedia.org/w/index.php?title=Reinterpret_cast&action=edit&redlink=1) 참조) |                                                              |                 |
|    `static_cast`     | 자료형 캐스트 (C++만) ([static cast](https://ko.wikipedia.org/w/index.php?title=Static_cast&action=edit&redlink=1) 참고) |                                                              |                 |
|          3           |                             `++`                             |                          전위 증가                           | 오른쪽에서 왼쪽 |
|         `--`         |                          전위 감소                           |                                                              |                 |
|         `+`          |                          단항 덧셈                           |                                                              |                 |
|         `-`          |                          단항 뺄셈                           |                                                              |                 |
|         `!`          |                          논리적 NOT                          |                                                              |                 |
|         `~`          |                           비트 NOT                           |                                                              |                 |
|     `(*자료형*)`     |                        자료형 캐스트                         |                                                              |                 |
|         `*`          |                        우회 (역참조)                         |                                                              |                 |
|         `&`          |                           의-주소                            |                                                              |                 |
|       `sizeof`       | [의-크기](https://ko.wikipedia.org/w/index.php?title=Sizeof&action=edit&redlink=1) |                                                              |                 |
|    `new`, `new[]`    |                   동적 메모리 할당 (C++만)                   |                                                              |                 |
| `delete`, `delete[]` |                 동적 메모리 할당해제 (C++만)                 |                                                              |                 |
|          4           |                             `.*`                             |                   멤버접근 포인터 (C++만)                    | 왼쪽에서 오른쪽 |
|        `->*`         |                   멤버접근 포인터 (C++만)                    |                                                              |                 |
|          5           |                             `*`                              |                             곱셈                             |                 |
|         `/`          |                            나눗셈                            |                                                              |                 |
|         `%`          | [계수](https://ko.wikipedia.org/wiki/%EB%AA%A8%EB%93%88%EB%9F%AC_%EC%97%B0%EC%82%B0) (나머지) |                                                              |                 |
|          6           |                             `+`                              |                             덧셈                             |                 |
|         `-`          |                             뺄셈                             |                                                              |                 |
|          7           |                             `<<`                             | [비트](https://ko.wikipedia.org/wiki/%EB%B9%84%ED%8A%B8_%EC%97%B0%EC%82%B0) 왼쪽 시프트 |                 |
|         `>>`         | [비트](https://ko.wikipedia.org/wiki/%EB%B9%84%ED%8A%B8_%EC%97%B0%EC%82%B0) 오른쪽 시프트 |                                                              |                 |
|          8           |                             `<`                              | [관계적 연산자들](https://ko.wikipedia.org/wiki/%EA%B4%80%EA%B3%84%ED%98%95_%EC%97%B0%EC%82%B0%EC%9E%90)에 대해 < 각각의 |                 |
|         `<=`         |               관계적 연산자들에 대해 ≤ 각각의                |                                                              |                 |
|         `>`          |               관계적 연산자들에 대해 > 각각의                |                                                              |                 |
|         `>=`         |               관계적 연산자들에 대해 ≥ 각각의                |                                                              |                 |
|          9           |                             `==`                             | [관계적 =](https://ko.wikipedia.org/wiki/%EA%B4%80%EA%B3%84%ED%98%95_%EC%97%B0%EC%82%B0%EC%9E%90#%EB%8C%80%EB%93%B1) 각각의 |                 |
|         `!=`         |                       관계적 ≠ 각각의                        |                                                              |                 |
|          10          |                             `&`                              |                           비트 AND                           |                 |
|          11          |                             `^`                              |                     비트 XOR (배타적 or)                     |                 |
|          12          |                             `|`                              |                     비트 OR (포함적 or)                      |                 |
|          13          |                             `&&`                             |                           논리 AND                           |                 |
|          14          |                             `||`                             |                           논리 OR                            |                 |
|          15          |                             `?:`                             | [3항 연산자](https://ko.wikipedia.org/w/index.php?title=3%ED%95%AD_%EC%97%B0%EC%82%B0%EC%9E%90&action=edit&redlink=1) 조건부 ([?:](https://ko.wikipedia.org/wiki/%3F:) 참조) | 오른쪽에서 왼쪽 |
|          16          |                             `=`                              | 직접 할당 [(C++ 클래스를 위해 기본적으로 제공됨)](https://ko.wikipedia.org/w/index.php?title=C%2B%2B%EC%97%90%EC%84%9C_%ED%95%A0%EB%8B%B9_%EC%97%B0%EC%82%B0%EC%9E%90&action=edit&redlink=1) |                 |
|         `+=`         |                       덧셈에 의한 할당                       |                                                              |                 |
|         `-=`         |                       뺄셈에 의한 할당                       |                                                              |                 |
|         `*=`         |                       곱셈에 의한 할당                       |                                                              |                 |
|         `/=`         |                      나눗셈에 의한 할당                      |                                                              |                 |
|         `%=`         |                      나머지에 의한 할당                      |                                                              |                 |
|        `<<=`         |                 비트 왼쪽 시프트에 의한 할당                 |                                                              |                 |
|        `>>=`         |                비트 오른쪽 시프트에 의한 할당                |                                                              |                 |
|         `&=`         |                     비트 AND에 의한 할당                     |                                                              |                 |
|         `^=`         |                     비트 XOR에 의한 할당                     |                                                              |                 |
|         `|=`         |                     비트 OR에 의한 할당                      |                                                              |                 |
|          17          |                           `throw`                            |              던지기 연산자 (던지기 예외, C++만)              |                 |
|          18          |                             `,`                              | [쉼표](https://ko.wikipedia.org/w/index.php?title=%EC%89%BC%ED%91%9C_%EC%97%B0%EC%82%B0%EC%9E%90&action=edit&redlink=1) | 왼쪽에서 오른쪽 |

## 비트마스크

* 정수로 집합을 나타낼 수 있다.
* 현재 집합이 S 일때
  * i를 추가
    * S | (1 << i)
  * i를 검사
    * S & (1 << i)
  * i를 제거
    * S & ~(1 << i)
  * i를 토글 (0을 1로, 1을 0으로)
    * S ^ (1 << i)
* 전체 집합
  * (1 << N) - 1 
  * N개 만든다.
* 공집합 
  * 0

## 비트 마스크 연습

### 문제

비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.

- `add x`: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
- `remove x`: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
- `check x`: S에 x가 있으면 1을, 없으면 0을 출력한다.
- `toggle x`: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
- `all`: S를 {1, 2, ..., 20} 으로 바꾼다.
- `empty`: S를 공집합으로 바꾼다. 

*b_11723.java*

```java
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
```

* 물론 배열을 사용하는 것이 더욱 편리하지만, 비트마스크를 사용하는 이유는 

  집합을 배열의 인덱스로 표현할 수 있기 때문이다.

* 상태 다이나믹을 자주 사용하게 된다.

## 순열(premutation)

* 1~N 까지로 이루어진 수열
* 수의 중복을 허락하지 않고 n개를 일렬로 나열하는 수
* 크기는 항상 N이 되어야하고, 겹치는 숫자가 존재하지 않는다.
* 크기가 N인 순열은 총 N!개 존재한다.

## 다음 순열 (Next Permutation)

* 순열을 사전순으로 나열했을 때, 사전순으로 다음에 오는 순열과 이전에 오는 순열을 찾는 방법

  1. A[i-1] < A[i]를 만족하는 가장 큰 i를 찾는다.
  2. j >= i 이면서 A[j] > A[i-1] 를 만족하는 가장 큰 j를 찾는다.
  3. A[i-1] 과 A[j] 를 Swap한다.
  4. A[i] 부터 순열을 뒤집는다.

  *NextPermutation.java*

  ```java
  boolean nextPermutation(int *a, int n){
      int i = n-1;
      while (i>0 && a[i-1] >= a[i]) i -= 1;
      if (i <= 0) return false; // 마지막 순열
      int j = n-1;
      while(a[j] <= a[i-1]) j -= 1;
      temp = a[i-1];  
      a[i-1] = a[i];  
    	a[i] = temp;    
      j = n-1;
      while(i<j){
          temp = a[i];
      	a[i] = a[j];  
    		a[j] = temp;    
      	i += 1;
          j -= 1;
      }
      return true;
  }
  ```



## Baekjoon Q_10972

### 문제

1부터 N까지의 수로 이루어진 순열이 있다. 이 때, 사전순으로 다음에 오는 순열을 구하는 프로그램을 작성하시오.

사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.

N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.

- 1, 2, 3
- 1, 3, 2
- 2, 1, 3
- 2, 3, 1
- 3, 1, 2
- 3, 2, 1

### 입력

첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.

### 출력

첫째 줄에 입력으로 주어진 순열의 다음에 오는 순열을 출력한다. 만약, 사전순으로 마지막에 오는 순열인 경우에는 -1을 출력한다.

## 풀기전 전략

* a[i -1] < a[i]인 i중에 가장 큰 i를 찾는다.
* 뒤에서부터 a[i -1] > a[j]인 j를 찾는다.
* a[i-1]과 a[j]를 바꿔준다.
* 뒤에서부터 순열을 뒤집어준다.

*b_10792.java*

```java
package baekjoon_BruteForceSearch0;

import java.util.Scanner;

public class b_10972 {
	public static boolean next_permutation(int[] a) {

		int n = a.length;
		int i = n - 1;
		while (i > 0 && a[i - 1] >= a[i]) {
			i -= 1;
		}

		// 마지막 순열
		if (i <= 0) {
			return false;
		}

		int j = n - 1;
		while (a[j] <= a[i - 1]) {
			j -= 1;
		}

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
		
	     if (next_permutation(x)) {
	            for (int i=0; i< a; i++) {
	                System.out.print(x[i] + " ");
	            }
	            System.out.println();
	        } else {
	            System.out.println("-1");
	        }
	}
}
```

## Q_10973 이전 순열 구하기

## 문제

1부터 N까지의 수로 이루어진 순열이 있다. 이 때, 사전순으로 바로 이전에 오는 순열을 구하는 프로그램을 작성하시오.

사전 순으로 가장 앞서는 순열은 오름차순으로 이루어진 순열이고, 가장 마지막에 오는 순열은 내림차순으로 이루어진 순열이다.

N = 3인 경우에 사전순으로 순열을 나열하면 다음과 같다.

- 1, 2, 3
- 1, 3, 2
- 2, 1, 3
- 2, 3, 1
- 3, 1, 2
- 3, 2, 1

## 입력

첫째 줄에 N(1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄에 순열이 주어진다.

## 출력

첫째 줄에 입력으로 주어진 순열의 이전에 오는 순열을 출력한다. 만약, 사전순으로 가장 처음에 오는 순열인 경우에는 -1을 출력한다.

## 풀기전 전략

* a[i -1] > a[i]인 i중에 가장 큰 i를 찾는다.
* 뒤에서부터 a[i -1] < a[j]인 가장 큰 j를 찾는다.
* a[i-1]과 a[j]를 바꿔준다.
* 뒤에서부터 순열을 뒤집어준다.

```java
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
```

## Q_10974 모든 순열

## 문제

N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.

## 입력

첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다. 

## 출력

첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.

*b_10974.java*

```java
package baekjoon_BruteForceSearch0;

import java.util.Scanner;

public class b_10974 {
	public static boolean all_permutation(int[] a) {

		int n = a.length;
		int i = n - 1;
		// a[i-1] < a[i]인 i를 찾는다.
		while (i > 0 && a[i - 1] >= a[i]) {
			i -= 1;
		}

		// 마지막 순열
		if (i <= 0) {
			return false;
		}

		int j = n - 1;

		while (a[j] <= a[i - 1]) {
			j -= 1;
		}

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

	// 런타임 에러가 뜹니다.
	// public static int Factorial(int a) {
	// if(a <= 1) {
	// return a;
	// } else
	// return Factorial(a-1) * a;
	// }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] x = new int[a];
		for (int i = 0; i < x.length; i++) {
			x[i] = i + 1;
		}

		do {
			for (int i = 0; i < a; i++) {
				System.out.print(x[i] + " ");
			}
			System.out.println();
		} while (all_permutation(x));

	}
}
```

## Q_1722 순열의 순서

## 문제

1부터 N까지의 수를 임의로 배열한 순열은 총 N! = N×(N-1)×…×2×1 가지가 있다.

임의의 순열은 정렬을 할 수 있다. 예를 들어  N=3인 경우 {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}의 순서로 생각할 수 있다. 첫 번째 수가 작은 것이 순서상에서 앞서며, 첫 번째 수가 같으면 두 번째 수가 작은 것이, 두 번째 수도 같으면 세 번째 수가 작은 것이….

N이 주어지면, 아래의 두 소문제 중에 하나를 풀어야 한다. k가 주어지면 k번째 순열을 구하고, 임의의 순열이 주어지면 이 순열이 몇 번째 순열인지를 출력하는 프로그램을 작성하시오.

## 입력

첫째 줄에 N(1≤N≤20)이 주어진다. 둘째 줄의 첫 번째 수는 소문제 번호이다. 1인 경우 k(1≤k≤N!)를 입력받고, 2인 경우 임의의 순열을 나타내는 N개의 수를 입력받는다. N개의 수에는 1부터 N까지의 정수가 한 번씩만 나타난다.

## 출력

k번째 수열을 나타내는 N개의 수를 출력하거나, 몇 번째 수열인지를 출력하면 된다.

## 풀이전 해설?

* 특정 순열이 주어지고, 몇번째인지 구하는 것은 다음 규칙을 이용하도록 한다.

* 크기가 N인 순열은 총 N!개.

  만약 N이 6이고, 알고싶은 순열이 3~이라면 , 1~ -> 5!개, 2~ -> 5!개

  2 * 5!개를 더하는 것으로 시작한다.

# 이건 진짜 모르겠다...

