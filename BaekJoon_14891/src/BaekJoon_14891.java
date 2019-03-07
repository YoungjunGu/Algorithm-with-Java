import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BaekJoon_14891 {

	static LinkedList<Integer>[] list = (LinkedList<Integer>[]) new LinkedList[5];

	private static void solving() {

		for (int i = 1; i <= 4; i++) {
			list[i] = new LinkedList<Integer>();
			String inputString = sc.readLine();
		
			for(String s: inputString.split("")) {
				int n = Integer.parseInt(s);
				list[i].add(n);
			}
		}
		
		int k = sc.nextInt();
		//K 횟수만큼 진
		for (int i = 0 ; i < k; i++) {
			int n = sc.nextInt();
			int d = sc.nextInt();
			
			left(n - 1, -d);
			right(n + 1, -d);
			rotateGear(n,d);
			
		}
		
		System.out.print(score());
		
	}
	
	public static int score() {
		int ans = 0;
		
		for(int i = 0; i < 4 ; i++) {
			if(list[i + 1].get(0) == 1) {
				ans += (int) Math.pow(2, i);
			}
		}
		return ans;
	}
	
	// 방향에 따라 배열을 변경
	public static void rotateGear(int gearNum, int dir) {
		//시계방
		if (dir == 1) {
			list[gearNum].addFirst(list[gearNum].pollLast());
		} else {
			list[gearNum].addLast(list[gearNum].pollFirst());
		}
	}
	
	public static boolean check(int g1, int g2) {
		
		if (g1 < g2) {
			if(list[g1].get(2) == list[g2].get(6))
				return false;
			else
				return true;
		} else {
			if(list[g1].get(6) == list[g2].get(2))
				return false;
			else
				return true;
		}
	}
	
	public static void left(int n, int dir) {
		if (!(1 <= n && n <= 4))
		     return;
		
		if (check(n,n + 1)) {
			//같으면 왼쪽에 있는 톱니는 반대방향으로 돌아야 하므로 -1
			left(n - 1, -dir);
			rotateGear(n, dir);
		}
	}
	
	public static void right(int n, int dir) {
		if (!(1 <= n && n <= 4))
			return;

		
		if( check(n, n - 1)) {
			right(n + 1, -dir);
			rotateGear(n,dir);
		}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		
		new BaekJoon_14891().solving();
	}

}
