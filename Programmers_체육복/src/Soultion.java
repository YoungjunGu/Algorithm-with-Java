import java.util.Arrays;

public class Soultion {
	
	
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] list = new int[n];
        int numLost = 0;			//체육복이 없는 학생들의카운트 
        
        Arrays.fill(list, 1);
        
        for(int i = 0 ; i < reserve.length; i++) {
        	list[reserve[i] - 1] += 1;
        }
        
        for(int i = 0 ; i < lost.length; i++) {
        	list[lost[i] - 1] -= 1;
        	if(list[lost[i]- 1] == 0) {
        		numLost += 1;
        	}
        }
        
        
        
        for(int i = 0 ; i < n; i++) {
        	//옷이 없을때 주변을 확인 한다 
        	if(list[i] == 0) {
        		if(i != 0 && list[i - 1] == 2) {
        			list[i] += 1;
        			list[i - 1] -= 1;
        			numLost -= 1;
        		} 
        		else if(i != list.length -1 && list[i + 1] == 2) {
        			list[i] += 1;
        			list[i + 1] -= 1;
        			numLost -= 1;
        		}
        	}
        }
        answer = n - numLost;
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		
		new Soultion().solution(n, lost, reserve);

	}

}
