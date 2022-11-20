package hippodrome;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HippodromeMainApp {

    public static void main(String[] args) {

        List<Participant> participantList = new ArrayList<>();
        participantList.add(new AkitaDog("Akita Dog", 6.4, 2.9));
        participantList.add(new AmericanQuarterHorse("American Quarter Horse", 10, 4.5));
        participantList.add(new ArabianHorse("Arabian Horse", 8, 5.2));
        participantList.add(new BelgianMalinoisDog("Belgian Malinois Dog", 5.7, 6.3));
        participantList.add(new BoradorDog("Borador Dog", 4.9, 3.5));
        participantList.add(new GermanShepherdDog("German Shepherd Dog", 4.85, 1.8));
        participantList.add(new MorganHorse("Morgan Horse", 5.7, 13));
        participantList.add(new ThoroughbredHorse("Thoroughbred Horse", 4.2, 4.9));

        Thread race = new Thread(new Race(new Circle(2000), participantList));
        race.start();

        try {
            race.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Participant> collect = participantList.stream()
                .sorted(Comparator.comparingDouble(Participant::getDistanceDone).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
