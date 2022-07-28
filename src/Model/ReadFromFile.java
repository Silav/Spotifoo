package Model;

import java.io.*;
import java.util.ArrayList;

public class ReadFromFile
{
    public static ArrayList<String> readFile(){
        ArrayList<String> content= new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(new FileReader("assets/data.txt"));
            String current;

            while ((current = br.readLine()) != null) {
                content.add(current);
            }
            br.close();
        }
        catch(IOException exp) {
            System.out.println("Error!");
            exp.printStackTrace();
        }
        return content;
    }
}
