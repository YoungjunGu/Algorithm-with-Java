import java.util.*;

class Solution {
	
	public String solution(String s) {
	      String answer = "";
	      String[] temp = s.split(" ");
	      
	      String max = temp[0];
	      String min = temp[0];
	      for(int i = 0 ; i < temp.length; i++) {
	    	  if(Integer.parseInt(max) < Integer.parseInt(temp[i]))
	    		  max = temp[i];
	    	  if(Integer.parseInt(min) > Integer.parseInt(temp[i]))
	    		  min = temp[i];
	      }
	      answer = min + " " + max;
	      
	      System.out.println(answer);
	      return answer;
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Solution().solution("-2 -10 -3 -4");
	}

}
