import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[] t;
	static int[] p;
	static int[] dp;
	static int max;
	
	public static void solving() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		t = new int[n];
		p = new int[n];
		dp = new int[n];
		
		for(int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
			dp[i] = p[i];
		}
		
		//
		for (int i = 1; i < n ; i++) {
			for (int j = 0 ; j < i; j++) {
				
				//두 일수의 차이가 해당 j: 시작의 소요 시간보다 같거나 작으면 dp수
				if(i - j >= t[j]) {
					dp[i] = Math.max(p[i] + dp[j], dp[i]);
				}
			}
		}
		
		for(int i = 0 ; i < n ; i ++) {
			if(i + t[i] <= n) {
				if(max < dp[i])
					max = dp[i];
			}
		}
		
		System.out.print(max);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main().solving();

	}

}
