import java.util.*;

public class Solution {
	
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        
        int[] temp = new int[progresses.length];
        
        for(int i = 0 ; i < progresses.length; i++) {
        	int day = (100 - progresses[i]) / speeds[i];
        	if((100 - progresses[i]) % speeds[i] > 0) 
        		day += 1;
        	temp[i] = day;
        }
        int curDay = temp[0];
        int cnt = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1 ; i < progresses.length; i++) {
        	if(curDay < temp[i]) {
        		curDay = temp[i];
        		list.add(cnt);
        		cnt = 1;
        	} else {
        		cnt++;
        	}
        }
        list.add(cnt);
        
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		new Solution().solution(progresses, speeds);
	}

}
