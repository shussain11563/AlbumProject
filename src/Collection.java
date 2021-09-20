public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    private int find(Album album)
    {
        //might have to use album methods to check the album attributes
        //change i to something descriptive

        //we can always use a helper method to iterate because of remvoe
        for(int i = 0; i < this.numAlbums; i++)
        {
            //check if its not null
            if(this.albums[i] != null && this.albums[i].equals(album))
            {
                return i;
            }
        }
        return -1;
    }

    private void grow()
    {
        // check if the Albums[] is null, then inititates the starter array
        if(albums == null)
            this.albums = new Album[4];
        else {
            Album[] oldAlbumsCollection = albums;
            int oldAlbumsArrayLength = albums.length;
            this.albums = new Album[albums.length+4]; //4 is a magic number

            // Copy oldAlbum into bigger Albums[]
            for(int i = 0; i < oldAlbumsArrayLength; i++) {
                this.albums[i] = oldAlbumsCollection[i];
            }
        }

    } //increase the capacity of the array list by 4

    public boolean add(Album album)
    {
        //return false if the album already exists
        if(find(album) != -1)
            return false;
        // change to numAlbums == this.album.length
        if(albums == null || numAlbums == this.albums.length)
        {
            grow();
        }

        this.albums[this.numAlbums] = album;
        //inserting album

        this.numAlbums++;
        return true;
    }

    //
    private void shifting()
    {
        for(int i = 0; i < this.albums.length - 1; i++)
        {

            if(this.albums[i] == null)
            {
                this.albums[i] = this.albums[i+1];
            }
        }
    }


    public boolean remove(Album album)
    {
        boolean isRemoved = false;
        //use the same method we used in find
        int albumIndex = this.find(album);

        if(albumIndex >= 0)
        {
            this.albums[albumIndex] = null;
            this.numAlbums--;
            this.shifting();
            isRemoved = true;
        }

        return isRemoved;
    }


    public boolean lendingOut(Album album)
    {
        int albumIndex = this.find(album);

        return true;


        //if not available, set message to not available


    } //set to not available

    public boolean returnAlbum(Album album)
    {
        return false;
    } //set to available

    public void print()
    {
        System.out.println("*List of albums in the collection.");

        for(int i = 0; i < this.numAlbums; i++)
        {

            System.out.println(this.albums[i].toString());
        }
    } //display the list without specifying the order

    public void printByReleaseDate()
    {

    }

    public void printByGenre() {
    }


}