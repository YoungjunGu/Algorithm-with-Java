import java.util.*;

public class Solution {
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		int N;
		int x,y;
		String[] arr = new String[22];
		
		N = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		
		arr[0] = "0";
		for(int i = 1 ; i < 4; i++) {
			int length = arr[i-1].length();
			String tempStr = arr[i-1];
			arr[i] = arr[i-1];
			for(int j = 0 ; j < length; j++) {
				if(tempStr.charAt(j) == '0')
					arr[i] += "1";
				else
					arr[i] += "0";
			}
		}
		String a = "0110";
		String b = "1001";
		for(int i = 4; i < N; i++) {
			
		}
		
		String ans = "";
		if(y > arr[N-1].length())
			y = arr[N-1].length();
		for(int i = x - 1 ; i < y; i++) {
			System.out.print(arr[N-1].charAt(i));
		}
		System.out.println(ans);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().solution();
	}

}
