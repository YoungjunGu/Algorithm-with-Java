import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
 
        for(int i = 0 ; i < A.length; i++) {
        	answer += A[i] * B[A.length - i -1];
        }
        return answer;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,4,2};
		int[] B = {5,4,4};
		new Solution().solution(A, B);
	}

}
