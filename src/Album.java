public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable)
    {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;

    }

    public boolean equals(Album album)
    {
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
        if(!(this.title.equals(album.title)))
        {
            return isEqual;
        }

        if(!(this.artist.equals(album.artist)))
        {
            return isEqual;
        }

        if(!(this.genre.equals(album.genre)))
        {
            return isEqual;
        }

        if((this.releaseDate.compareTo(album.releaseDate)) != 0)
        {
            return isEqual;
        }

        isEqual = true;
        return isEqual;
    }

    // NEED TO ADD **DATE** TO THE TO STRING
    @Override
    public String toString()
    {

        String isAvailableTextualRepresentation = "";
        return this.title + "::" + this.artist + "::" + this.genre + "::" + "is available";
        //convert genre, date, .toString??
        //String albumTextualRepresentation =  String.format("%s::%s::%s::%s::%s", this.title, this.artist, this.genre.toString(), this.date.toString(), status);
    }
}
