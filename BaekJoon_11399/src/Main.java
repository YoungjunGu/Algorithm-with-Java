import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

public class Main {
	
	static int n;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int ans;
	
	public static void solving() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int i = 0 ; i < n; i++) {
			int num = sc.nextInt();
			list.add(num);
		}
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2)
					return 1;
				else 
					return -1;
			}
		});
		
		int cnt =0;
		for(int i = 0; i < n; i++ ) {
			int sum = cnt + list.get(i);
			cnt = sum;
			ans += cnt;
		}
		
		System.out.print(ans);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().solving();
	}

}
