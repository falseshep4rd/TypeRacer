package TypeRacer;

import TypeRacer.FXControllers.PlayController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTestCalculations {
    @Test
    public void testCalculateWPM(){
        PlayController playController = new PlayController();
        int number = 600;
        double seconds = 60;
        int expected = 120;

        Assertions.assertEquals(playController.calculateWPM(number, seconds), expected);
    }
}