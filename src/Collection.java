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

    public boolean add(Album album) {
        //return false if the album already exists
        if(find(album) >= 0) {
            return false;
        }

        // change to numAlbums == this.album.length
        if(albums == null || numAlbums == this.albums.length) {
            grow();
        }

        this.albums[this.numAlbums] = album;
        //inserting album
        this.numAlbums++;
        return true;
    }

    private void shifting() {
        for(int i = 0; i < this.albums.length - 1; i++) {
            if(this.albums[i] == null) {
                this.albums[i] = this.albums[i+1];
                this.albums[i+1] = null;
            }
        }
    }

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

    public boolean lendingOut(Album album) {
        int albumIndex = this.find(album);

        if(albumIndex >=0 && album.getAvailability()==true) {
            this.albums[albumIndex].setAvailable(false);
            return true;
        }
        else {
            return false; //not avaialble, already lended out
        }
        //if not available, set message to not available


    } //set to not available

    public boolean returnAlbum(Album album) {
        int albumIndex = this.find(album);

        if(albumIndex >= 0 && album.getAvailability() == false) {
            this.albums[albumIndex].setAvailable(true);
            return true;
        }
        else {
            return false; //not avaialble, already lended out
        }
    } //set to available

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


    public void printByReleaseDate()
    {
        if(numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        System.out.println("*Album collection by the release dates.");

        Album[] copyOfAlbum = new Album[this.albums.length];
        Date[] dates = new Date[this.albums.length]; //assuming everything is set to null by default
        for(int i = 0; i < this.albums.length; i++) {
            copyOfAlbum[i] = this.albums[i];
            if(this.albums[i] != null) {
                dates[i] = this.albums[i].getReleaseDate();
            }
        }
        insertionSort(dates, copyOfAlbum);

        for(int i = 0; i < this.numAlbums; i++) {
            System.out.println(copyOfAlbum[i].toString());
        }
        System.out.println("*End of list");
    }

    public void printByGenre() {
        if(numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        System.out.println("*Album collection by genre.");
        Album[] copyOfAlbum = new Album[this.albums.length];
        Genre[] genres = new Genre[this.albums.length];
        for(int i = 0; i < this.albums.length; i++) {
            copyOfAlbum[i] = this.albums[i];
            if(this.albums[i] != null) {
                genres[i] = this.albums[i].getGenre();
            }
        }

        insertionSort(genres, copyOfAlbum);
        for(int i = 0; i < this.numAlbums; i++) {
            System.out.println(copyOfAlbum[i].toString());
        }
        System.out.println("*End of list");

    }

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