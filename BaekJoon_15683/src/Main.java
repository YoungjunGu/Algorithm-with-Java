import java.util.*;
import java.io.*;


public class Main {
	
	static int n;
	static int m;
	static int[][] map;

	static int ans = 987654321;
	static ArrayList<Camera> list;
	
	public static void copyArray(int temp[][]) {
		for(int i = 0; i < n; i++ ) {
			for(int j = 0; j < m ; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}
	public static void resetArray(int temp[][]) {
		for(int i = 0; i < n; i++ ) {
			for(int j = 0; j < m ; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	
	//4	방향으로 CCTV 가 감지할 함수 
	// 0 : 북, 1 : 동, 2 : 남, 3: 서 
	public static void detecting(int x, int y, int dir) {
		
		switch(dir) {
		case 0:
			for(int i = y - 1; i >= 0 ; i--) {
				if(map[x][i] == 6)
					break;
				if(map[x][i] == 0)
					map[x][i] = -1;
			}
			break;
		case 1:
			for(int i = x + 1; i < n ; i++) {
				if(map[i][y] == 6)
					break;
				if(map[i][y] == 0)
					map[i][y] = -1;
			}
			break;
		case 2:
			for(int i = y + 1; i < m ; i++) {
				if(map[x][i] == 6)
					break;
				if(map[x][i] == 0)
					map[x][i] = -1;
			}
			break;
		case 3:
			for(int i = x - 1; i >= 0 ; i--) {
				if(map[i][y] == 6)
					break;
				if(map[i][y] == 0)
					map[i][y] = -1;
			}
			break;
		}
	}
	
	public static void solving() {
		Scanner sc = new Scanner(System.in);

		
		n = sc.nextInt();
		m = sc.nextInt();
		list = new ArrayList<Camera>();
		map = new int[n][m];
		
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] < 6 && map[i][j] != 0) {
					list.add(new Camera(i,j,map[i][j],0));
				}
			}
		}	
		
		int camCnt = list.size();
		dfs(0,camCnt);
		
		System.out.print(ans);
		
	}
	
	//curCnt = 현재 탐색한 캠의 개수 , camCnt : 총 캠의 개
	public static void dfs(int curCnt, int camCnt) {
		//캠을 모두 탐색했으면 최소값을 비교하고 종료한다.
		if(curCnt == camCnt) {
			int cnt = 0;
			for(int i = 0 ; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 0) 
						cnt++;
				}
			}
			ans = Math.min(cnt, ans);
			return;
		}
		
		int x = list.get(curCnt).x;
		int y = list.get(curCnt).y;
		int type = list.get(curCnt).type;
		int[][] temp = new int[n][m];
		copyArray(temp);
		
		
		switch(type) {
		case 1: 
			for(int i = 0; i < 4; i++) {
				detecting(x,y,i);
				dfs(curCnt+1,camCnt);
				
				resetArray(temp);
			}
			break;
		case 2:
			for(int i = 0 ; i < 2; i++) {
				detecting(x,y,i);
				detecting(x,y,i+2);
				dfs(curCnt+1,camCnt);
				resetArray(temp);
			}
			break;
		case 3:
			for(int i = 0 ; i < 4; i++) {
				detecting(x,y,i);
				detecting(x,y,(i+1)%4);
				dfs(curCnt+1,camCnt);
				resetArray(temp);
			}
			
			break;
		case 4:
			// 0 1 2 ,1 2 3, 2 3 0, 3 0 1
			for(int i = 0 ; i < 4; i++) {
				detecting(x,y,i);
				detecting(x,y,(i+1)%4);
				detecting(x,y,(i+2)%4);
				dfs(curCnt+1, camCnt);
				resetArray(temp);
			}
			break;
		case 5:
			detecting(x,y,0);
			detecting(x,y,1);
			detecting(x,y,2);
			detecting(x,y,3);
			dfs(curCnt + 1,camCnt);
			break;	
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().solving();
	}
	
	static class Camera {
		int x,y,type,visited;
		
		Camera(int x, int y, int type, int visited) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.visited = visited;
		}
	}
	


}
