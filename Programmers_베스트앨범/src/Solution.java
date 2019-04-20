import java.util.*;

public class Solution {

	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		ArrayList<Album> album = new ArrayList<Album>();
		
		for(int i = 0; i < plays.length; i++) {
			album.add(new Album(genres[i], plays[i], i));
		}
		
		Collections.sort(album, new Comparator<Album>() {

			@Override
			public int compare(Album o1, Album o2) {
				// TODO Auto-generated method stub
				if(o1.genre.compareTo(o2.genre) < 0) {
					return -1;
				} else if(o1.genre.compareTo(o2.genre) == 0) {
					if(o1.amount > o2.amount) {
						return -1;
					} else {
						return 1;
					}
				}
				else {
					return 1;
				}
			}
		});
		
		ArrayList<Album> best = new ArrayList<Album>();
		String curGenre = album.get(0).genre;
		best.add(album.get(0));
		int check = 1;
		for(int i = 1; i < album.size(); i++) {
			if(check == 2) {
				check = 0;
			}
			else if(curGenre.equals(album.get(i).genre)) {
				best.add(album.get(i));
				check++;
			}
			else {
				curGenre = album.get(i).genre;
				best.add(album.get(i));
			}
			
		}
		
		/*
		HashMap<String, PriorityQueue<Album>> best = new HashMap<String, PriorityQueue<Album>>();
		for(int i = 0 ; i < album.size(); i++) {
			// 해당 키를 포함하고 있으면 
			if(best.containsKey(album.get(i).genre)) {
				best.get(album.get(i).genre).add(album.get(i));
			} else {
				best.put(album.get(i).genre, new PriorityQueue<Album>());
				best.get(album.get(i).genre).add(album.get(i));
			}
		}
		
		ArrayList<Album> list = new ArrayList<Album>();
		*/
		
		for(int i = 0; i < best.size(); i++) {
			System.out.println(best.get(i).genre + " " + best.get(i).amount + " " + best.get(i).index);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"classic", "pop", "classic", "classic", "pop", "hip", "classic", "hip"};
		int[] plays = {500, 600, 150, 800, 2500, 3000, 4000, 100};
		new Solution().solution(genres, plays);
	}

}

class Album {
	String genre;
	int amount;
	int index;
	public Album(String genre, int amount, int index) {
		this.genre = genre;
		this.amount = amount;
		this.index = index;
	}
	
}
