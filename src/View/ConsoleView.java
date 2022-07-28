package View;

import Model.SongInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static Controller.SongsController.*;

public class ConsoleView{
    public static void menu()
    {
        displayBeforeMenu();
        System.out.println("Main menu Options:");
        System.out.println("[1] Songs");
        System.out.println("[2] Artists");
        System.out.println("[3] Albums");
        System.out.println("[4] Genres");
        System.out.println("[5] Search");
    }
    public static void displaySongMenu(ArrayList<SongInfo> arr, int position)
    {
        displayBeforeMenu();

        if(position==0)
        {
            System.out.println("songs menu");
        }

        for(int i = 0; i<arr.size();i++)
        {
            if(position==0)
            {
                System.out.println("["+(i+1)+"]"+" "+arr.get(i).getSongName());
            }

        }
        displayAfterMenu();
        takeInput();
    }

    public static void displaySearchSongMenu()
    {
        displayBeforeMenu();
        System.out.println("Search for a song: ");
        System.out.print("Write the name of a song, artist, or album to search for songs and press enter: ");
    }

    public static void displayGenreMenu(ArrayList<SongInfo> arr)
    {
        String temp_choice="";

            displayBeforeMenu();
            System.out.println("Genre available: ");
            System.out.println("[1] metal");
            System.out.println("[2] pop");
            System.out.println("[3] reggaeton");
            System.out.println("[4] rock");

        displayAfterMenu();

            do
            {
                takeInput();

                temp_choice = getChoice();

                if(checkChoice(temp_choice, 4)) {
                    displayInvalidOption();
                }
            }
            while (checkChoice(temp_choice, 4));

            switch (temp_choice) {
                case "1": {
                    findSongsBySearchType("gn", arr, "metal");
                    break;
                }
                case "2": {
                    findSongsBySearchType("gn", arr, "pop");
                    break;
                }
                case "3": {
                    findSongsBySearchType("gn", arr, "reggaeton");
                    break;
                }
                case "4": {
                    findSongsBySearchType("gn", arr, "rock");
                    break;
                }           
            }
    }
   
    public static void displayArtistAndAlbumName(ArrayList<String> l, String For, ArrayList<SongInfo> arr)
    {
        String temp_choice;

        displayBeforeMenu();

        if(For.equals("ar"))
        {
            System.out.println("artist available");
        } else if (For.equals("al")) {
            System.out.println("album available");
        }
        List<String> list = new ArrayList<String>(l);
        list = list.stream().distinct().collect(Collectors.toList());
        Collections.sort(list);

        for(int i =0; i< list.size();i++)
        {
            System.out.println("["+(i+1)+"] "+ list.get(i));
        }

        displayAfterMenu();
        takeInput();

        temp_choice = getChoice();


        while (checkChoice(temp_choice, list.size())) {
            displayInvalidOption();
            takeInput();
            temp_choice = getChoice();

        }


        if(!temp_choice.equals("0")) {
            if (For.equals("ar")) {
                findSongsBySearchType("ar", arr, list.get(Integer.parseInt(temp_choice.trim())-1));
            } else if (For.equals("al")) {
                findSongsBySearchType("al", arr, list.get(Integer.parseInt(temp_choice.trim())-1));
            }
        }
    }


    public static void displayInvalidOption()
    {
        System.out.println("\u26A0 not a valid option");
    }

    private static void displayBeforeMenu()
    {
        cls();
        System.out.println("Welcome to Spotifoo music Player! \uD83C\uDFB6\n");
    }

    public static void cls()
    {
        try
        {
            String OperatingSystem = System.getProperty("os.name");
            if(OperatingSystem.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }catch(Exception E)
        {
            System.out.println(E);
        }
    }

    private static void displayAfterMenu()
    {
        System.out.println("[0] Back to main menu");
    }
    public static void takeInput()
    {
        System.out.print("Choose an option and press enter: ");
    }

}