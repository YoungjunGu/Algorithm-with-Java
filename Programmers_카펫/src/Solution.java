import java.util.*;

public class Solution {
	
    public int[] solution(int brown, int red) {
        int[] answer = {};
        int depth = brown+red;
        ArrayList<Color> list = new ArrayList<>();
        
        for(int i = 1; i <= depth; i++) {
        	if(depth % i == 0) {
        		if (i > depth / i)
        			list.add(new Color(i, depth / i));
        		else
        			list.add(new Color(depth / i, i));
        	}
        }
        int h = 0,v = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < list.size(); i++) {
        	if(list.get(i).h - list.get(i).v < min) {
        		min = list.get(i).h - list.get(i).v;
        		h = list.get(i).h;
        		v = list.get(i).v;
        	}     		
        }
        
        answer = new int[2];
        answer[0] = h;
        answer[1] = v;
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int red = 2;
		int brown = 10;
		
		new Solution().solution(brown, red);

	}

}


class Color {
	int h;
	int v;
	public Color(int h, int v) {
		this.h = h;
		this.v = v;
	}
}