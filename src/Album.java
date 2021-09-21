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

    public void setAvailable(boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean isEqual = false;
        if (obj == this)
        {
            return true;
        }
        /*
        if (obj == null)
        {
            return false
         */

        Album album = (Album) obj;
        //might use helper method
        if(!(this.title.equals(album.title)))
        {
            return isEqual;
        }

        if(!(this.artist.equals(album.artist)))
        {
            return isEqual;
        }

        if(!(this.genre.equals(album.artist)))
        {
            return isEqual;
        }

        if(!(this.releaseDate.equals(album.releaseDate)))
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
            availability = "is available";
        }
        else
        {
            availability = "is not available";
        }

        return String.format("%s::%s::%s::%s::%s", this.title, this.artist, this.genre, this.releaseDate, availability);
    }

    public String removeToString() {
        //Famous Friends::Chris Young >> deleted.
        return this.title + "::" + this.artist + " >> " + "deleted.";
    }
}
