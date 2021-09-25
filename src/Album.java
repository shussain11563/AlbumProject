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
     * @param artist the artist of
     * @param genre
     * @param releaseDate
     * @param isAvailable
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
    public String getTitle()
    {
        return this.title;
    }

    public String getArtist()
    {
        return this.artist;
    }

    public Genre getGenre() {
        return this.genre;
    }

    /**\
     *
     * @return
     */
    public Date getReleaseDate()
    {
        return this.releaseDate;
    }

    public boolean getAvailability()
    {
        return this.isAvailable;
    }

    /**
     *
     * @param isAvailable
     */
    public void setAvailable(boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }

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
        //might use helper method

        if(!(this.title.equals(album.title)) || !(this.artist.equals(album.artist))) {
            return isEqual;
        }

        isEqual = true;
        return isEqual;
    }
    @Override
    public String toString() {
        String availability = (this.isAvailable) ? "is available" : "is not available";
        return String.format("%s::%s::%s::%s::%s", this.title, this.artist, this.genre, this.releaseDate, availability);
    }

    public String removeToString() {
        return String.format("%s::%s >> deleted." , this.title, this.artist);
    }
}
