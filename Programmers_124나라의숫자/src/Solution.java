import java.util.*;

public class Solution {

	public String solution(int n) {
		String answer = "";

		int mod = n;
		int div = n;
		int end = 0;
		while (end != 1) {
			if(div <= 3) {
				end = 1;
			}
			mod = div % 3;
			div = div / 3;
			if (mod == 1)
				answer = "1" + answer;
			else if (mod == 2)
				answer = "2" + answer;
			else {
				answer = "4" + answer;
				div -= 1;
			}

		}
		System.out.print(answer);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Solution().solution(300);
	}

}

//다른 풀이
/*
String answer = "";
int rmd;

while(n>0){
    rmd = n%3;
    n = n/3;

    if(rmd == 0){
        n -= 1;
        rmd = 4;
    }

    answer = rmd + answer;
}

return answer;
*/