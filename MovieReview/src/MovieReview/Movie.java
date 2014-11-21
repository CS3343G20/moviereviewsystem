package MovieReview;

// TODO: Auto-generated Javadoc
/**
 * The Class Movie.
 */
public class Movie {
	
	/** The movieid. */
	private int movieid;
	
	/** The name. */
	private String name;
	
	/** The year. */
	private String year;
	
	/** The director. */
	private String director;
	
	/** The actor. */
	private String actor;
	
	/** The description. */
	private String description;
	
	/**
	 * Instantiates a new movie.
	 */
	public Movie() {
		movieid = 0;
		name = "";
		year = "";
		director = "";
		actor = "";
		description = "";
	}
	
	/**
	 * Instantiates a new movie.
	 *
	 * @param movieid the movieid
	 * @param name the name
	 * @param year the year
	 * @param director the director
	 * @param actor the actor
	 * @param description the description
	 */
	public Movie(int movieid, String name, String year, String director, String actor, String description) {
		this.movieid = movieid;
		this.name = name;
		this.year = year;
		this.director = director;
		this.actor = actor;
		this.description = description;
	}
	
	/**
	 * Gets the movieid.
	 *
	 * @return the movieid
	 */
	public int getMovieid() {
		return movieid;
	}

	/**
	 * Sets the movieid.
	 *
	 * @param movieid the new movieid
	 */
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Gets the director.
	 *
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Sets the director.
	 *
	 * @param director the new director
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * Gets the actor.
	 *
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}

	/**
	 * Sets the actor.
	 *
	 * @param actor the new actor
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Name: " + name + "\nYear: " + year + "\nDirector: " + director + "\nActor: " + actor + "\nDescription: " + description + "\n";
	}
}
