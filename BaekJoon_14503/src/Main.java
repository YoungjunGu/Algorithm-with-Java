import java.util.*;
import java.io.*;

public class Main {

	static int[] dirX = { -1, 0, 1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };
	static int[][] map = new int[50][50];
	static int n;
	static int m;
	static int clean;

	public static void solving() {
		n = sc.nextInt();
		m = sc.nextInt();

		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		DFS(r, c, d);

		System.out.print(clean);

	}

	public static void DFS(int x, int y, int dir) {
		
		int nextX; 
		int nextY;
		// 벽이면 청소를중단 
		int check = 0;
		
		System.out.println("---------------------------");
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j<m ;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(clean + "-------------------------");
		
		
		if(map[x][y] == 1) {
			return;
		}
		
		if(map[x][y] == 0) {
			map[x][y] = 2;
			clean++;
		}
		
		for (int i = 0 ; i < 4 ; i++) {
			
			//방향이 북에서 서쪽으로 이동 할때 0 -> 3 이 되므로  방향값변
			if (dir - 1 < 0) {
				dir = 3;
			} else {
				--dir;
			}
			
			nextX = x + dirX[dir];
			nextY = y + dirY[dir];

			//해당 구역이 청소되었거나 벽일 경우에는 ++;
			if(map[nextX][nextY] != 0) {
				check++;
			} else {
				DFS(nextX,nextY,dir);
			}
		}
	
		//후진 해야한다.
		if(check == 4) {
			switch(dir) {
			case 3:
				x++;
				break;
			case 2:
				y--;
				break;
			case 1:
				x--;
				break;
			case 0:
				y++;
				break;
			}
			DFS(x,y,dir);
			
		} else {
			nextX = x + dirX[dir];
			nextY = y + dirY[dir];
			
			DFS(nextX,nextY,dir);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();

		new Main().solving();

	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {

			}
			return null;
		}

		static String readLineReplace() {
			try {
				return br.readLine().replace("\\s+", "");
			} catch (IOException e) {
			}
			return null;
		}

		static boolean hasNext() {
			return st.hasMoreTokens();
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {

				}
			}
			return st.nextToken();
		}

		static long nextLong() {
			return Long.parseLong(next());
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}

	}

}
