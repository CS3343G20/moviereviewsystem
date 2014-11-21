package MovieReview;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlPanel.
 */
public class ControlPanel{
	
	/** The mydb. */
	private static Database mydb = new Database();
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		selectMovieOptions();
	}
	
	/**
	 * View movie names.
	 */
	public static void viewMovieNames() {

		System.out.println();
		System.out.println("====================");
		System.out.println("1. Browse movie list");
		System.out.println("====================");
			
		
		for (int i = 0; i < mydb.getMovieList().size(); i++) {
			Movie movie = mydb.getMovieList().get(i);
			System.out.println((i+1) + ". " + movie.getName());
		}
		
		System.out.println();
	}

	/**
	 * Select movie options.
	 */
	private static void selectMovieOptions() {
		Scanner optionscanner = new Scanner(System.in);
		int choice;

		System.out.println();
		System.out.println("===================");
		System.out.println("Movie Review System");
		System.out.println("===================");
		System.out.println("1. Browse movie list");
		System.out.println("2. Add a new movie");
		System.out.println();
		
		do {
			System.out.print("Please select a function: ");
			choice = optionscanner.nextInt();
			
			if (choice == 1) {
				viewMovieNames();
				selectMovie();
			} else if (choice == 2) {
				addMovie();
				selectMovieOptions();
			} else {
				System.out.println("Your input is invalid, please try again.");
			}
			
		} while (choice != 1 && choice != 2);

	}
	
	/**
	 * View movie info.
	 *
	 * @param mid the mid
	 */
	public static void viewMovieInfo(int mid) {	

		System.out.println();
		System.out.println("=========================");
		System.out.println("1. View movie information");
		System.out.println("=========================");
		
		for (int i = 0; i < mydb.getMovieList().size(); i++) {
			Movie movie = mydb.getMovieList().get(i);
			
			if(mid == movie.getMovieid()) {
				System.out.print(movie);
			}
		}
	}
	
	/**
	 * Adds the movie.
	 */
	public static void addMovie() {
		Scanner moviescanner = new Scanner(System.in);
		moviescanner.useDelimiter("\n");
		
		int movieid = mydb.getMovieList().size();
		String name;
		String year;
		String director;
		String actor;
		String description;
		
		System.out.println();
		System.out.println("==================");
		System.out.println("2. Add a new movie");
		System.out.println("==================");
		
		System.out.print("Name: ");
		name = moviescanner.nextLine();
		System.out.print("Year: ");
		year = moviescanner.nextLine();
		System.out.print("Director: ");
		director = moviescanner.nextLine();
		System.out.print("Actor: ");
		actor = moviescanner.nextLine();
		System.out.print("Description: ");
		description = moviescanner.nextLine();
		
		Movie movienew = new Movie(movieid, name, year, director, actor, description);
		mydb.addNewMovie(movienew);
		
		System.out.println("\nNew movie:");
		System.out.println(movienew);
		
	}
	
	/**
	 * View comment.
	 *
	 * @param mid the mid
	 */
	public static void viewComment(int mid) {

		System.out.println();
		System.out.println("================");
		System.out.println("2. View comments");
		System.out.println("================");

		for (int i = 0; i < mydb.getCommentList().size(); i++) {
			Comment comment = mydb.getCommentList().get(i);
			
			if(mid == comment.getMovieid()) {
				System.out.println(comment);
			}
		}
	}
	
	/**
	 * Post comment.
	 *
	 * @param mid the mid
	 */
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
		commentid = mydb.getCommentList().size();
		
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
		mydb.addNewComment(commentnew);
		
		System.out.println("\nNew comment:");
		System.out.println(commentnew);
	}
	
	/**
	 * Select movie.
	 */
	public static void selectMovie() {
		Scanner moviescanner = new Scanner(System.in);
		int totalmovieno = mydb.getMovieList().size();
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
	
	/**
	 * Select function.
	 *
	 * @param mid the mid
	 */
	public static void selectFunction(int mid) {
		Scanner functionscanner = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println();
			System.out.println("========");
			System.out.println("Function");
			System.out.println("========");
			System.out.println("1. View movie information");
			System.out.println("2. View comments");
			System.out.println("3. Post a comment");
			System.out.println("4. Back to movie list");
			System.out.println("5. Back to main menu");
			System.out.println();
			
			System.out.print("Please select a function: ");
			choice = functionscanner.nextInt();
			
			if (choice == 1) {
				viewMovieInfo(mid);
			} else if (choice == 2) {
				viewComment(mid);
			} else if (choice == 3) {
				postComment(mid);
			} else if (choice == 4) {
				viewMovieNames();
				selectMovie();
			} else if (choice == 5) {
				selectMovieOptions();
			} else {
				System.out.println("Your input is invalid, please try again.");
			}
			
		} while(choice != 5);
	}
}
