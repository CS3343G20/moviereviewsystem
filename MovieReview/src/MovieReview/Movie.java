package MovieReview;

public class Movie {
	private int movieid;
	private String name;
	private String year;
	private String director;
	private String actor;
	private String description;
	
	public Movie() {
		movieid = 0;
		name = "";
		year = "";
		director = "";
		actor = "";
		description = "";
	}
	
	public Movie(int movieid, String name, String year, String director, String actor, String description) {
		this.movieid = movieid;
		this.name = name;
		this.year = year;
		this.director = director;
		this.actor = actor;
		this.description = description;
	}
	
	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return "Name: " + name + "\nYear: " + year + "\nDirector: " + director + "\nActor: " + actor + "\nDescription: " + description + "\n";
	}
}
