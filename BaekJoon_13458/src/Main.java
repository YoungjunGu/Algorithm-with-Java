import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] array;
	static int b,c;
	static long ans;
	
	
	public static void solving() {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		array = new int[n];
		
		for (int i = 0 ; i < n ; i++) {
			array[i] = sc.nextInt();
		}
		
		b = sc.nextInt();
		c = sc.nextInt();
		
		for(int i = 0 ; i < n; i ++) {
			ans++;
			
			array[i] -= b;
			
			if (array[i] > 0 ) {
				ans += (int) Math.ceil((double) array[i] / c);
			}
			
		}
		
		System.out.print(ans);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main().solving();
	}

}
