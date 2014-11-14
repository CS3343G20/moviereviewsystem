package MovieReview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Database {
	private int movieid;
	private int commentid;
	private static ArrayList<Movie> movielist = new ArrayList<Movie>();
	private static ArrayList<Comment> commentlist = new ArrayList<Comment>();
	private static KeyWord keyWordList = new KeyWord();
	
	public Database()  {
		try {
			readMovie();
			readComment();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readMovie() throws FileNotFoundException {
		File filename = new File("movie.txt");	
		Scanner scan = null;

		String name;
		String year;
		String director;
		String actor;
		String description;
		try {
			scan = new Scanner(filename);
			scan.useDelimiter("\t|\n");
			
			while (scan.hasNext()) {
				movieid = Integer.parseInt(scan.next());
				name = scan.next();
				year = scan.next();
				director = scan.next();
				actor = scan.next();
				description = scan.next();
				
				Movie m = new Movie(movieid , name, year, director, actor, description);
				movielist.add(m);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		scan.close();
	}
	
	public void readComment() throws FileNotFoundException {
		File filename = new File("comment.txt");	
		Scanner scan = null;
		
		String title;
		String author;
		String date;
		String comment;
		String rating = "";
		
		try {
			scan = new Scanner(filename);
			scan.useDelimiter("\t|\n");
			
			while(scan.hasNextLine()) {
				movieid = Integer.parseInt(scan.next());
				commentid = Integer.parseInt(scan.next());
				title = scan.next();
				author = scan.next();
				date = scan.next();
				comment = scan.next();
				rating = calCommentRating(comment);
				
				Comment c = new Comment(movieid, commentid, title, author, date, comment,rating);
				commentlist.add(c);
				
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		scan.close();
	}

	public static void storeCommentsToDB(int movieid, int commentid, String title, String author, String date, String comment){
		String comments = movieid + "\t" + commentid + "\t" + title + "\t" + author + "\t" + date + "\t" + comment;
		try {
			BufferedWriter bwriter = new BufferedWriter(new FileWriter("comment.txt", true));
			if(commentValidation(title) && commentValidation(author) && commentValidation(date) && commentValidation(comment)) { 
				bwriter.newLine();
				bwriter.write(comments);
			}
			else
				System.out.println("Fail: store the comments to database. Your input is not valid.");
			bwriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addNewComment(Comment commentnew){
		addToCommentList(commentnew);
		storeCommentsToDB(commentnew.getMovieid(),commentnew.getCommentid(),commentnew.getTitle(),commentnew.getAuthor(),commentnew.getDate(),commentnew.getComment());
	}
	
	private void addToCommentList(Comment newComment){
		 commentlist.add(newComment);
	}
	public static boolean commentValidation(String input){
		return (!input.contains("\t") && !(input.trim() == ""));
	}
	
	public ArrayList<Movie> getMovieList(){
		return movielist;
	}
	
	public ArrayList<Comment> getCommentList(){
		return commentlist;
	}
	
	private String calCommentRating(String comment){
		
		int pos = 0;
		int neg = 0;
		int neu = 0;
		Set<String> words = new HashSet<String>();
		String delims = "[ \t\n.,?!\"]+";
		String[] tokens = comment.split(delims);
		for (int i = 0; i < tokens.length; i++){
			if (!words.contains(tokens[i]))
				words.add(tokens[i]);
		}
		
		Iterator it = words.iterator();  
	    while (it.hasNext()){
	    	String word = ((String) it.next()).toLowerCase();
	    	
	    	if (keyWordList.getPositveKeyWord().contains(word)){
	    		pos++;
	    		
	    	}
	    	else if (keyWordList.getNegativeKeyWord().contains(word)){
	    		neg++;
	    		
	    	}
	    	else if (keyWordList.getNeutralKeyWord().contains(word)){
	    		neu++;
	    		
	    	}
	    }
	    
	   
	    if (pos+neg == 0)
	    	return "Neutral";
	    
	  	if (pos > neg)
	  		return "Positive";
	    
	    if (neg > pos)
	    	return "Negative";
	    
	    
	    return "Neutral";
	    
	}
}
