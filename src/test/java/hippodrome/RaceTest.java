package hippodrome;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RaceTest {

    private AkitaDog dog;
    private AmericanQuarterHorse horse;
    private Race race;

    @BeforeEach
    public void init() {
        List<Participant> list = new ArrayList<>();

        dog = new AkitaDog("Akita Dog", 6.4, 2.9);
        list.add(dog);

        horse = new AmericanQuarterHorse("American Quarter Horse", 10, 4.5);
        list.add(horse);

        Circle circle = new Circle(100);
        race = new Race(circle, list);
    }

    @Test
    void checkWinner() {
        dog.setDistanceDone(101);
        race.checkWinner();
        Assertions.assertTrue(dog.isFinished());
        Assertions.assertFalse(horse.isFinished());
    }

    @Test
    void raceEnd() {
        race.raceEnd();
        Assertions.assertTrue(dog.isFinished());
        Assertions.assertTrue(horse.isFinished());
    }

    @Test
    void setStartPosition() {
        race.setStartPosition(dog);
        Assertions.assertEquals(1, dog.getStartingPosition());
        race.setStartPosition(horse);
        Assertions.assertEquals(2, horse.getStartingPosition());
    }
}