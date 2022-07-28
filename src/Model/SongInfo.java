package Model;

public class SongInfo
{
    private String song_name;
    private String artist;
    private String album_name;
    private String song_file;
    private String image;
    private String genre;

    public SongInfo(String s,String a,String a_n, String g, String s_f,String i){
        song_name=s;
        artist=a;
        album_name=a_n;
        song_file= s_f;
        image = i;
        genre = g;
    }

    public String getSongName(){
        return  song_name;
    }
    public String getArtist(){
        return  artist;
    }
    public String getAlbumName(){
        return  album_name;
    }
    public String getSongFile(){
        return  song_file;
    }
    public String getImage(){
        return  image;
    }
    public String getGenre(){
        return  genre;
    }

}
