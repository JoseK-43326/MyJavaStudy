import java.util.*;
import java.io.*;

public class Compare{
	ArrayList<Song> songList = new ArrayList<Song>();
	class Song implements Comparator<Song>{
		String title;
		String artist;
		String rating;
		String bpm;
		Song(String t, String a, String r, String b){
			title = t;
			artist = a;
			rating = r;
			bpm = b;
			}
		public String getTitle(){
			return title;
			}
		public String getArtist(){
			return artist;
			}
		public String getRating(){
			return rating;
			}
		public String getBpm(){
			return bpm;
			}
		public int compare(Song one, Song two){
			return one.getArtist.compareTo(two.getArtist());
			}
		}
	public static void main(String[] args){
		Compare compare = new Compare();
		compare.go();
		}
		
	public void go(){
		
		}
		
		
	
	}