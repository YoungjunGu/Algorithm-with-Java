import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	
	static ArrayList<Snake> orderList = new ArrayList<Snake>();
	
	public static int solution() {
		int answer = 0 ;
		Scanner sc = new Scanner(System.in);
		int K = 0;
		N = sc.nextInt();
		map = new int[N][N];
		Arrays.fill(map, 0);
		
		K = sc.nextInt();
		
		for(int i = 0 ; i < K; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			map[row][col] = 1;
		}
		

		K = sc.nextInt();
		
		for(int i = 0 ; i < K; i++) {
			int step = sc.nextInt();
			String dir = sc.nextLine();
			orderList.add(new Snake(step, dir));
		}
		
		return answer;
	}
	
	static void moveSnake() {
		String
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Snake {
	int step;
	String dir;
	public Snake(int step, String dir) {
		this.step = step;
		this.dir = dir;
	}
}
