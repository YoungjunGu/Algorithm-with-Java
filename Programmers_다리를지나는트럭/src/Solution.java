import java.util.*;

public class Solution {

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int totalWeight = 0;

		Queue<Truck> initq = new LinkedList<>();
		Queue<Truck> tq = new LinkedList<>();

		Truck[] truck = new Truck[truck_weights.length];

		for (int i = 0; i < truck_weights.length; i++) {
			truck[i] = new Truck(bridge_length, truck_weights[i]);
			initq.offer(truck[i]);
		}

		totalWeight += initq.peek().weight;
		tq.offer(initq.poll());

		while (!(tq.isEmpty()&& initq.isEmpty())) {
			
			for (Truck t : tq) {
				t.time--;
			}

			// 맨 앞 부분이 0보다 작다는말은 다리를 건넜다는 말
			if (tq.peek().time < 0) {
				totalWeight -= tq.poll().weight;
			}

			if (!initq.isEmpty() && totalWeight + initq.peek().weight <= weight) {
				totalWeight += initq.peek().weight;
				tq.offer(initq.poll());
			}

			answer++;
			System.out.println(answer);

		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b = 2;
		int w = 10;
		
		int[] arr = {7,4,5,6};

		new Solution().solution(b, w, arr);
	}

}

class Truck {
	int time;
	int weight;

	public Truck(int time, int weight) {
		this.time = time;
		this.weight = weight;
	}
}
