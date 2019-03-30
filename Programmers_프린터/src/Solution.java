import java.util.*;

public class Solution {

	public int solution(int[] priorities, int location) {
		int answer = 0;
		int[] file = new int[10];

		Arrays.fill(file, 0);

		Queue<Print> queue = new LinkedList<Print>();

		for (int i = 0; i < priorities.length; i++) {
			file[priorities[i]]++;
			queue.add(new Print(i, priorities[i]));
		}

		while (!queue.isEmpty()) {
			// 큐 앞부분가져온다
			Print p = queue.poll();
			boolean check = true;
	
			for (int i = p.priority + 1; i < 10; i++) {
				if (file[i] > 0) {
					check = false;
					break;
				}
			}
			// 출력 할 수 없고큐 뒤에 삽입 해야한다.
			if (check == false) {
				queue.add(p);
			} else {
				if (p.index == location) {
					System.out.print(answer+1);
					return answer+1;
				} else {
					file[p.priority]--;
					answer++;
				}
			}
		}

		
		return answer;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] pri = { 1, 1, 9, 1, 1, 1 };
		int location = 0;

		new Solution().solution(pri, location);

	}

}

class Print {
	int index;
	int priority;

	public Print(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
}