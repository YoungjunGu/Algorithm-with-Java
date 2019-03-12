import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map = new int[200][100];
	
	static int N;
	static int L;
	static int ans;
	
	public static void solving() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		//http://www.hellogohn.com/post_one258 참
		//전치(transpose)를 통해 코드양, 시간절약 
		for(int i = 0; i < N;i++) {
			for(int j = 0 ; j < N; j++) {
				map[i + N][j] = map[j][i];
			}
		}
		
		for(int i = 0 ; i < 2*N; i++) {
			int cnt = 1;
			int j = 0;
			for(j = 0 ; j < N - 1; j++) {
				if(map[i][j] == map[i][j+1] ) {
					cnt++;
				}
				// > < 를 쓰 안되고 +1 -1 인지 판단 해야한다.
				else if(map[i][j] + 1 == map[i][j + 1] && cnt >= L) {
					cnt = 1;
				}
				else if(map[i][j] - 1 == map[i][j + 1] && cnt >= 0) {
					cnt = -L + 1;
				}
				else 
					break;
			}
			if (j == N - 1 && cnt >= 0) 
				ans++;
		}
		
		System.out.print(ans);
		

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Main().solving();
	}

}
