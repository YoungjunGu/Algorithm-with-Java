import java.util.*;

public class Solution {

    public int solution(int [][]board){
        int answer = 0;
        int[][] dp = new int[1001][1001];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0 ;i < board.length; i++) {
        	for(int j = 0 ; j < board[i].length; j++) {
        		dp[i][j] = board[i][j];
        	}
        }
       
        for(int i = 1 ;i < board.length; i++) {
        	for(int j = 1 ; j < board[i].length; j++) {
        		if(dp[i][j] == 1) {
        			dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        
        answer = (int) Math.pow(max, 2);
        System.out.println(answer);
        
        return answer;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int[][] board = {{1,1,1,1}};
		new Solution().solution(board);
	}

}
