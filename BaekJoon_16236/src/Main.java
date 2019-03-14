import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[][] map = new int[20][20];
	static boolean[][] visited = new boolean[20][20];
	static int ans;
	static int[] dirX = {0, 1, 0, -1};
	static int[] dirY = {-1, 0, 1, 0};
	static final int MAX = 999;
	
	public static void reset() {
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0; j< n; j++) {
				visited[i][j] = false;
			}
		}
	}
	
	public static void solving() {
		Queue<Item> queue = new LinkedList<Item>();
		Scanner sc = new Scanner(System.in);
		
		int initX = 0, initY = 0;
		
		n = sc.nextInt();
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					initX = i;
					initY = j;
				}
			}
		}
		//초기 상어의 위치 queue에 삽입 
		queue.add(new Item(initX,initY, 2, 0, 0));
		visited[initX][initY] = true;
		
		
		//queue가 빌때까지수행 
		while(!queue.isEmpty()) {
			Item check = new Item(MAX, MAX, 0, 0, 0);
			int queueSize = queue.size();
			for(int i = 0; i < queueSize; i++) {
				Item item = queue.poll();
				for(int j = 0 ; j < 4; j++) {
					int nextX = item.x + dirX[j];
					int nextY = item.y + dirY[j];
					//지나갈수 있는지 판단: 방문하지 않았고 크기가 같거나작아야한다.
					if(0 <= nextX && nextX < n && 0 <= nextY && nextY < n && visited[nextX][nextY] != true && map[nextX][nextY] <= item.size) {
						visited[nextX][nextY] = true;
						queue.add(new Item(nextX, nextY, item.size, item.eat, item.cnt + 1));
					} else {
						continue;
					}
		
					if(map[nextX][nextY] != 0 && map[nextX][nextY] != item.size) {
						if(nextX < check.x) {
							check.x = nextX;
							check.y = nextY;
							check.eat = item.eat;
							check.size = item.size;
							check.cnt = item.cnt + 1;
						} else if(nextX == check.x) {				//동일한 X 위치에 있을경우 가장 위쪽의먹이 선택 
							if(nextY < check.y) {
								check.x = nextX;
								check.y = nextY;
								check.eat = item.eat;
								check.size = item.size;
								check.cnt = item.cnt + 1;
							}
						}
					}
				}
			}
			//먹을 것이 존재하여 값이변경 됨. 
			if(check.x != MAX) {
				check.eat++;
				//만약 먹은 양이현재 상어의 크기와 같을 떄 크기를 up 해준다.
				if(check.eat == check.size) {
					check.size++;
					//먹은 양은 다시 초기화 
					check.eat = 0;
				}
				int newX = check.x;
				int newY = check.y;
				int newSize = check.size;
				int eat = check.eat;
				map[initX][initY] = 0;
				initX = newX;
				initY = newY;
				map[newX][newY] = 9;
				ans += check.cnt;
				reset();
				queue.clear();
				//queue를 비우고 해당 구역을 queue에 추가한 후 그곳에서 다시 BFS를 수행한다.
				visited[newX][newY] = true;
				//지나온 길을 초기화 한 후 지금까지 위치 크기 먹은 양을 기억한 값을 다시 큐에 삽입 
				queue.add(new Item(newX, newY, newSize, eat, 0));
			}
			
			
		}
		
		System.out.print(ans);
		
	}
	
	public static void bfs() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main().solving();

	}
	//cnt의미 : 상어가 이동한 거
	static class Item {
		int x,y,size,eat,cnt;
		
		Item(int x, int y, int size, int eat, int cnt) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.eat = eat;
			this.cnt = cnt;
		}
	}

}
