package MovieReview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
	private int movieid;
	private int commentid;
	private String title;
	private String author;
	private String date;
	private String comment;
	private String name;
	private String year;
	private String director;
	private String actor;
	private String description;
	
	public Database(ArrayList<Movie> movielist, ArrayList<Comment> commentlist)  {
		try {
			readMovie(movielist);
			readComment(commentlist);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readMovie(ArrayList<Movie> movielist) throws FileNotFoundException {
		File filename = new File("movie.txt");	
		Scanner scan = null;
		
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
	
	public void readComment(ArrayList<Comment> commentlist) throws FileNotFoundException {
		File filename = new File("comment.txt");	
		Scanner scan = null;
		
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
				
				Comment c = new Comment(movieid, commentid, title, author, date, comment);
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
	
	public static boolean commentValidation(String input){
		return (!input.contains("\t") && !(input.trim() == ""));
	}
}
