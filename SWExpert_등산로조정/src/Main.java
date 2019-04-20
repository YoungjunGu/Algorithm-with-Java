import java.util.*;

public class Main {
	static int N;
	static int caseCnt;
	static int[][] map;
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		caseCnt = sc.nextInt();
		
		for(int cnt = 0 ; cnt < caseCnt; cnt++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(max < map[i][j])
						max = map[i][j];
					map[i][j] = sc.nextInt();
				}
			}
			
		
		}
		
	}
	
	public static void checkHight(int max, int[][] map) {
		ArrayList<Index> list = new ArrayList<Index>(); 
		for(int i = 0 ; i< map.length; i++) {
			for(int j = 0 ;j < map[i].length; j++) {
				if(max == map[i][j])
					list.add(new Index(i,j, max));
			}
		}
		
		for(int i = 0 ; i < list.size(); i++) {
			
			
		}
	}
	
	public int dfs(Index index, int[][] map, int cnt) {
		if()
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Index {
	int x;
	int y;
	int value;
	public Index(int x,int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
}
