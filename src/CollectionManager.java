import java.util.Scanner;
import java.util.StringTokenizer;

public class CollectionManager {

    /*
        tokenize commandLineInput and then call album constructor
        call collection functions for add, delete, etc

     */

    public void run() {
        System.out.println("Collection Manager starts running.");
        Scanner scanner = new Scanner(System.in);

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


        while(scanner.hasNextLine()) {
            String commandLineInput = scanner.next();

            if(commandLineInput.equals("P"))
                runDisplayCollection();
            else if(commandLineInput.equals("PD"))
                runDisplayCollectionByDate();
            else if(commandLineInput.equals("PG"))
                runDisplayCollectionByGenre();
            else if(commandLineInput.charAt(0) == 'A' && commandLineInput.charAt(1) == ',')
                runAddAlbum(commandLineInput);
            else if(commandLineInput.charAt(0) == 'D' && commandLineInput.charAt(1) == ',')
                runDeleteAlbum(commandLineInput);
            else if(commandLineInput.charAt(0) == 'L' && commandLineInput.charAt(1) == ',')
                runLendAlbum(commandLineInput);
            else if(commandLineInput.charAt(0) == 'R' && commandLineInput.charAt(1) == ',')
                runReturnAlbum(commandLineInput);
            else if(commandLineInput.equals("Q")) {
                System.out.println("Collection Manager terminated.");
                break;
            }
            else
                System.out.println("Invalid Command!");
        }
    }

    public void runDisplayCollection() {

    }
    public void runDisplayCollectionByDate() {

    }

    public void runDisplayCollectionByGenre() {

    }

    // Check if date is valid
    public void runAddAlbum(String albumDetails) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");

        String title = "";
        String artist = "";
        String genre = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();
        genre = stringTokenizer.nextToken();
        Date releaseDate = new Date(stringTokenizer.nextToken());
        Date currentDate = new Date();

        if(releaseDate.isValid() && releaseDate.compareTo(currentDate) <= 0) {
            System.out.println("Valid Date!");
        }
        else{
            System.out.println("Invalid Date!");
        }
    }

    public void runDeleteAlbum(String albumDetails) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");
        String title = "";
        String artist = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();
    }

    public void runLendAlbum(String albumDetails) {
        StringTokenizer stringTokenizer = new StringTokenizer(albumDetails, ",");
        String title = "";
        String artist = "";

        stringTokenizer.nextToken();
        title = stringTokenizer.nextToken();
        artist = stringTokenizer.nextToken();
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
