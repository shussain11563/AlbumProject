public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    //use a hashmap??? nvm, cant use instance variables
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
        //return NOT_FOUND;
    } //find the album index, or return NOT_FOUND

    private void grow()
    {


        if(albums == null)
            this.albums = new Album[4];
        else {
            Album[] oldAlbumsCollection = albums;
            this.albums = new Album[albums.length+4]; //4 is a magic number
        }

//        for(int i = 0; i < oldAlbumsCollection.length; i++)
//        {
//            //copy into ??
//            this.albums[i] = oldAlbumsCollection[i];
//        }

        //set the remaining to null?



        //we need to add an if/else if we use albums.length

    } //increase the capacity of the array list by 4

    public boolean add(Album album)
    {

        // change to numAlbums == this.album.length
        if(albums == null || numAlbums == this.albums.length)
        {
            grow();
        }

        this.albums[this.numAlbums] = album;
        //inserting album

        this.numAlbums++;

        return true;
        //return false in certain condition it fails??
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