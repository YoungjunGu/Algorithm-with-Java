import java.util.*;

class Solution {
	
	
	public int solution(int n, int[][] computers) {
		int answer = 0;
		int[][] temp = new int[computers.length][n];
		
		for(int[] arr: temp)
			Arrays.fill(arr, 0);
	
		return answer - bfs(n, computers, temp);
	}
	
	public int bfs(int n,int[][] computers, int[][] temp) {
		int check = 0;
		Queue<Index> queue = new LinkedList<Index>();
		for(int i = 0 ; i < computers.length; i++) {
			for(int j = 0; j < n; j++) {
				if(computers[i][j] == 1 && i != j && temp[i][j] == 0) {
					queue.offer(new Index(i,j));
					check++;
					while(!queue.isEmpty()) {
						Index index = queue.poll();
						for(int s = 0; s < 4; s++) {
							int nextX = index.y;
							int nextY = index.x;
							if(temp[nextX][nextY] == 0) {
								queue.offer(new Index(nextX, nextY));
								temp[nextX][nextY] = -1;
							}
						}					
					}
				}
			}
		}
		return check;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		new Solution().solution(3, computers);
	}

}
class Index {
	int x;
	int y;
	public Index(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
