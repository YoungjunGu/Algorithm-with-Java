
public class Solution {

	public int solution(String name) {
		int answer1 = 0;
		int answer2 = 0;
		// 방향키를 위로할지 아래로 할지를 정한다
		answer1 = Math.min(name.charAt(0) - 'A', 'Z' - name.charAt(0) + 1);
		answer2 = answer1;

		// 오른쪽으로 이동 하면서 값을 구한다.
		for (int i = 1; i < name.length(); i++) {
			boolean check = true;
			for (int j = i; j < name.length(); j++) {
				if (name.charAt(j) != 'A') {
					// 아직 A가 아닌것이존재 한다
					check = false;
					break;
				}
			}
			// i 뒤로 모든 문자가A 이므로 더이상볼필요없다
			if (check == true) {
				break;
			}
			answer1++;
			answer1 += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
		}
		
		// 왼쪽으로이동  
		for (int i = name.length() -1;i >= 1; i--) {
			boolean check = true;
			for (int j = i; j >= 1; j--) {
				if (name.charAt(j) != 'A') {
					// 아직 A가 아닌것이존재 한다
					check = false;
					break;
				}
			}
			// i 뒤로 모든 문자가A 이므로 더이상볼필요없다
			if (check == true) {
				break;
			}
			answer2++;
			answer2 += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
		}

		int min = Math.min(answer1, answer2);
		System.out.println(min);
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "ABAAAAAAAAABB";

		new Solution().solution(name);

	}

}
