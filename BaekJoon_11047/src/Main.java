import java.io.*;
import java.util.*;


public class Main {
	
	static int cnt;
	static int[] bank = new int[10];
	static int money;
	static int ans;
	
	public static void solving( ) {
		int check;
		Scanner sc = new Scanner(System.in);
		
		cnt = sc.nextInt();
		money = sc.nextInt();
		
		for(int i = 0 ; i < cnt; i++) {
			bank[i] = sc.nextInt();
		}
		
		check = changeCoin(money);
		
		
		while(check != 0) {
			check = changeCoin(check);
		}
	
	
		System.out.println(ans);
		
	}
	
	public static int changeCoin(int coin) {
		int index = 1;
		
		if(bank[cnt - 1] <= coin)
		{
			ans += coin / bank[cnt - 1];
			
			return (int)(coin % bank[cnt - 1]);
		}
		for(int i = 0 ; i < cnt; i ++) {
			if(coin < bank[i]) {
				index = i - 1;
				break;
			}
		}
		
		ans += coin / bank[index];
		
		return (int)(coin % bank[index]);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main().solving();
	}

}
