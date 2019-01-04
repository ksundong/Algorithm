package compareTheTriplets;

/**
 * 배열 a(a[0], a[1], a[2])와 배열 b(b[0], b[1], b[2])가 있을 때,
 * Alice는 배열 a, Bob은 배열 b를 소유하고 있을 경우,
 * 각 배열의 요소를 비교하여
 *  - 배열 a의 요소가 배열 b의 요소보다 클 경우 Alice의 포인트가 1 오르고,
 *  - 배열 b의 요소가 배열 a의 요소보다 클 경우 Bob의 포인트가 1 오르고,
 *  - 배열 a의 요소와 배열 b의 요소가 서로 동일할 경우 둘 다 포인트가 오르지 않는다.
 * 라는 규칙을 적용한다.
 * 그리고 점수는 배열에 담아 반환한다. 이를테면, [Alice, Bob]순으로 숫자를 입력한다.
 * 입력 형식은 첫 줄에 띄어쓰기로 구분된 세 숫자를 입력받고, A배열에 순서대로 넣는다.
 * 둘째 줄에 띄어쓰기로 구분된 세 숫자를 입력받아 B배열에 순서대로 넣는다.
 * 제약조건은 둘의 요소는 1이상 100이하인 숫자이다.
 * 반환 형식은 Alice의 포인트를 먼저 입력하고 그 다음에 Bob의 포인트를 입력한 배열로 반환한다.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<>();
		int AlicePoint = 0;
		int BobPoint = 0;

		for (int i = 0; i < 3; i++) {
			int aSource = a.get(i);
			int bSource = b.get(i);

			if (aSource < 1 || aSource > 100 || bSource < 1 || bSource > 100) {
				throw new IndexOutOfBoundsException("숫자 범위 초과");
			} else {
				if (aSource > bSource) {
					AlicePoint++;
				} else if (bSource > aSource) {
					BobPoint++;
				}
			}
		}
		result.add(AlicePoint);
		result.add(BobPoint);

		return result;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){

		List<Integer> a = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> b = Stream.of(scanner.nextLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> result = compareTriplets(a, b);

		for (int i = 0, resultCnt = result.size(); i < resultCnt; i++) {
			System.out.print(result.get(i) + " ");
		}
	}
}
