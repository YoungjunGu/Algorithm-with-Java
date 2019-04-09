import java.util.*;

class Solution {
	
	static int[] dirX = {0, 1, 0, -1};
	static int[] dirY = {-1, 0, 1, 0};
	static ArrayList<Integer> fieldCntList = new ArrayList<>();
	int numberOfArea = 0;
	int maxSizeOfOneArea = 0;
	public int[] solution(int m, int n, int[][] picture) {

		int[][] temp = new int[m][n];
		
		for(int[] arr: temp) {
			Arrays.fill(arr,0);
		}
	
		
		bfs(m,n,picture,temp);
		

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
	
	public void bfs(int m, int n, int[][] picture, int[][] temp) {
		
		Queue<Pos> queue = new LinkedList<Pos>();
		int field = 0;
		for(int i = 0 ; i < m; i++) {
			for(int j = 0; j < n; j++) {
				// 아직 접근 하지 않은 곳을 찾는다 .
				if(picture[i][j] == 0) {
					temp[i][j] = -1;
				}
				if(temp[i][j] == 0) {
					int curData = picture[i][j];
					// 해당 영역의 넓이 
					int fieldCnt = 0;
					queue.offer(new Pos(i,j, curData));
					field++;
					while(!queue.isEmpty()) {
						Pos curPos = queue.poll();
						for(int s = 0; s < 4; s++) {
							int nextX = curPos.x + dirX[s];
							int nextY = curPos.y + dirY[s];
							if(0 <= nextX && nextX < m && 0 <= nextY && nextY < n && temp[nextX][nextY] == 0 && picture[nextX][nextY] == curPos.data) {
								queue.offer(new Pos(nextX, nextY, picture[nextX][nextY]));
								fieldCnt++;
								temp[nextX][nextY] = -1;
							}
						}
					}
					fieldCntList.add(fieldCnt);
				}
				
			}
		}
		
		Collections.sort(fieldCntList);
		Collections.reverse(fieldCntList);

		
		numberOfArea = field;
		maxSizeOfOneArea = fieldCntList.get(0);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		new Solution().solution(6, 4, picture);
	}

}

class Pos{
	int x;
	int y;
	int data;
	Pos(int x, int y, int data) {
		this.x = x;
		this.y = y;
		this.data = data;
	}
}
