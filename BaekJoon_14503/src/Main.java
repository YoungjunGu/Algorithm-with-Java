import java.util.*;
import java.io.*;

public class Main {

	static int[] dirX = { -1, 0, 1, 0 };
	static int[] dirY = { 0, 1, 0, -1 };
	
	static int[] backX = {1, 0, -1, 0};
	static int[] backY = {0, -1, 0, 1};
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
		
		if(map[x][y] == 1) {
			return;
		}
		
		if(map[x][y] == 0) {
			map[x][y] = 2;
			clean++;
		}
		
		for (int i = 0 ; i < 4 ; i++) {
			
			int nextDir;
			
			if(dir -1 < 0)
				nextDir = 3;
			else
				nextDir = dir - 1;
			
			int nextX = x + dirX[nextDir];
			int nextY = y + dirY[nextDir];
			
			if (map[nextX][nextY] == 0) {
				
				DFS(nextX,nextY,nextDir);
				return;
				
			} else {
				dir = nextDir;
			}
		}
		
		int nextX = x + backX[dir];
		int nextY = y + backY[dir];
		
		DFS(nextX,nextY,dir);
		
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
