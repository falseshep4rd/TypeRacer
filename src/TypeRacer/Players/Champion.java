package TypeRacer.Players;

import java.io.Serializable;

public class Champion extends Player implements Serializable {
    private String description;
    private int score;
    static Champion champion;

    public static Champion getInstance() {
        return  champion;
    }
    public Champion() {
    }

    public Champion(String description, int score) {
        this.description = description;
        this.score = score;
    }

    public Champion(String name, String username, String description, int score) {
        super(name, username);
        this.description = description;
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Champion: " + this.name +
                ", score: " + this.score +
                ", description: " + this.description +
                ", username: " + this.username;
    }
}
