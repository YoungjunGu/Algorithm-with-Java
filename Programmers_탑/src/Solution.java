import java.util.*;

public class Solution {

	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		Arrays.fill(answer, 0);
		
		for(int i = heights.length - 1; i >=0; i--) {
			for(int j = i - 1; j >=0; j--) {

				if(heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
					
			}
		}
		
		for(int i = 0 ; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] heights = {6,9,5,7,4};
		
		new Solution().solution(heights);
	}

}
