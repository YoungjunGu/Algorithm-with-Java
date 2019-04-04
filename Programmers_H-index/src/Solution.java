import java.util.*;

public class Solution {
	
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < citations.length; i++) {
        	list.add(citations[i]);
        }
        
        Collections.sort(list);
        Collections.reverse(list);
        
        for(int i = 0 ; i < list.size() + 1; i++) {
        	if(i == list.size()) {
        		answer = i;
        	} 
        	else if(list.get(i) <= i) {
        		answer = i;
        		break;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
