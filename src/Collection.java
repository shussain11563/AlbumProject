/**
 * @author Sharia Hussain, David Lam
 */
public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    public Collection()
    {
        this.numAlbums = 0;
        int initialCapacity = 4;
        this.albums = new Album[initialCapacity];
    }

    /**
     *
     * @param album
     * @return position of album in albums array, returns -1 if not found
     */
    private int find(Album album) {
        //change i to something descriptive
        //we can always use a helper method to iterate because of remove
        for(int i = 0; i < this.numAlbums; i++) {
            // check if its not null

            if(this.albums[i] != null && this.albums[i].getTitle().equals(album.getTitle()) && this.albums[i].getArtist().equals(album.getArtist())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Grows the albums array by 4.
     * grow() is called in add() when the album array is full.
     */
    private void grow() {
        // check if the Albums[] is null, then inititates the starter array
        int growthFactor = 4;
        Album[] oldAlbumsCollection = albums;
        int oldAlbumsArrayLength = albums.length;
        this.albums = new Album[albums.length+growthFactor]; //4 is a magic number

        // Copy oldAlbum into bigger Albums[]
        for(int i = 0; i < oldAlbumsArrayLength; i++) {
            this.albums[i] = oldAlbumsCollection[i];
        }
    } //increase the capacity of the array list by 4

    /**
     *
     * @param album
     * @return
     */
    public boolean add(Album album) {
        // return false if the album already exists
        if(find(album) >= 0) {
            return false;
        }

        // calls grow() to expand the albums array
        if(albums == null || numAlbums == this.albums.length) {
            grow();
        }

        // inserting album and incrementing count
        this.albums[this.numAlbums] = album;
        this.numAlbums++;
        return true;
    }

    /**
     *s T
     *
     */
    private void shifting() {
        for(int i = 0; i < this.albums.length - 1; i++) {
            if(this.albums[i] == null) {
                this.albums[i] = this.albums[i+1];
                this.albums[i+1] = null;
            }
        }
    }

    /**
     *
     * @param album
     * @return true is removing an album from the albums array is successful, returns false otherwise or if album is not found
     */
    public boolean remove(Album album)
    {
        boolean isRemoved = false;

        int albumIndex = this.find(album);

        if(albumIndex >= 0) {
            this.albums[albumIndex] = null;
            this.numAlbums--;
            this.shifting();
            isRemoved = true;
        }
        return isRemoved;
    }

    /**
     *
     * @param album
     * @return true if
     */
    public boolean lendingOut(Album album) {
        int albumIndex = this.find(album);

        if(albumIndex >=0 && this.albums[albumIndex].getAvailability()==true) {
            this.albums[albumIndex].setAvailable(false);
            return true;
        }
        else {
            return false; //not avaialble, already lended out
        }
        //if not available, set message to not available


    } //set to not available

    /**
     *
     * @param album
     * @return
     */
    public boolean returnAlbum(Album album) {
        int albumIndex = this.find(album);

        if(albumIndex >= 0 && this.albums[albumIndex].getAvailability() == false) {
            this.albums[albumIndex].setAvailable(true);
            return true;
        }
        else {
            return false; //not avaialble, already lended out
        }
    } //set to available

    /**
     * Prints each album's information in the albums array.
     */
    public void print() {
        if(numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        System.out.println("*List of albums in the collection.");

        for(int i = 0; i < this.numAlbums; i++) {

            System.out.println(this.albums[i].toString());
        }
        System.out.println("*End of list");
    }


    /**
     *
     */
    public void printByReleaseDate()
    {
        if(numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        System.out.println("*Album collection by the release dates.");

        Date[] dates = new Date[this.albums.length]; //assuming everything is set to null by default
        for(int i = 0; i < this.albums.length; i++) {

            if(this.albums[i] != null) {
                dates[i] = this.albums[i].getReleaseDate();
            }
        }
        insertionSort(dates, this.albums);

        for(int i = 0; i < this.numAlbums; i++) {
            System.out.println(this.albums[i].toString());
        }
        System.out.println("*End of list");
    }

    /**
     * Sorts and modifies the album array by Genre. Prints the modified array.
     */
    public void printByGenre() {
        if(numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        System.out.println("*Album collection by genre.");
        //Album[] copyOfAlbum = new Album[this.albums.length];
        Genre[] genres = new Genre[this.albums.length];
        for(int i = 0; i < this.albums.length; i++) {
            //copyOfAlbum[i] = this.albums[i];
            if(this.albums[i] != null) {
                genres[i] = this.albums[i].getGenre();
            }
        }

        insertionSort(genres, this.albums);
        for(int i = 0; i < this.numAlbums; i++) {
            System.out.println(this.albums[i].toString());
        }
        System.out.println("*End of list");

    }

    /**
     * Sorts the album array by
     *
     * @param arr
     * @param album
     * @param <T>
     */
    public <T extends Comparable<T>> void insertionSort(T[] arr, Album[] album) {
        for(int i = 0; i < album.length; i++) {
            T key = arr[i];
            Album keyPointer = album[i];
            int j = i-1;

            while(j>=0 && arr[j]!=null && key!=null && arr[j].compareTo(key)>0)
            {
                arr[j + 1] = arr[j];
                album[j + 1] = album[j];
                j = j - 1;
            }

            arr[j + 1] = key;
            album[j + 1] = keyPointer;
        }
    }
}