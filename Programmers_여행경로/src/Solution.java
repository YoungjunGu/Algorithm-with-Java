import java.util.*;

// 성공한 코드  
public class Solution {
	static String[] answer;
	ArrayList<String> list = new ArrayList<>();
	public String[] solution(String[][] tickets) {
		int[] visited = new int[tickets.length];
		String ans = "";
		answer = new String[tickets.length + 1];
		Arrays.fill(visited, 0);
		
		for(int i = 0 ; i < tickets.length; i++) {
			if(tickets[i][0].equals("ICN")) {
				ans += "ICN" + ",";
				visited[i] = -1;
				dfs(tickets, i, visited, 0, ans);
				ans ="";
				visited[i] = 0;
			}
		}	
		
		Collections.sort(list);
		answer = list.get(0).split(",");
		
		return answer;
	}
	// curPos = 현재의 공항의 row index  
	public void dfs(String[][] tickets, int curPos, int[] visited, int cnt, String ans) {
		if(cnt == tickets.length - 1) {
			ans += tickets[curPos][1] + ",";
			list.add(ans);
			return;
		}
		cnt++;
		ans += tickets[curPos][1] + ",";	
		for(int i = 0; i < tickets.length; i++) {
			if(tickets[curPos][1].equals(tickets[i][0]) && visited[i] == 0) {
				visited[i] = -1;
				dfs(tickets, i, visited, cnt, ans);
				visited[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		new Solution().solution(tickets);
	}

}
