public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable)
    {
        //do string parsing here?? or driver??

        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;

    }

    public Album(String title, String artist)
    {
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

    public Date getReleaseDate()
    {
        return this.releaseDate;
    }

    public boolean getAvailability()
    {
        return this.isAvailable;
    }

    public boolean equals(Album album) {
        boolean isEqual = false;

        /*
        if (album == this)
        {
            return true;
        }

        if (obj == null)
        {
            return false
         */

        //might use helper method
        if(!(this.title.equals(album.title)) && !(this.artist.equals(album.artist)) && !(this.genre.equals(album.genre)) && (this.releaseDate.compareTo(album.releaseDate)) != 0)
        {
            return isEqual;
        }

        isEqual = true;
        return isEqual;
    }

    @Override
    public String toString()
    {
        String availability = "";


        if(this.isAvailable == true)
        {
            availability = "is available"
        }
        else
        {
            availability = "is not available";
        }

        String isAvailableTextualRepresentation = "";
        return this.title + "::" + this.artist + "::" + this.genre + "::" + this.releaseDate.toString() + "::" + "is available";
        //use getters/setters
        //convert genre, date, .toString??
        String albumTextualRepresentation =  String.format("%s::%s::%s::%s::%s", this.title, this.artist, this.genre, this.date, availability);
    }

    public String removeToString() {
        //Famous Friends::Chris Young >> deleted.
        return this.title + "::" + this.artist + " >> " + "deleted.";
    }
}
