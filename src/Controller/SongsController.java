package Controller;

import Model.ReadFromFile;
import Model.SongInfo;
import View.ConsoleView;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static View.ConsoleView.*;


public class SongsController {
    public static ArrayList<SongInfo> getAllSongs() {

        ArrayList<String> songs = new ArrayList<>(ReadFromFile.readFile());
        ArrayList<SongInfo> songInfoArrayList = new ArrayList<SongInfo>();
        for (int i = 0; i < songs.size(); i++) {
            String[] songsSplit = songs.get(i).split(",");
            songInfoArrayList.add(new SongInfo(songsSplit[0], songsSplit[1], songsSplit[2], songsSplit[3], songsSplit[4], songsSplit[5]));
        }
        return songInfoArrayList;

    }
    private static ArrayList<String> getArtistNames(ArrayList<SongInfo> arr)
    {
        ArrayList<String> artistName = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            artistName.add(arr.get(i).getArtist());
        }
        return artistName;
    }
    private static void displayArtist(ArrayList<SongInfo> arr)
    {
        ArrayList<String> temp = getArtistNames(arr);
        ConsoleView.displayArtistAndAlbumName(temp, "ar", arr);

    }

    private static ArrayList<String> getAlbumNames(ArrayList<SongInfo> arr)
    {
        ArrayList<String> artistName = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            artistName.add(arr.get(i).getAlbumName());
        }
        return artistName;
    }

    private static void displayAlbums(ArrayList<SongInfo> arr)
    {
        ArrayList<String> temp = getAlbumNames(arr);
        ConsoleView.displayArtistAndAlbumName(temp, "al", arr);

    }

    public static String getChoice()
    {
        Scanner inp = new Scanner(System.in);
        return inp.nextLine();
    }

    public static void PlaySong(ArrayList<SongInfo> arr, int index)
    {
        try {
            if(!(arr.get(index).getSongFile().equals("no file"))) {
                System.out.println("▶" + " Playing file!");
                File f = new File("assets/songs/" + arr.get(index).getSongFile());
                if(f.exists()) {
                    Desktop.getDesktop().open(f);
                }
                else {
                    System.out.println("\u274C" + " could not play song");
                }
                if(!(arr.get(index).getImage().equals("no file"))) {
                    f = new File("assets/albums/" + arr.get(index).getImage());
                    if(f.exists()) {
                        Desktop.getDesktop().open(f);
                    }
                    else {
                        Desktop.getDesktop().open(new File("assets/no-picture.png"));
                    }
                }
                else {
                    Desktop.getDesktop().open(new File("assets/no-picture.png"));
                }
                System.exit(0);
            }
            else
            {
                System.out.println("\u274C" + " could not play song");
                TimeUnit.SECONDS.sleep(1);
            }

        }
        catch (Exception e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public static void menu()
    {
        ConsoleView.menu();
    }

    public static void displayAllMenuName(ArrayList<SongInfo> arr, int position)
    {
        if(position==0)
        {
            displaySongMenu(arr, position);
        } else if(position==1)
        {
            displayArtist(arr);
        }
        else if(position==2) {
            displayAlbums(arr);
        }
        else if(position==4)
        {
            displaySearchSongMenu();
            String searchby = getChoice();
            findSongsBySearchType("search", arr, searchby);
        }

    }

    public static void findSongsBySearchType(String searchType, ArrayList<SongInfo> arr, String searchBy)
    {
        ArrayList<SongInfo> tmp_Songs = new ArrayList<SongInfo>();
        for(int i=0; i< arr.size();i++) {
            if (searchType.equals("ar"))
            {
                if(arr.get(i).getArtist().equals(searchBy))
                {
                    tmp_Songs.add(arr.get(i));
                }
            }
            else if (searchType.equals("al"))
            {
                if(arr.get(i).getAlbumName().equals(searchBy))
                {
                    tmp_Songs.add(arr.get(i));
                }
            }
            else if(searchType.equals("gn"))
            {
                if(arr.get(i).getGenre().equals(searchBy))
                {
                    tmp_Songs.add(arr.get(i));
                }
            }
            else if(searchType.equals("search"))
            {
                if((arr.get(i).getSongName().toLowerCase().contains(searchBy.toLowerCase())) || (arr.get(i).getAlbumName().toLowerCase().contains(searchBy.toLowerCase())) || (arr.get(i).getArtist().toLowerCase().contains(searchBy.toLowerCase())))
                {
                    tmp_Songs.add(arr.get(i));
                }
            }
        }
        String tmp_choice = "";

            if(searchType.equals("search")) {
                if (tmp_Songs.size() <= 0) {
                    System.out.println("No results found related to searchBy");
                    System.exit(0);
                }
            }
            displaySongMenu(tmp_Songs, 0);

            tmp_choice = getChoice();

        do {
            while(checkChoice(tmp_choice, tmp_Songs.size()))
            {
                displayInvalidOption();

                takeInput();

                tmp_choice = getChoice();

            }

            if(!(tmp_choice.equals("0"))) {
                PlaySong(tmp_Songs, (Integer.parseInt(tmp_choice.trim()) - 1));
                break;
            }

        }
        while (!(tmp_choice.equals("0")));
    }

    public static boolean checkChoice(String choice, int size)
    {
        Pattern p = Pattern.compile("\\s+");
        Matcher m = p.matcher(choice);
        boolean flag = m.find();
        if(flag)
        {
            return true;
        }
        if (choice.matches(".*[a-z].*")) {
            return true;
        }
        for(int i=0; i <= size;i++)
        {
            if((Integer.parseInt(choice.trim()) >= 0) && (Integer.parseInt(choice.trim()) <= size))
            {
                return false;
            }

        }
        return true;
    }

    public static void displayGenreMenu(ArrayList<SongInfo> arr)
    {
        ConsoleView.displayGenreMenu(arr);
    }
    public static void displayInvalidOption()
    {
        ConsoleView.displayInvalidOption();
    }
}
