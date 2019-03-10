import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
	
	static int n;
	static int[][] map = new int[21][21];
	static int ans = 987654321;
	
	static int[] isUsed = new int[21];
	
	
	// currentStart: 현재 뽑은 start팀 선수 , cnt = start 팀의 뽑은인원
	public static void dfs(int currentStart,int cnt) {
	
		//N/2명을 선발했으면 DFS 종료 후 선수들의 차이 계산 해야한다.
		if (cnt == n/2) {
			ArrayList<Integer> start  = new ArrayList<>();
			ArrayList<Integer> link  = new ArrayList<>();
			
			for (int i = 0 ; i < n ; i ++) {
				if(isUsed[i] == 0) {
					//System.out.print(i);
					start.add(i);
				} else {
					link.add(i);
				}
			}
			
			int startStat = 0;
			int linkStat = 0;
			
			for(int i = 0 ; i < start.size(); i++) {
				for(int j = i+1 ; j < start.size(); j++) {
					int startX = start.get(i), startY = start.get(j);
					int linkX = link.get(i),linkY = link.get(j);
					startStat += map[startX][startY] + map[startY][startX];
					linkStat += map[linkX][linkY] + map[linkY][linkX];
				}
			}
			
			ans = Math.min(ans, Math.abs(startStat - linkStat));
			
			return;
		}
		
		for (int i = currentStart + 1; i < n ; i++) {
			//아직 출전하지 않
			if(isUsed[i] == 0) {
				isUsed[i] = -1;
				dfs(i,cnt+1);
				//back tracking
				isUsed[i] = 0;
			}
		}
		
	}
	
	public static void solving() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		
		for (int i = 0 ; i < n ; i++) {
			for (int j = 0 ; j < n ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,0);
		
		System.out.print(ans);
		
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main().solving();

	}

}
