import java.util.*;

public class Solution {
	int answer = Integer.MAX_VALUE;
	
	public int solution(String begin, String target, String[] words) {
		int[] isUsed = new int[words.length];
		Arrays.fill(isUsed, 0);
		
		dfs(begin, target,words,0,isUsed);
		if(answer == Integer.MAX_VALUE) {
			answer = 0;
		}
		return answer;
	}
	//isUsed = 문자열 재 검사를 방지 하기 위한배열  
	public void dfs(String curStr, String target, String[] words, int cnt,int[] isUsed) {
		if(target.equals(curStr)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		cnt++;
		
		for(int i = 0 ; i < words.length; i++) {
			//변경 되어야 할 글자의 수 
			int strCnt = 0;
			for(int j = 0 ; j < curStr.length(); j++) {
				if(curStr.charAt(j) != words[i].charAt(j)) {
					strCnt++;
				}
			}
			//글자 수가 하나만 차이가 나면 dfs 수행한다 
			if(strCnt == 1 && isUsed[i] == 0) {
				isUsed[i] = -1;
				dfs(words[i], target, words,cnt,isUsed);
				isUsed[i] = 0;
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot","dot","dog","lot","log","cog"};
		System.out.println(new Solution().solution(begin, target, words));
	}

}
