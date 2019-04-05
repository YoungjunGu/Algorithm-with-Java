import java.util.*;


public class Solution {
	int answer = 0;
    public int solution(int[] numbers, int target) {
       
        dfs(numbers, target, 0);
        
        System.out.println(answer);
        return answer;
    }
    
    
    public void dfs(int[] numbers, int target, int cnt) {
    	if(cnt == numbers.length) {
    		int sum = 0;
    		for(int i = 0 ; i < numbers.length; i++) {
    			sum += numbers[i];
    		}
    		if(sum == target) {
    			for(int i = 0 ; i < numbers.length; i++) {
    				System.out.print(numbers[i] + " ");
    			}
    			System.out.println("---------");
    			answer++;
    			return;
    		} else {
    			return;
    		}
    	}
    	
    		dfs(numbers, target,cnt+1);
    		numbers[cnt] *= -1;
    		dfs(numbers, target,cnt+1);
    		numbers[cnt] *= 1;
    	return;
    	
  
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		new Solution().solution(numbers, target);
	}

}
