import java.util.*;

public class Solution {

	static ArrayList<Integer> list = new ArrayList<>();

	public int solution(String numbers) {
		int[] div = { 2, 3, 5, 7 };
		int answer = 0;

		bruteForce("", numbers);

		HashSet<Integer> list2 = new HashSet<Integer>(list);

		ArrayList<Integer> list3 = new ArrayList<Integer>(list2);

		for (int i = 0; i < list3.size(); i++) {
			boolean check = true;
			int num = list3.get(i);
			if(num == 1 || num == 0)
			{
				check = false;
			}
			else {
				for (int j = 2; j < list3.get(i); j++) {

					if(num % j == 0) {
						check = false;
					}		
				}
			}

			// false 면 소수가 아니다.
			if (check) {
				System.out.println(list3.get(i));
				answer++;
			}

		}

		System.out.println(answer);
		return answer;
	}

	public void bruteForce(String s, String number) {
		// 더이상 조사할 문자열이 없으면 문자열 삽
		if (number.length() == 0) {
			if (!s.equals(""))
				list.add(Integer.parseInt(s));
		} else {
			for (int i = 0; i < number.length(); i++) {
				bruteForce(s + number.charAt(i), number.substring(0, i) + number.substring(i + 1, number.length()));
			}
			for (int i = 0; i < number.length(); i++) {
				bruteForce(s, number.substring(0, i) + number.substring(i + 1, number.length()));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String numbers = "011";
		new Solution().solution(numbers);
	}

}
