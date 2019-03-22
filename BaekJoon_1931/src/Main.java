import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int ans;
	static ArrayList<Time> list = new ArrayList<Time>();

	
	public static void solving() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list.add(new Time(start, end));
		}
		
		
		Collections.sort(list, new Comparator<Time>() {

			@Override
			public int compare(Time o1, Time o2) {
				// TODO Auto-generated method stub
				if (o1.end > o2.end) {
					return 1;	
				} else if (o1.end == o2.end) {
					if(o1.start > o2.start)
						return 1;
					else
						return -1;
				} else {
					return -1;
				}
			}
			
		});
		
		for(int i = 0; i < n; i++) {
			System.out.println(list.get(i).start + " " + list.get(i).end);
		}
		
		int end = -1;
		for(int i = 0 ; i < n; i++) {
			
			if(list.get(i).start >= end) {
				end = list.get(i).end;
				ans++;
			}
		}
		
		System.out.print(ans);
		
	

		
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().solving();
	}
	


}

class Time {
	int start;
	int end;
	
	Time(int start,int end) {
		this.start = start;
		this.end = end;
	}
	
}
