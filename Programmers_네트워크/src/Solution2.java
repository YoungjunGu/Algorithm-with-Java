import java.util.*;

//DFS를 이용한 풀이  
public class Solution2 {
	static int[] visited;
	
	public int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new int[n + 1];
		
		Arrays.fill(visited, 0);
		visited[n] = -1;

		for(int i = 0 ; i < n ; i ++) {
			if(visited[i] == 0) {
				answer++;
				dfs(i, computers, n);
			}
		}
		return answer;
	}
	
	public void dfs(int vertex, int [][] computers,int n) {
		visited[vertex] = -1;
		for(int i = 0; i < n; i++) {
			if(visited[i] == 0 && computers[vertex][i] == 1) {
				dfs(i,computers,n);
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] computers = { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 0 } };
		System.out.println(new Solution().solution(4, computers));
	}

}
