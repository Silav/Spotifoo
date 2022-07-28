import Model.SongInfo;

import java.util.ArrayList;
import java.util.Scanner;

import static Controller.SongsController.*;
import static View.ConsoleView.takeInput;

public class Main
{
    public static void main(String[] args)
    {

        while(true) {
            String choice="";
            menu();
            Scanner inp = new Scanner(System.in);
            ArrayList<SongInfo> allSongs = new ArrayList<>(getAllSongs());

            do
            {
                takeInput();
                choice = inp.nextLine();

                if(checkChoice(choice, 5) || choice.equals("0")) {
                    displayInvalidOption();
                }
            }
            while (checkChoice(choice, 5) || choice.equals("0"));
            switch (choice)
            {
                case "1":
                {

                    displayAllMenuName(allSongs, 0);
                    choice = inp.nextLine();

                    while(checkChoice(choice, allSongs.size()))
                    {
                        displayInvalidOption();
                        takeInput();
                        choice = getChoice();

                    }
                    if(!choice.equals("0")) {
                        PlaySong(allSongs, Integer.parseInt(choice.trim()) - 1);
                    }
                    break;
                }
                case "2":
                {
                    while(checkChoice(choice, allSongs.size()))
                    {
                        displayInvalidOption();

                        takeInput();

                        choice = getChoice();

                    }
                  displayAllMenuName(allSongs, 1);

                    break;
                }
                case "3":
                {
                    while(checkChoice(choice, allSongs.size()))
                    {
                        displayInvalidOption();

                        takeInput();

                        choice = getChoice();

                    }
                    displayAllMenuName(allSongs, 2);
                    break;
                }
                case "4":
                {
                    while(checkChoice(choice, allSongs.size()))
                    {
                        displayInvalidOption();
                        takeInput();
                        choice = getChoice();

                    }
                    displayGenreMenu(allSongs);

                    break;
                }
                case "5":
                {
                    while(checkChoice(choice, allSongs.size()))
                    {
                        displayInvalidOption();
                        takeInput();
                        choice = getChoice();

                    }
                    displayAllMenuName(allSongs, 4);

                    break;
                }
                default:
                    displayInvalidOption();
            }
        }
    }
}
