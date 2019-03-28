import java.util.*;
import java.io.*;


public class Main {

	static int n;
	
	public static void solving() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int c = 0; c < n ; c++) {
			int line = sc.nextInt();
			int antCnt = sc.nextInt();

			
			int max = Integer.MIN_VALUE;
			int min = Integer.MIN_VALUE;
			for(int i = 0 ; i < antCnt; i++) {
				//개미가 있는 위치 
				int pos = sc.nextInt();
	           
	                
	            int antMin = Math.min(pos, line-pos);
	            int antMax = Math.max(pos, line-pos);
	                
	            min = Math.max(min, antMin);
	            max = Math.max(max, antMax);
			}
			//min 과 max 에 각각중간 값과 개미의 위치 차이가 들어있다.
			System.out.println(min + " " + max);
		
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main().solving();
	}

}
