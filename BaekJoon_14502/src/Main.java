import java.awt.Point;
import java.io.*;
import java.util.*;


public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static int[][] temp;
	static int ans;
	static int[] dirX = {0, 1, 0, -1};
	static int[] dirY = {-1, 0, 1, 0};
	
	public static void solving() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		temp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0 ;  j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				if(map[i][j] == 0) {
				
					temp = arrayCopy(map);
					temp[i][j] = 1;
					wallSetting(1);
					temp[i][j] = 0;
				}
			}
		}
		
		System.out.print(ans);
		
	}
	
	public static void wallSetting(int cnt) {
		//벽을 세우
		if(cnt == 3) {
			bfs();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j< m ; j++) {
				//해당 구역이 빈공간이
				if (temp[i][j] == 0) {
					//벽으로 셋
					
					temp[i][j] = 1;
					wallSetting(cnt + 1);
					//모든 경우의 수를 위해 back tracking -> 브루트 포
					temp[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs() {
		
		//queue
		Queue<Point> queue = new LinkedList<Point>();
		int [][] spreadLab = new int[n][m];
		//배열 복
		spreadLab = arrayCopy(temp);
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j< m; j++) {
				//바이러스를 찾아서 큐에 삽
				if(spreadLab[i][j] == 2) {
					queue.add(new Point(i,j));
				}
			}
		} 	
		
		//bfs 수행
		while(queue.isEmpty() == false) {
			Point p = queue.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int nextX = p.x + dirX[i];
				int nextY = p.y + dirY[i];
				if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m) {
					if(spreadLab[nextX][nextY] == 0) {
						spreadLab[nextX][nextY] = 2;
						queue.add(new Point(nextX,nextY));
					}
				}
			}
		}
		
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				if(spreadLab[i][j] == 0)
					cnt++;
			}
		}
		
		ans = Math.max(ans, cnt);
	
	}
	
	public static int[][] arrayCopy(int[][] array) {
		int[][] temp = new int[n][m];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < m; j++) {
				temp[i][j] = array[i][j];
			}
		}
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main().solving();

	}

}
