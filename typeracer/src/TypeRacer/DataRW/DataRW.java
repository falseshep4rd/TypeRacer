package TypeRacer.DataRW;

import TypeRacer.Players.ChampionList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataRW {
    public static String[] loadFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/Words"));
            List<String> words = new ArrayList<>();
            String word;

            while ((word = reader.readLine()) != null) {
                words.add(word);
            }
            reader.close();
            return words.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeIntoFile(ChampionList championList) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Leaderboards.lib"));
            oos.writeObject(championList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ChampionList loadLeaderboards() {
        ChampionList championList = new ChampionList();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Leaderboards.lib"));
            championList = (ChampionList) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return championList;
    }

    public static void deleteFile(String path){
        File file = new File(path);{
            if(file.delete()){
                System.out.println("Deleted: " + file.getName());
            } else {
                System.out.println("File doesn't exist");
            }
        }
    }

}
