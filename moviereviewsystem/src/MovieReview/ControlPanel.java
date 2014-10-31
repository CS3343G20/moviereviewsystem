package MovieReview;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ControlPanel{
	private static ArrayList<Movie> movielist = new ArrayList<Movie>();
	private static ArrayList<Comment> commentlist = new ArrayList<Comment>();
	private static Database mydb = new Database(movielist, commentlist);
	private static KeyWord keyWordList = new KeyWord();
	
	public static void main(String[] args) throws FileNotFoundException {
		viewMovieNames();
		selectMovie();
	}

	public static void viewMovieNames() {
		System.out.println("======");
		System.out.println("Movies");
		System.out.println("======");
		
		for (int i = 0; i < movielist.size(); i++) {
			Movie movie = movielist.get(i);
			System.out.println((i+1) + ". " + movie.getName());
		}

		System.out.println();
	}
	
	public static void viewMovieInfo(int mid) {	
		System.out.println("=========================");
		System.out.println("1. View movie information");
		System.out.println("=========================");
		
		for (int i = 0; i < movielist.size(); i++) {
			Movie movie = movielist.get(i);
			
			if(mid == movie.getMovieid()) {
				System.out.print(movie);
			}
		}
	}
	
	public static void viewComment(int mid) {
		System.out.println("================");
		System.out.println("2. View comments");
		System.out.println("================");
		
		for (int i = 0; i < commentlist.size(); i++) {
			Comment comment = commentlist.get(i);
			
			if(mid == comment.getMovieid()) {
				System.out.println(comment);
			}
		}
	}
	
	public static void postComment(int mid) {
		Scanner commentscanner = new Scanner(System.in);
		commentscanner.useDelimiter("\n");
		
		int movieid;
		int commentid;
		String title;
		String author;
		String date;
		String comment;
		
		System.out.println("=================");
		System.out.println("3. Post a comment");
		System.out.println("=================");
		
		movieid = mid;
		
		//to be modified
		commentid = 1;
		
		System.out.print("Author: ");
		author = commentscanner.nextLine();
		System.out.print("Title: ");
		title = commentscanner.nextLine();
		System.out.print("Comment: ");
		comment = commentscanner.nextLine();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date currentdate = new Date();
		date = dateFormat.format(currentdate);
		
		Comment commentnew = new Comment(movieid, commentid, title, author, date, comment);
		commentlist.add(commentnew);
		
		System.out.println("\nNew comment:");
		System.out.println(commentnew);
		
		//Store to DB
		mydb.storeCommentsToDB(mid, commentid, title, author, date, comment);
		
	//	commentscanner.close();
		
	}
	
	public static void selectMovie() {
		Scanner moviescanner = new Scanner(System.in);
		int totalmovieno = movielist.size();
		int movienum;
		int mid; 
		
		do {
			System.out.print("Please select a movie: ");

			movienum = moviescanner.nextInt();
			mid = movienum-1;
			
			if (movienum > totalmovieno) {
				System.out.println("Your input is invalid, please try again.");
			}
			
		} while(movienum > totalmovieno);
		
		selectFunction(mid);
		
		moviescanner.close();	
	}
	
	public static void selectFunction(int mid) {
		Scanner functionscanner = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println();
			System.out.println("=========");
			System.out.println("Function");
			System.out.println("=========");
			System.out.println("1. View movie information");
			System.out.println("2. View comments");
			System.out.println("3. Post a comment");
			System.out.println("4. Back to main menu");
			System.out.println();
			
			System.out.print("Please select a function: ");
			choice = functionscanner.nextInt();
			
			System.out.println();
			
			if (choice == 1) {
				viewMovieInfo(mid);
			} else if (choice == 2) {
				viewComment(mid);
			} else if (choice == 3) {
				postComment(mid);
			} else if (choice == 4) {
				viewMovieNames();
				selectMovie();
			} else {
				System.out.println("Your input is invalid, please try again.");
			}
			
		} while(choice != 4);
		
		functionscanner.close();
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
}
