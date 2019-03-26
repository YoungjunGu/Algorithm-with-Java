import java.util.*;
import java.io.*;

public class Main {
	
	public static String solutions(String[] participants, String[] completion) {
		int i = 0;
		Arrays.sort(participants);
		Arrays.sort(completion);
		
		for(i = 0 ; i < completion.length; i++) {
			if(!participants[i].equals(completion[i])) {
				return participants[i];
			}
		}
		return participants[i];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
