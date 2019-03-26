import java.util.*;
import java.io.*;

public class Main {
	
	
	public int[] solution(int[] array, int[][] commands) {
	
		int[] answer = new int[commands.length];
		int[] temp = {};
		for(int cnt = 0 ; cnt < commands.length; cnt++) {
			int i = commands[cnt][0];
			int j = commands[cnt][1];
			int k = commands[cnt][2];
			
			// 배열 복
			temp = Arrays.copyOfRange(array, i - 1, j);
			Arrays.sort(temp);
			
			answer[cnt] = temp[k - 1];
		}	
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int [][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		new Main().solution(array, commands);
	}

}
