package TypeRacer.Players;

import java.io.Serializable;
import java.util.ArrayList;

public class ChampionList implements Serializable {
    ArrayList<Champion> championArrayList = new ArrayList<Champion>();

    public ChampionList() {
    }

    public ChampionList(ArrayList<Champion> championArrayList) {
        this.championArrayList = championArrayList;
    }

    public ArrayList<Champion> getChampionArrayList() {
        return championArrayList;
    }

    public void setChampionArrayList(ArrayList<Champion> championArrayList) {
        this.championArrayList = championArrayList;
    }

    @Override
    public String toString() {
        return "ChampionList{" +
                "championArrayList=" + championArrayList +
                '}';
    }
}
