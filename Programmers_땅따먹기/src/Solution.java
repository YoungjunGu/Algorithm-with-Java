import java.util.*;

class Solution {
	
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        int last = land.length;
        for(int i = 0 ; i < land.length - 1; i++) {
        	land[i+1][0] = Math.max(land[i][1], Math.max(land[i][2], land[i][3])) + land[i + 1][0];
        	land[i+1][1] = Math.max(land[i][0], Math.max(land[i][2], land[i][3])) + land[i + 1][1];
        	land[i+1][2] = Math.max(land[i][0], Math.max(land[i][1], land[i][3])) + land[i + 1][2];
        	land[i+1][3] = Math.max(land[i][0], Math.max(land[i][1], land[i][2])) + land[i + 1][3];
        }
        answer = Math.max(Math.max(land[last - 1][0], land[last-1][1]), Math.max(land[last -1 ][2], land[last-1][3]));
        
        System.out.println(answer);
        
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		new Solution().solution(land);
	}

}
