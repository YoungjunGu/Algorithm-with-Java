import java.util.*;

public class Solution {

	public int solution(int n) {
		int answer = 0;
		int oneCnt = getOneCount(n);
		while(n <= 1000000) {
			int cnt = getOneCount(++n);
			if(cnt == oneCnt) {
				return n;
			}
		}
		return answer;
	}
	
	public int getOneCount(int n) {
		int cnt = 0;
		
		while(n >= 1) {
			if(n % 2 != 0) {
				cnt++;
			}
			n /= 2;
		}
		
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution(78));
	}

}
