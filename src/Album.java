/**
 * @author Sharia Hussain, David Lam
 */

public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    /**
     *
     * @param title the title of the Album
     * @param artist the artist of the Album
     * @param genre the genre of the Album
     * @param releaseDate the release date of the Album
     * @param isAvailable the status of the Album's availability to lent out
     * @return
     */
    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;

    }
    //create setters/getters

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
     *
     * @param obj
     * @return true if an Album is equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj == this) {
            return true;
        }
        /*
        if (obj == null)
        {
            return false
         */

        Album album = (Album) obj;

        if(!(this.title.equals(album.title)) || !(this.artist.equals(album.artist))) {
            return isEqual;
        }

        isEqual = true;
        return isEqual;
    }

    /**
     * @return a textual representation of the Album's information
     */
    @Override
    public String toString() {
        String availability = (this.isAvailable) ? "is available" : "is not available";
        return String.format("%s::%s::%s::%s::%s", this.title, this.artist, this.genre, this.releaseDate, availability);
    }

    public String removeToString() {
        return String.format("%s::%s >> deleted." , this.title, this.artist);
    }
}
