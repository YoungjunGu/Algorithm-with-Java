import java.util.Arrays;

import org.w3c.dom.NameList;

public class Solution2 {
	
	@SuppressWarnings("unlikely-arg-type")
	public int solution(String name) {
		int answer = 0;
		String[] nameChar = name.split("");
		char[] word = new char[name.length()];
		Arrays.fill(word, 'A');
		boolean check = true;
		int index = 0;
		
		while(!check) {
			int right = 1;
			int left = 1;
			if(name.charAt(index) != 'A') {
				answer = Math.min(name.charAt(index) - 'A', 'Z' - name.charAt(index) + 1);
				nameChar[index] = "A";
			}
			if(word.equals(nameChar)) {
				break;
			}
			else {
				// left right 방향으로 A 의 개수가 가장 적은 곳으로 이동 해야한다.
				for(int i = 1 ; i < name.length(); i++) {
					
				}
			}
		}
		
		
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
