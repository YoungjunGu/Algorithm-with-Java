import java.util.*;
import java.io.*;

public class Solution {

    public int solution(int[] budgets, int M) {
        int answer = 0;
        
        Arrays.sort(budgets);
        int right = budgets[budgets.length - 1];
        int left = 0;
        int mid = 0;
        int result = 0;
        while(left <= right) {
        	result = 0;
        	mid = (right + left) / 2;
        	for(int b : budgets) {
        		// 예산에서 지정한 상한선 보다 값이 크면 상한선을 거하고 같거나 작으면 그 값 그대로 사용한다.
        		if(b > mid)
        			result += mid;
        		else
        			result += b;	
        	}
        	// 값보다 작거나 같으면 
        	if(result <= M) {
        		if(result >= 0)
        			answer = mid;
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		int[] budgets = {120,110, 140, 150};
		int M = 485;
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution(budgets, M));
	}

}


