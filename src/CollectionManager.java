/**
 * CollectionManager is a user interface class that handles I/O with Collection
 * and Album. Contains an initialized Collection ready to manipulate Album objects.
 * @author Sharia Hussain, David Lam
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {
    /**
     * Method that is called by the RunProject1 driver and starts the Collection Manager.
     * Initializes Collection object and takes input from console to perform actions.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Boolean runProject = false;
        Collection albumCollection = new Collection();

        while(scanner.hasNextLine()) {
            if(runProject == false) {
                System.out.println("Collection Manager starts running.");
                runProject = true;
            }

            String commandLineInput = scanner.nextLine();
            commandLineInput = commandLineInput.trim();

            if(commandLineInput.equals(""))
                continue;
            else if(commandLineInput.equals("P"))
                albumCollection.print();
            else if(commandLineInput.equals("PD"))
                albumCollection.printByReleaseDate();
            else if(commandLineInput.equals("PG"))
                albumCollection.printByGenre();
            else if(commandLineInput.charAt(0) == 'A' && commandLineInput.charAt(1) == ',')
                runAddAlbum(commandLineInput, albumCollection);
            else if(commandLineInput.charAt(0) == 'D' && commandLineInput.charAt(1) == ',')
                runRemoveAlbum(commandLineInput, albumCollection);
            else if(commandLineInput.charAt(0) == 'L' && commandLineInput.charAt(1) == ',')
                runLendAlbum(commandLineInput, albumCollection);
            else if(commandLineInput.charAt(0) == 'R' && commandLineInput.charAt(1) == ',')
                runReturnAlbum(commandLineInput, albumCollection);
            else if(commandLineInput.equals("Q")) {
                System.out.println("Collection Manager terminated.");
                break;
            } else
                System.out.println("Invalid command!");
        }
    }

    /**
     * Method that tokenizes the album string and runs the add method in the Collection Class
     * The method also checks the genre with the enum values and also validates the date in the
     * given string.
     */
    public void runAddAlbum(String albumDetails, Collection albumCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");

        String title, artist, genre, date = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();
        genre = stringTokenizer.nextToken().toLowerCase();
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
                System.out.println(addNewAlbum.toString() + " >> added.");
            else
                System.out.println(addNewAlbum.toString() + " >> is already in the collection.");

        }
        else{
            System.out.println("Invalid Date!");
        }
    }

    /**
     * Method that tokenizes the album string and runs the remove method in the Collection Class.
     */
    public void runRemoveAlbum(String albumDetails, Collection albumCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");
        String title, artist = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();

        Album tempAlbum = new Album(title, artist);

        if(albumCollection.remove(tempAlbum))
            System.out.println(tempAlbum.removeToString());
        else
            System.out.println(String.format("%s::%s >> is not in the collection.", tempAlbum.getTitle(), tempAlbum.getArtist()));
    }

    /**
     * Method that tokenizes the album string and runs the lendingOut method in the Collection Class.
     */
    public void runLendAlbum(String albumDetails, Collection albumCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");
        String title, artist = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();

        Album tempAlbum = new Album(title, artist);

        String message = "";
        if(albumCollection.lendingOut(tempAlbum))
            System.out.println(String.format("%s::%s >> lending out and set to not available.", tempAlbum.getTitle(), tempAlbum.getArtist()));
        else
            System.out.println(String.format("%s::%s >> is not available.", tempAlbum.getTitle(), tempAlbum.getArtist()));
    }

    /**
     * Method that tokenizes the album string and runs the returnAlbum method in the Collection Class.
     */
    public void runReturnAlbum(String albumDetails, Collection albumCollection) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");
        String title, artist = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();

        Album tempAlbum = new Album(title, artist);

        String message = "";
        if(albumCollection.returnAlbum(tempAlbum))
            System.out.println(String.format("%s::%s >> returning and set to available.", tempAlbum.getTitle(), tempAlbum.getArtist()));
        else
            System.out.println(String.format("%s::%s >> return cannot be completed.", tempAlbum.getTitle(), tempAlbum.getArtist()));
    }
}
