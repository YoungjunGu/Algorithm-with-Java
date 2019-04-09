import java.util.*;

public class Solution2 {
	
	public int[] solution(int brown, int red) {
		int[] answer = {};
		int sum = brown + red;
		
		answer = new int[2];
		
		for(int row = 3; row <= sum /3; row++) {
			if(sum % row == 0) {
				int col = sum / row;
				int checkRedCnt = (col - 2)*(row - 2);
				if(checkRedCnt == red) {
					answer[0] = col;
					answer[1] = row;
					break;
				}
			}	
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
