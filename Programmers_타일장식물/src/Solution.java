import java.util.*;

public class Solution {
	
    public long solution(int N) {
        long answer = 0;
        long[] dp = new long[81];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= N ; i++) {
        	dp[i] = dp[i-1] + dp[i -2];
        }
        
        answer = dp[N]*2 + dp[N-1]*2;
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution(6));
	}

}
