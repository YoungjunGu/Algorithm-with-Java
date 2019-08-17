import java.util.*;

public class Solution2 {

	public void solution() {
		Scanner sc = new Scanner(System.in);
		int N;
		int K;
		String[] list = new String[101];
		N = sc.nextInt();
		K = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		String temp = Integer.toString(x);
		temp += Integer.toString(y);
		list[0] = temp;
		
		for(int i = 1; i < K; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			String chX = Integer.toString(x);
			String chY = Integer.toString(y);
			System.out.println(chX + " " + chY);
			int checkX = -1;
			int checkY = -1;
			for(int j = 0 ; j < list.length; j++) {
				String checkStr = list[j];
				if(checkStr.contains(chX)) 
					checkX = 1;
				if(checkStr.contains(chY))
					checkY = 1;
				if(checkX == 1 || checkY == 1) {
					if(checkX == -1) {
						checkStr += chX;
						list[j] += chX;
						break;
					}
					if(checkY == -1) {
						checkStr += chY;
						list[j] += chY;
						break;
					}
				}

			}
		}
		
		for(int i = 0 ; i < K; i++) {
			System.out.println(list[i]);
		}
	
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution2().solution();
	}

}
