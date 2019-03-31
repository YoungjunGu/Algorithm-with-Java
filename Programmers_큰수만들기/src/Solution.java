import java.util.*;

public class Solution {

	public String solution(String number, int k) {
		int cnt = k;
		char[] result = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < number.length(); i++) {
			char curChar = number.charAt(i);
			while (!stack.isEmpty() && curChar > stack.peek() && cnt-- > 0) {
				stack.pop();
			}
			stack.push(curChar);
		}

		for (int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}

		return new String(result);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String number = "1924";
		int k = 2;

		new Solution().solution(number, k);

	}

}
