import java.io.*;
import java.util.*;


public class Main {
	static boolean[] visited = new boolean[10];
	static int[] oper = new int[4];
	static int[] array;
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	long ans;
	
	public static void solving() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		array = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			array[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < 4; i++) {
			oper[i] = sc.nextInt();
		}
		
		// 그다음 숫자의 인덱스와 처음 숫자를 넘겨준다.
		dfs(1,array[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}

	public static void dfs(int index, int totalNum) {
		
		if( index == n ) {
			max = Math.max(max,totalNum);
			min = Math.min(min, totalNum);
			return;
		}
		//아직 남아있다면 DFS를 수행
		//BackTracking을 위해 다시 ++ 해준다. -> 완전탐색을 위
		if(oper[0] > 0 ) {
			oper[0]--;
			dfs(index + 1, totalNum + array[index]);
			oper[0]++;
		}
		if(oper[1] > 0 ) {
			oper[1]--;
			dfs(index + 1, totalNum - array[index]);
			oper[1]++;
		}
		if(oper[2] > 0 ) {
			oper[2]--;
			dfs(index + 1, totalNum * array[index]);
			oper[2]++;
		}
		if(oper[3] > 0 ) {
			oper[3]--;
			dfs(index + 1, totalNum / array[index]);
			oper[3]++;
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main().solving();
	}

}
