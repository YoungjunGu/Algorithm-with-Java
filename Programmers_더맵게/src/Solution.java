import java.util.*;

public class Solution {
	
    public int solution(int[] scoville, int K) {
    	int check = 0;
        int answer = -1;
        
        Queue<Integer> pq = new PriorityQueue<Integer>(scoville.length);
        
        for(int i = 0 ;i < scoville.length; i++) {
        	pq.offer(scoville[i]);
        }
        
        while(pq.size() > 1) {
        	if(pq.peek() >= K) {
        		answer = check;
        		break;
        	}
        	
        	int first = pq.poll();
        	int second = pq.poll();
        	
        	pq.offer(first + (second * 2));
        	check++;
        }
        
        if(pq.poll() >= K) {
        	answer = check;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
