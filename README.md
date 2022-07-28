# Spotifoo
A basic terminal application:
# Introduction : 
The application is a command line interface (terminal) application that does not have a graphical user interface (JavaFX) or web interface (Angular, React, Vue).
The user only navigates by typing a number from an option list and then press enter to execute the command.
Typing 0 and pressing enter in any part of the application will send you back to the main menu.

<img width="202" alt="Untitled" src="https://user-images.githubusercontent.com/58553805/181650729-56c3ea48-7f55-4724-b565-907ac39b2d83.png">


## Mandatory requirements:
1. PLAY A SONG: 
By choosing option #1 on the main menu, the app must show a list of songs by reading the text file located inside the asset folder.
When the user chooses a specific song, the music file should open in the default music player installed in your computer.In addition, it should also open the corresponding album art. Or show a placeholder image if the album art is not found.
📝 Note: Only open the album art, if the app can play the song.

2. FILTER BY ARTIST: 
When pressing option #2 on the main menu, the app will replace the main menu options with a list of artists available based on the .txt file. By choosing one of the artists will in turn, show a list of songs that belong to the selected artist.

3. FILTER BY ALBUM: 
Option #3 on the main menu, replace the main menu options with a list of albums available based on the .txt file. 

4. FILTER BY GENRE: 
Option #4 on the main menu, the app should show a list of genres. The only four genres available are: Metal, Pop, Reggaeton, and Rock

5. SEARCH: 
By choosing option #5 on the main menu, the app should allow me to perform a search based solely on the name of the songs. 
The app must prompt the user to input some text. Then the app must display a list of songs that matches the whole text or part of the text inside the name of a song.

## Extra requirements
1. INFINITY SCANNER: 
The app shows a nice error message instead of weird debugging text that normal users would be scared of. Now it's time to take it to the next level.
If for some reason you cannot play a song, the app should allow you to choose another song without needing to re-enter the app.

2. SUPER SEARCH: 
The user will be able to perform searches based not only on the song name, but the artist and album.
This should be a single, unified search system instead of having different menus like the filter menus.

3. CREATE AND EDIT PLAYLISTS: 
The user will be able to create a playlist with a custom name and the capacity to and remove the existing songs to this curated list.
The intention is to quickly find your favorite songs without needing to scroll through the large song list.


* In this project the mandatory requirements and (INFINITY SCANNER and SUPER SEARCH) from extra onse have been developed.

## Project structure
The project is devided based on the mvc (Model View Controller). Where the Model contains reading of the file the data.txt and the Controller contains the logic for
example searching the songs and anything related functionality that requires the logic behind it, and the View
contains all the interfaces. Apart from that there is also Main file that is basicaly the main flow of the program which triggers all the functions.

## How to run
* Create a jar file https://www.youtube.com/watch?v=_XQjs1xGtaU.
* The jar file and the assets folder must be in the same place to be able to run it.
* Use cmd (command line) to run by writing the following 
```bash
java -jar Spotifoo.jar
``` 
