/**
 * The Album class acts as a blueprint for an Album object
 * which contains attributes such as title, artist,
 * genre, release date, and availability.
 * This class also contains methods to allow
 * album objects to have representations such as how they are equal.
 * @author Sharia Hussain, David Lam
 */

public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    /**
     * Constructs and initializes an Album object.
     * Initializes title, artist, genre, release date, availability.
     * @param title the title of the Album.
     * @param artist the artist of the Album.
     * @param genre the genre of the Album.
     * @param releaseDate the release date of the Album.
     * @param isAvailable the status of the Album's availability to be lent out.
     */
    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
    }

    /**
     * Constructs and initializes an Album object for temporary use.
     * Used for lending, removing, and returning an Album.
     * @param title the title of the Album.
     * @param artist the artist of the Album.
     */
    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    /**
     * Retrieves the title of the Album.
     * @return the title of the album.
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Retrieves the name of the artist of the Album.
     * @return the name of the artist of the album.
     */
    public String getArtist()
    {
        return this.artist;
    }

    /**
     * Retrieves the Genre of the Album.
     * @return the Genre type of the album.
     */
    public Genre getGenre() {
        return this.genre;
    }

    /**
     * Retrieves the release date of the Album.
     * @return the release date of the album.
     */
    public Date getReleaseDate()
    {
        return this.releaseDate;
    }

    /**
     * Retrieves the availability of the album for lending.
     * @return the availability of the album for lending.
     */
    public boolean getAvailability()
    {
        return this.isAvailable;
    }

    /**
     * Changes the availability of the Album.
     * @param isAvailable the status of the availability of Album to change to
     */
    public void setAvailable(boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }

    /**
     * Overridden equals method that allows Album objects to be compared.
     * @param obj the object to compare with.
     * @return true if an Album is equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj == this) {
            return true;
        }

        Album album = (Album) obj;

        if(!(this.title.equals(album.title)) || !(this.artist.equals(album.artist))) {
            return isEqual;
        }

        isEqual = true;
        return isEqual;
    }

    /**
     * Overrides toString method to represent Album objects.
     * @return a textual representation of the Album's information
     */
    @Override
    public String toString() {
        String availability = (this.isAvailable) ? "is available" : "is not available";
        return String.format("%s::%s::%s::%s::%s", this.title, this.artist, this.genre, this.releaseDate, availability);
    }

    /**
     * Method that returns a formatted String of the album being deleted.
     * @return a textual representation of the deleted Album's information
     */
    public String removeToString() {
        return String.format("%s::%s >> deleted." , this.title, this.artist);
    }
}
