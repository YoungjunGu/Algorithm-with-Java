public class Solution {
	static int N;
	static final int MAX = 1000000007;
	static int[] dp;
	static int answer;
	
	public static int solution(int n) {
		
		N = n;
		dp = new int[N + 1];
		
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 3;
		for(int i = 3; i < N+1; i++) {
			if(i%2 == 1)
				continue;
			dp[i] = 3 * dp[i-2];
			for(int j = (i - 4); j >= 0; j -= 2)
				dp[i] += (2 * dp[j]);
			dp[i] %= MAX;
		}
		answer = dp[dp.length - 1];
		return answer;
	}

}
