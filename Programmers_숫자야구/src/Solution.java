import java.util.*;

public class Solution {

    public int solution(int[][] baseball) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 1 ; i < 10; i++) {
        	for(int j = 1; j < 10; j++) {
        		for(int k = 1; k < 10; k++) {
        			if(i != j && j != k && i != k) {
        				list.add(i * 100 + j * 10 + k);
        			}
        		}
        	}
        }
        
      
        for(int i = 0; i < baseball.length; i++) {
        	int num = baseball[i][0];
        	int strike = baseball[i][1];
        	int ball = baseball[i][2];
        	for(int j = 0 ; j < list.size(); j++) {   		
        		if(list.get(j) != -1 && !check(num,strike,ball,list.get(j))) {
        			list.remove(j);
        			// 빈곳을 끼워넣
        			list.add(j, -1);
        		}
        	}
        }
        
        for(int i = 0 ; i < list.size(); i++) {
        	if(list.get(i) != -1)
        		answer++;
        }
        
        System.out.println(answer);   
        return answer;
    }
    
    public boolean check(int num, int s, int b, int num2) {
    	String s1 = String.valueOf(num);
    	String s2 = String.valueOf(num2);
    	int checkS = 0;
    	int checkB = 0;
    	
    	for(int i = 0 ; i < 3; i++) {
    		if(s1.charAt(i) == s2.charAt(i))
    			checkS++;
    	}
    	for(int i = 0 ; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			if(i != j && s1.charAt(i) == s2.charAt(j))
    				checkB++;
    		}
    	}
    	if(checkS != s)
    		return false;
    	if(checkB != b)
    		return false;
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		
		new Solution().solution(baseball);

	}

}
