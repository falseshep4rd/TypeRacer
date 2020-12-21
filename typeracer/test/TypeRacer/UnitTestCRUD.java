package TypeRacer;

import TypeRacer.Players.Champion;
import TypeRacer.Players.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UnitTestCRUD {

    @Test
    public void testChampionCreation() {
        String name = "Roger";
        String description = "Best of all time";
        String username = "Brown";
        int score = 99999;

        Champion champion = new Champion(name, username, description, score);

        Assertions.assertEquals(name, champion.getName());
        Assertions.assertEquals(username, champion.getUsername());
        Assertions.assertEquals(description, champion.getDescription());
        Assertions.assertEquals(score, champion.getScore());
    }

    @Test
    public void testPlayerCreation() {
        String name = "Roger";
        String username = "Me";

        Player player = new Player(name, username);

        Assertions.assertEquals(name, player.getName());
        Assertions.assertEquals(username, player.getUsername());
    }
}
