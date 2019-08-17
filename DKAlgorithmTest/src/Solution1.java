import java.util.*;

public class Solution1 {
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		
		String inputTime = sc.next();
		
		int hour = Integer.parseInt(inputTime.split(":")[0]);
		int minut = Integer.parseInt(inputTime.split(":")[1]);
		
		Time curTime = new Time(hour, minut);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Time> curList = new ArrayList<Time>();
		ArrayList<Time> nextList = new ArrayList<Time>();
		
		for(int i = 0; i < N; i++) {
			inputTime = sc.next();
			hour = Integer.parseInt(inputTime.split(":")[0]);
			minut = Integer.parseInt(inputTime.split(":")[1]);
			curList.add(new Time(hour, minut));
		}
		for(int i = 0; i < M; i++) {
			inputTime = sc.next();
			hour = Integer.parseInt(inputTime.split(":")[0]);
			minut = Integer.parseInt(inputTime.split(":")[1]);
			nextList.add(new Time(hour, minut));
		}
		Time endTime = new Time(24,59);
		for(int i = 0 ; i < curList.size(); i++) {
			if(curTime.hour <= curList.get(i).hour) {
				if(curTime.hour == curList.get(i).hour && curTime.minut > curList.get(i).minut) {
					continue;
				}
				int selectHour = curList.get(i).hour;
				int selectMinut = curList.get(i).minut;
				if(selectMinut+x >= 60) {
					selectHour++;
					selectMinut = selectMinut + x - 60;
				} else {
					selectMinut += x;
				}
				Time nextTime = new Time(selectHour, selectMinut);
				
				for(int j = 0; j < nextList.size(); j++) {
					if(nextTime.hour <= nextList.get(j).hour) {
						if(nextTime.hour == nextList.get(j).hour && nextTime.minut > nextList.get(j).minut) {
							continue;
						}
						selectHour = nextList.get(j).hour;
						selectMinut = nextList.get(j).minut;
						if(selectMinut+y >= 60) {
							selectHour++;
							selectMinut = selectMinut + y - 60;
						} else {
							selectMinut += y;
						}
						if(endTime.hour > selectHour) {
							endTime.hour = selectHour;
							endTime.minut = selectMinut;
						}
						if(endTime.hour == selectHour && endTime.minut > selectMinut) {
							endTime.hour = selectHour;
							endTime.minut = selectMinut;
						}
						
					}
				}
				
			}
		}
		
		System.out.println(endTime.hour + ":" + endTime.minut);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution1().solution();
	}

}

class Time {
	int hour;
	int minut;
	public Time(int h, int m) {
		this.hour = h;
		this.minut = m;
	}
}
