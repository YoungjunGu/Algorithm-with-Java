import java.util.*;

public class Solution {
	
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        for(int i = 0 ; i < phone_book.length; i++) {
        	for(int j = 0; j < phone_book.length; j++) {
        		if(i == j)
        			continue;
        		if(phone_book[i].startsWith(phone_book[j]))
        			return false;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
