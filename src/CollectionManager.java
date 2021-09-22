import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {

    /*
        tokenize commandLineInput and then call album constructor
        call collection functions for add, delete, etc

     */

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Boolean runProject = false;
        /*

        Date releaseDate = new Date("2/29/2021");
        Date currentDate = new Date();

        if(releaseDate.isValid() && releaseDate.compareTo(currentDate) <= 0) {
            System.out.println("Valid Date!");
        }
        else{
            System.out.println("Invalid Date!");
        }

        */

        // Create a single collection object for one single run
        Collection albumCollection = new Collection();

        while(scanner.hasNextLine()) {

            if(runProject == false) {
                System.out.println("Collection Manager starts running.");
                runProject = true;
            }


            String commandLineInput = scanner.nextLine();
            commandLineInput = commandLineInput.trim();

            if(commandLineInput.equals("P"))
                runDisplayCollection(albumCollection);
            else if(commandLineInput.equals("PD"))
                runDisplayCollectionByDate(albumCollection);
            else if(commandLineInput.equals("PG"))
                runDisplayCollectionByGenre(albumCollection);
            else if(commandLineInput.charAt(0) == 'A' && commandLineInput.charAt(1) == ',')
                runAddAlbum(commandLineInput, albumCollection);
            else if(commandLineInput.charAt(0) == 'D' && commandLineInput.charAt(1) == ',')
                runRemoveAlbum(commandLineInput, albumCollection);
            else if(commandLineInput.charAt(0) == 'L' && commandLineInput.charAt(1) == ',')
                runLendAlbum(commandLineInput);
            else if(commandLineInput.charAt(0) == 'R' && commandLineInput.charAt(1) == ',')
                runReturnAlbum(commandLineInput);
            else if(commandLineInput.equals("Q")) {
                System.out.println("Collection Manager terminated.");
                break;
            }
            else
                System.out.println("Invalid command!");
        }
    }

    public void runDisplayCollection(Collection albumCollection) {
        // Calls the NonStatic Method in Collection with the albumCollection parameter
        albumCollection.print();
    }
    public void runDisplayCollectionByDate(Collection albumCollection) {
        albumCollection.printByReleaseDate();

    }

    public void runDisplayCollectionByGenre(Collection albumCollection) {
        albumCollection.printByGenre();

    }

    // Check if date is valid
    public void runAddAlbum(String albumDetails, Collection albumCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");

        String title = "";
        String artist = "";
        String genre = "";
        String date = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();
        genre = stringTokenizer.nextToken();
        date = stringTokenizer.nextToken();

        // Checks if the string genre is one of the Genre's Enum Values, If not then set to Unknown
        if(!(genre.equals("pop") || genre.equals("country") || genre.equals("classical") || genre.equals("jazz"))) {
            genre = "Unknown";
        }

        Genre addGenre = Genre.valueOf(genre.substring(0, 1).toUpperCase() + genre.substring(1));

        Date releaseDate = new Date(date);
        Date currentDate = new Date();

        // Checks if the releaseDate from the commandLine is valid, and the releaseDate is <= to the currentDate
        if(releaseDate.isValid() && releaseDate.compareTo(currentDate) <= 0) {
            // Create a New Album Object to be added to Albums[]
            Album addNewAlbum = new Album(title, artist, addGenre, releaseDate, true);

            if(albumCollection.add(addNewAlbum))
                System.out.println(addNewAlbum.addToString() + " >> added.");
            else
                System.out.println(addNewAlbum.addToString() + " >> is already in the collection.");

        }
        else{
            System.out.println("Invalid Date!");
        }
    }

    public void runRemoveAlbum(String albumDetails, Collection albumCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");
        String title = "";
        String artist = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();

        Album tempAlbum = new Album(title, artist);

        if(albumCollection.remove(tempAlbum))
            System.out.println(tempAlbum.removeToString());
        else
            System.out.println("Album does not exist.");


    }

    public void runLendAlbum(String albumDetails) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");
        String title = "";
        String artist = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();

        //find the album
        //then check lending

    }

    public void runReturnAlbum(String albumDetails) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");
        String title = "";
        String artist = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();
    }
}
