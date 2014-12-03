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
	
	/** The my scanner. */
	private static Scanner myScanner = new Scanner(System.in);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		selectMovieOptions(null);
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
	 *
	 * @param sc the sc
	 */
	private static void selectMovieOptions(Scanner sc) {
		Scanner optionscanner;
		if(sc == null)
			optionscanner = new Scanner(System.in);
		else 
			optionscanner = sc;
		String choice;

		System.out.println();
		System.out.println("===================");
		System.out.println("Movie Review System");
		System.out.println("===================");
		System.out.println("1. Browse movie list");
		System.out.println("2. Add a new movie");
		System.out.println("3. Exit");
		System.out.println();
		
		do {
			System.out.print("Please select a function: ");
			choice = optionscanner.nextLine();
			
			if (choice.equals("1")) {
				viewMovieNames();
				selectMovie(optionscanner);
			} else if (choice.equals("2")) {
				addMovie(optionscanner);
				selectMovieOptions(optionscanner);
			} else if (choice.equals("3")) {
				optionscanner.close();
				break;
			} else {
				System.out.println("Your input is invalid, please try again.");
			}
			
		} while (!choice.equals("1") && !choice.equals("2"));

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
	 *
	 * @param sc the sc
	 */
	public static void addMovie(Scanner sc) {
		Scanner moviescanner = new Scanner(System.in);
		if(sc == null)
			moviescanner = new Scanner(System.in);
		else 
			moviescanner = sc;
		
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
	 * @param sc the sc
	 */
	public static void postComment(int mid, Scanner sc) {
		Scanner commentscanner;
		if(sc == null)
			commentscanner = new Scanner(System.in);
		else 
			commentscanner = sc;
		
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
		
		if (author.length() != 0 && title.length() != 0 && comment.length() != 0) {
			Comment commentnew = new Comment(movieid, commentid, title, author, date, comment);
			mydb.addNewComment(commentnew);
			
			System.out.println("\nNew comment:");
			System.out.println(commentnew);
		} else {
			System.out.println("Error: Invalid comment. Your comment will not be posted.");
		}
	}
	
	/**
	 * Select movie.
	 *
	 * @param sc the sc
	 */
	public static void selectMovie(Scanner sc) {
		
		Scanner moviescanner = new Scanner(System.in);	
		if(sc == null)
			moviescanner = new Scanner(System.in);
		else 
			moviescanner = sc;
		int totalmovieno = mydb.getMovieList().size();
		int movienum;
		int mid;
		
		do {	
			System.out.println("Press 0 to exit");
			System.out.print("Please select a movie: ");
			String reader = moviescanner.nextLine();
			try{
				movienum = Integer.parseInt(reader);
				mid = movienum-1;
			}catch(Exception e){
				mid = -100;
			}	

			if (mid >= 0 && mid < totalmovieno) {
				selectFunction(mid,moviescanner);
			} else if (mid == -1){
				break;
			} else {
				System.out.println("Your input is invalid, please try again.");
			}
		} while (!(mid >= 0 && mid < totalmovieno));
	}
	
	/**
	 * Select function.
	 *
	 * @param mid the mid
	 * @param sc the sc
	 */
	public static void selectFunction(int mid, Scanner sc) {
		Scanner functionscanner;	
		if(sc == null)
			functionscanner = new Scanner(System.in);
		else 
			functionscanner = sc;
		
		String choice;
		
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
			System.out.println("6. Exit");
			System.out.println();
			
			System.out.print("Please select a function: ");
			choice = functionscanner.nextLine();
			
			if (choice.equals("1")) {
				viewMovieInfo(mid);
			} else if (choice.equals("2")) {
				viewComment(mid);
			} else if (choice.equals("3")) {
				postComment(mid, functionscanner);
			} else if (choice.equals("4")) {
				viewMovieNames();
				selectMovie(functionscanner);
			} else if (choice.equals("5")) {
				selectMovieOptions(functionscanner);
			} else if (choice.equals("6")) {
				break;
			} else {

				System.out.println("Your input is invalid, please try again.");
			}
			
		} while(!choice.equals("5"));
	}
}
