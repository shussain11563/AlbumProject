/**
 * The Collection class is an arraylist data structure that contains albums.
 * This class contains methods that allow adding, deleting, sorting, lending, removing
 * and other manipulations of the arraylist.
 * @author Sharia Hussain, David Lam
 */
public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    /**
     * Constructs and initializes a Collection object.
     * Initializes an albums array with size of 4.
     */
    public Collection()
    {
        this.numAlbums = 0;
        int initialCapacity = 4;
        this.albums = new Album[initialCapacity];
    }

    /**
     * Finds an album within the Collection.
     * @param album the album to find within the Collection
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
     * Adds an album to the Collection and increases counter.
     * Grows an albums array to store more than the capacity of the albums array.
     * @param album the album to add to the Collection.
     * @return true if adding album was successful, false if album is already in Collection.
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
     * shifting() is called after a removal in album is done in remove().
     * Keeps the albums array contiguous with no gaps by shifting.
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
     * Removes a specified album from the albums array.
     * @param album the album to remove from the Collection.
     * @return true if removing an album from the albums array is successful, returns false otherwise.
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
     * Lends out an Album from the Collection.
     * @param album the album to lend out.
     * @return true if the album is available, false if the album is not available/already lended out.
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
     * Returns an album for lending in the Collection.
     * @param album the album to return.
     * @return true if the album is returning an album was successful, false otherwise.
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
     * Sorts and modifies the album array by release date from oldest to recent. Prints the modified array.
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
        Genre[] genres = new Genre[this.albums.length];
        for(int i = 0; i < this.albums.length; i++) {
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
     * Sorting algorithm to sort Collection based on a generic object.
     * Used to sort by release date and genre.
     * @param arr array which the sorting is applied
     * @param albums the album collection to sort.
     * @param <T> generic used to access generic's compareTo() function.
     */
    private <T extends Comparable<T>> void insertionSort(T[] arr, Album[] albums) {
        for(int i = 0; i < albums.length; i++) {
            T key = arr[i];
            Album keyPointer = albums[i];
            int j = i-1;

            while(j>=0 && arr[j]!=null && key!=null && arr[j].compareTo(key)>0)
            {
                arr[j + 1] = arr[j];
                albums[j + 1] = albums[j];
                j = j - 1;
            }

            arr[j + 1] = key;
            albums[j + 1] = keyPointer;
        }
    }
}