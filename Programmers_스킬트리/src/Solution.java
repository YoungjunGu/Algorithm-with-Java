import java.util.*;

public class Solution {
	
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        // skill = CDB
        // skill_trees = BBDCD
        
        for(int i = 0; i < skill_trees.length; i++) {
        	boolean flag = false;
        	int cnt = 0;
        	for(int j = 0 ; j < skill_trees[i].length(); j++) {
        		if(skill.indexOf(skill_trees[i].charAt(j)) > cnt) {
        			flag = true;
        			break;
        		} 
        		else if (skill.indexOf(skill_trees[i].charAt(j)) == cnt) {
        			cnt++;
        		}
        	}
    		if(!flag)
    			answer ++;
    		cnt = 0;
        }
   
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "BCE";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		new Solution().solution(skill, skill_trees);
		


	}

}
