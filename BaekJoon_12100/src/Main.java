import java.util.*;
import java.io.*;


public class Main {

	static int n;
	static int[][] map = new int[20][20];
	static int ans;
	
	public static void arrayCopy(int map[][],int temp[][]) {
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				temp[i][j] = map[i][j];
			}
		}
		return;
	}
	
	public static void solving() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
	
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < 4; i++) {
			dfs(0,i%4);
		}
		
		
		System.out.print(ans);
	
	}
	
	public static void move(int dir) {
		
		switch(dir) {
		case 0:
			for(int i = 1; i < n; i++) {
				for(int j = 0 ; j < n; j++) {
					if(map[i-1][j] == map[i][j]) {
						map[i-1][j] += map[i-1][j];
						map[i][j] = 0;
					}
					else if(map[i-1][j] == 0) {
						map[i-1][j] = map[i][j];
						map[i][j] = 0;
					}
				}
			}
			break;
		case 2:
			for(int i = n -1; i >= 0; i--) {
				for(int j = 0 ;j < n; j++) {
					if(map[i+1][j] == map[i][j]) {
						map[i+1][j] += map[i+1][j];
						map[i][j] = 0;
					}
					else if(map[i+1][j] == 0) {
						map[i+1][j] = map[i][j];
						map[i][j] = 0;
					}
				}
			}
			break;
		case 1:
			for(int i = n-1; i >=0; i--) {
				for(int j = 0 ; j < n; j++) {
					if(map[j][i + 1] == map[j][i]) {
						map[j][i+1] += map[j][i+1];
						map[j][i] = 0;
					}
					else if(map[j][i+1] == 0) {
						map[j][i+1] = map[j][i];
						map[j][i] = 0;
					}
				}
				
			}
			break;
		case 3:
			for(int i = 1; i < n; i++) {
				for(int j = 0 ; j < n; j++) {
					if(map[j][i - 1] == map[j][i]) {
						map[j][i-1] += map[j][i-1];
						map[j][i] = 0;
					}
					else if(map[j][i-1] == 0) {
						map[j][i-1] = map[j][i];
						map[j][i] = 0;
					}
				}
				
			}
			break;
			
		}
	}
	
	
	
	
	public static void dfs(int cnt,int dir) {
		
		if(cnt == 5) {
			int max = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0 ; j < n; j++) {
					if(max < map[i][j]) 
						max = map[i][j];
				}
			}
			
			ans = Math.max(max, ans);
			return;
			
		}
		
		int[][] temp = new int[20][20];

		arrayCopy(map,temp);
		move(dir);
		
		switch(dir) {
		
		case 0: 
			for(int i = 0 ; i < 4 ;i++) {
				dfs(cnt+1, i%4);
			}
			arrayCopy(temp,map);
		 break;
		case 1:
			for(int i = 0 ; i < 4 ;i++) {
				dfs(cnt+1, i%4);
			}
			arrayCopy(temp,map);
		 break;
		case 2:
			for(int i = 0 ; i < 4 ;i++) {
				dfs(cnt+1, i%4);
			}
			arrayCopy(temp,map);
		 break;
		case 3:
			for(int i = 0 ; i < 4 ;i++) {
				dfs(cnt+1, i%4);
			}
			arrayCopy(temp,map);
		 break;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main().solving();
	}
	
}
