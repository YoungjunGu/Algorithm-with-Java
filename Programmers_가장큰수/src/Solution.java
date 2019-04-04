import java.util.*;

public class Solution {

	public String solution(int[] numbers) {
		String answer = "";
		String[] stringNums = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			stringNums[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(stringNums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				int s1 = Integer.parseInt(o1 + o2);
				int s2 = Integer.parseInt(o2 + o1);
				return s1 < s2 ? 1:-1;
			}
		});

		// 맨 앞이 0 이면 0을 붙인다.
		if (stringNums[0].equals("0"))
			answer += "0";
		else
		{
	        for(int i = 0 ; i < stringNums.length; i++) {
	        	answer += stringNums[i];
	        }
		}

			return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {6, 10, 2};
		
		System.out.println(new Solution().solution(nums));

	}

}
