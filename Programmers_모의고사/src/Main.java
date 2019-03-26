import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] solution(int[] answers) {	
		
		int[][] list = {{1,2,3,4,5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
		
		
		int max = Integer.MIN_VALUE;
		int who = 0;
		
		int[] hitList = new int[3];
		
		for(int n = 0 ; n < 3; n++) {
			int hit = 0;
			for(int i = 0 ; i < answers.length; i++) {
				if((list[n][i % list[n].length]) == answers[i]) {
					hit ++;
				}
			}
			hitList[n] = hit;
		}
		ArrayList<Integer> whoList = new ArrayList<>();
		max = Math.max(hitList[0], Math.max(hitList[1], hitList[2]));
		
		for(int i = 0; i < 3; i++) {
			if(max == hitList[i]) {
				whoList.add(i);
			}
		}
		
		int[] answer = new int[whoList.size()];
		
		for(int i = 0 ; i < whoList.size(); i++) {
			answer[i] = whoList.get(i) + 1;
		}
		
		for(int i = 0 ; i < whoList.size(); i++) {
			System.out.print(answer[i] + " ");
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answers = {1,2,3,4,5};
		
		new Main().solution(answers);
		

	}

}
