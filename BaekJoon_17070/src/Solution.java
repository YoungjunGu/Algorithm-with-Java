import java.util.*;
import java.io.*;

public class Solution {
	static int answer = 0;
	static int N = 0;

	public int solution() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int[][] map = new int[N + 1][N + 1];
		
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(map, new Pipe(0,new Index(1,1), new Index(1,2)));
		
		return answer;
	}

	public static boolean checkRange(int[][] map, int i, int j) {
		if (1 <= i && i <= N && 1 <= j && j <= N && map[i][j] == 0) {
			return true;
		}
		return false;
	}
	// 0 가로 , -1 : 세로 , 1: 대각선

	public static Pipe move(int[][] map, Pipe curPipe, int dirMenu) {
		int i = curPipe.end.x;
		int j = curPipe.end.y;
		// 가로일때
		if (curPipe.dir == 0) {
			// 가로이동 
			if (dirMenu == 0) {
				if(checkRange(map, i, j+1)) {
					Pipe movePipe = new Pipe(0, curPipe.end, new Index(i, j + 1));
					return movePipe;
				} else {
					return null;
				}
			}
			// 대각 선 이동
			if (dirMenu == 1) {
				if (checkRange(map, i + 1, j + 1) && checkRange(map, i, j + 1) && checkRange(map, i + 1, j)) {
					Pipe movePipe = new Pipe(1, curPipe.end, new Index(i + 1, j + 1));
					return movePipe;
				} else {
					return null;
				}
			}
		} // 대각선 일때  
		else if(curPipe.dir == 1) {
			//가로 이동  
			if(dirMenu == 0) {
				if(checkRange(map, i, j + 1)) {
					Pipe movePipe = new Pipe(0, curPipe.end, new Index(i, j + 1));
					return movePipe;
				} else {
					return null;
				}
			}
			if(dirMenu == 1) {
				if (checkRange(map, i + 1, j + 1) && checkRange(map, i, j + 1) && checkRange(map, i + 1, j)) {
					Pipe movePipe = new Pipe(1, curPipe.end, new Index(i + 1, j + 1));
					return movePipe;
				} else {
					return null;
				}
			}
			if(dirMenu == -1) {
				if(checkRange(map, i + 1, j)) {
					Pipe movePipe = new Pipe(-1, curPipe.end, new Index(i+1 , j));
					return movePipe;
				} else {
					return null;
				}
			}
		} // 세로 일때 == -1
		else {
			if(dirMenu == -1) {
				if(checkRange(map, i+1, j)) {
					Pipe movePipe = new Pipe(-1, curPipe.end, new Index(i+1 , j));
					return movePipe;
				} else {
					return null;
				}
			}
			if(dirMenu == 1) {
				if (checkRange(map, i + 1, j + 1) && checkRange(map, i, j + 1) && checkRange(map, i + 1, j)) {
					Pipe movePipe = new Pipe(1, curPipe.end, new Index(i + 1, j + 1));
					return movePipe;
				} else {
					return null;
				}
			}		
		}
		return null;
	}

	// check == 가로 세로 여부 , curPipe = current Pipe
	public static void dfs(int[][] map, Pipe curPipe) {
		if(curPipe == null) {
			return;
		}
		int i = curPipe.end.x;
		int j = curPipe.end.y;
		int curDir = curPipe.dir;
		// 도착했는지 판단
		if (i == N && j == N) {
			answer++;
			return;
		}
		Pipe movePipe;
		switch(curDir) {
		// 가로 방향  
		case 0:
			movePipe = move(map, curPipe, 0);
			dfs(map,movePipe);
			movePipe = move(map, curPipe, 1);
			dfs(map,movePipe);
			break;
		// 대각선 방향 0 -1 1 다 가
		case 1:
			movePipe = move(map, curPipe, -1);
			dfs(map,movePipe);
			movePipe = move(map, curPipe, 0);
			dfs(map,movePipe);
			movePipe = move(map, curPipe, 1);
			dfs(map,movePipe);
			break;
		case -1:
			movePipe = move(map, curPipe, -1);
			dfs(map,movePipe);
			movePipe = move(map, curPipe, 1);
			dfs(map,movePipe);
			break;
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().solution());
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

class Pipe {
	int dir;
	Index start;
	Index end;
	public Pipe(int dir, Index start, Index end) {
		this.dir = dir;
		this.start = start;
		this.end = end;
	}
}
