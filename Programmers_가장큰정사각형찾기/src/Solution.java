import java.util.*;

public class Solution {

    public int solution(int [][]board){
        int answer = 0;
        int[][] dp = new int[10002][10002];
        int max = Integer.MIN_VALUE;
        
        for(int[] row: dp)
        	Arrays.fill(row, 0);
   
       
        for(int i = 1 ;i <= board.length; i++) {
        	for(int j = 1 ; j <= board[i-1].length; j++) {
        		dp[i][j] = board[i-1][j-1];
        		if(dp[i][j] == 1) {
        			dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        
        answer = (int) Math.pow(max, 2);
        return answer;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int[][] board = {{1,1,1,1}};
		new Solution().solution(board);
	}

}

/*
 * Java Script 풀이 -> 시간초과  
function solution(board)
{
    var answer = 0;

    var lengthY = board.length;
    var lengthX = board[0].length;
    var max = 0;

    // 행이나 열의 길이가 2 미만이라면 직접 돌리면서 1이 하나라도 있는지 체크 합니다.
    // 하나라도 있으면 통과.
    if (lengthY < 2 || lengthY < 2) {
        for(var i = 0 ; i < lengthY ; i++){
            for(var j = 0;  j < lengthX ; j++) {
                if (board[i][j] === 1) {
                    max = 1;
                }
            }
        }
    } else {
        //아래 설명 참조
        for(var i = 1 ; i < lengthY ; i++){
            for(var j = 1;  j < lengthX ; j++) {
                if(board[i][j] === 1 ){
                    board[i][j] = Math.min(board[i - 1][j], board[i][j - 1], board[i - 1][j - 1]) + 1;
                    if (board[i][j] > max) {
                        max = board[i][j];
                    }
                }
            }
        }
    }

    return Math.pow(max, 2);
}


출처: https://blog.sonim1.com/212 [Kendrick's Blog]
*/

