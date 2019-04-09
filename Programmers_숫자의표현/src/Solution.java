import java.util.*;

class Solution {
	
	public int solution(int n) {
		int answer = 0;
		
		for(int i = 1; i <= n ; i++) {
			int cur = i;
			int sum = 0;
			while(sum < n) {
				sum += cur++;
				if(sum == n) {
					answer++;
					break;
				}
			}
		}
		
		//System.out.print(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().solution(15);
	}

}
